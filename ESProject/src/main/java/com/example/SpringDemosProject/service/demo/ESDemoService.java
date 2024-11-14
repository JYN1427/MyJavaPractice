package com.example.SpringDemosProject.service.demo;

import com.example.SpringDemosProject.common.constants.ESConstant;
import com.example.SpringDemosProject.models.es.UniSearchResultInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.core.TimeValue;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexInformation;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.document.Document;
import org.springframework.data.elasticsearch.core.index.Settings;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-09-06 09:44:31
 */
@Slf4j
@Service
public class ESDemoService {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @PostConstruct
    public void init() {
        log.info("elasticsearchRestTemplate:" + elasticsearchRestTemplate);
    }

    /**
     * bool条件的写法demo
     * {
     *   "query": {
     *     "bool": {
     *       "must": [
     *         { "match": { "field1": "value1" } },
     *         { "range": { "field2": { "gte": 10, "lte": 20 } } }
     *       ],
     *       "should": [
     *         { "match": { "field3": "value3" } },
     *         { "term": { "field4": "value4" } }
     *       ],
     *       "must_not": [
     *         { "term": { "field5": "value5" } }
     *       ],
     *       "filter": [
     *         { "term": { "field6": "value6" } }
     *       ],
     *       "minimum_should_match": 1
     *     }
     *   }
     * }
     */
    public static void main(String[] args) {
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery()
                .must(QueryBuilders.matchQuery("field1", "value1"))
                .must(QueryBuilders.rangeQuery("field2")
                        .gte(10)
                        .lte(20))
                .should(QueryBuilders.matchQuery("field3", "value3"))
                .should(QueryBuilders.termQuery("field4", "value4"))
                .mustNot(QueryBuilders.termQuery("field5", "value5"))
                .filter(QueryBuilders.termQuery("field6", "value6"))
                .minimumShouldMatch(1);
        log.info(boolQueryBuilder.toString());

    }

    /**
     * 打印指定索引的信息
     */
    public void printIndexInfo() {
        List<IndexInformation> information = elasticsearchRestTemplate.indexOps(UniSearchResultInfoVO.class).getInformation();
        if (CollectionUtils.isNotEmpty(information)) {
            IndexInformation info = information.get(0);
            String name = info.getName();
            Document mapping = info.getMapping();
            Settings settings = info.getSettings();
            log.info("name:{}\n", name);
            log.info("mapping:{}\n", mapping);
            log.info("settings:{}", settings);
        }
    }

    /**
     * 查询方法
     */
    public void pageSearchDemo() throws IOException {
        // 分页
        int page = 0, size = 1;

        // 筛选条件
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery()
                .should(QueryBuilders.matchQuery("presAsset", 0))
                // .should(QueryBuilders.matchQuery("field4", "value4"))
                .minimumShouldMatch(1);

        // 1 使用elasticsearchRestTemplate
        this.searchByTemplate(page, size, boolQueryBuilder);

        // 2 使用restHighLevelClient
        this.searchByClient(page, size, boolQueryBuilder);

    }

    private void searchByTemplate(int page, int size, BoolQueryBuilder boolQueryBuilder) {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        PageRequest pageRequest = PageRequest.of(page, size);
        NativeSearchQuery searchQuery = builder
                .withQuery(boolQueryBuilder)
                .withPageable(pageRequest)
                .build();
        SearchHits<UniSearchResultInfoVO> searchHits = elasticsearchRestTemplate.search(searchQuery, UniSearchResultInfoVO.class);
        long totalHits = searchHits.getTotalHits();
        log.info("totalHits:{}", totalHits);
        for (SearchHit<UniSearchResultInfoVO> searchHit : searchHits) {
            UniSearchResultInfoVO content = searchHit.getContent();
            log.info("content:{}", content);
        }
    }

    private void searchByClient(int page, int size, BoolQueryBuilder boolQueryBuilder) throws IOException {
        SearchRequest searchRequest = new SearchRequest(ESConstant.CRM_SEARCH_MAINDATA_INXEX);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // searchSourceBuilder.sort("uniEsId", SortOrder.ASC);
        searchSourceBuilder.timeout(new TimeValue(15, TimeUnit.SECONDS));
        searchSourceBuilder.fetchSource(true).from(page).size(size);

        searchSourceBuilder.query(boolQueryBuilder);
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        org.elasticsearch.search.SearchHit[] hits = response.getHits().getHits();
        for (org.elasticsearch.search.SearchHit hit : hits) {
            log.info("hit:{}", hit);
        }
        long total = response.getHits().getTotalHits().value;
        log.info("total: {}", total);
    }
}
