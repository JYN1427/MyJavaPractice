package com.example.SpringDemosProject.service.es;

import com.example.SpringDemosProject.models.es.FileInfo;
import com.example.SpringDemosProject.models.vo.WarningInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.osgi.framework.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-10-17 16:09:35
 */
@Service
@Slf4j
public class ElasticsearchService {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;


    /**
     * 文档信息关键词联想(根据输入框的词语联想文件名称)
     *
     * @param warningInfoVo
     * @return
     */
    public List<String> getAssociationalWordOther(WarningInfoVo warningInfoVo) {
        //需要查询的字段
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery()
                .should(QueryBuilders.matchBoolPrefixQuery("fileName", warningInfoVo.getKeyword()));

        //contentType标签内容过滤
        // boolQueryBuilder.must(QueryBuilders.termsQuery("contentType", warningInfoDto.getContentType()));

        //构建高亮查询
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder)
                .withHighlightFields(
                        new HighlightBuilder.Field("fileName")
                )
                .withHighlightBuilder(
                        new HighlightBuilder()
                                .preTags("<span style='color:red'>")
                                .postTags("</span>")
                )
                .build();

        //查询
        SearchHits<FileInfo> search = null;
        try {
            search = elasticsearchRestTemplate.search(searchQuery, FileInfo.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ServiceException(String.format("操作错误，请联系管理员！%s", ex.getMessage()));
        }

        //设置一个最后需要返回的实体类集合
        List<String> resultList = new LinkedList<>();

        //遍历返回的内容进行处理
        for (org.springframework.data.elasticsearch.core.SearchHit<FileInfo> searchHit : search.getSearchHits()) {
            //高亮的内容
            Map<String, List<String>> highlightFields = searchHit.getHighlightFields();
            //将高亮的内容填充到content中
            searchHit.getContent()
                    .setFileName(highlightFields.get("fileName") == null ? searchHit.getContent().getFileName() : highlightFields.get("fileName").get(0));
            if (highlightFields.get("fileName") != null) {
                resultList.add(searchHit.getContent().getFileName());
            }
        }

        //list去重
        List<String> newResult = resultList.stream().distinct().collect(Collectors.toList());
        return newResult;
    }




    /**
     * 高亮分词搜索其它类型文档
     *
     * @param warningInfoVo
     * @return
     */
    public List<FileInfo> queryHighLightWordOther(WarningInfoVo warningInfoVo) {
        //分页
        Pageable pageable = PageRequest.of(warningInfoVo.getPageIndex() - 1, warningInfoVo.getPageSize());
        //需要查询的字段，根据输入的内容分词全文检索fileName和content字段
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery()
                .should(QueryBuilders.matchBoolPrefixQuery("fileName", warningInfoVo.getKeyword()))
                .should(QueryBuilders.matchBoolPrefixQuery("attachment.content", warningInfoVo.getKeyword()));
        //contentType标签内容过滤
        boolQueryBuilder.must(QueryBuilders.termsQuery("contentType", warningInfoVo.getContentType()));
        //构建高亮查询
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder)
                .withHighlightFields(
                        new HighlightBuilder.Field("fileName"), new HighlightBuilder.Field("attachment.content")
                )
                .withHighlightBuilder(new HighlightBuilder().preTags("<span style='color:red'>").postTags("</span>"))
                .withPageable(pageable)
                .build();
        //查询
        SearchHits<FileInfo> search = null;
        try {
            search = elasticsearchRestTemplate.search(searchQuery, FileInfo.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ServiceException(String.format("操作错误，请联系管理员！%s", ex.getMessage()));
        }
        //设置一个最后需要返回的实体类集合
        List<FileInfo> resultList = new LinkedList<>();
        //遍历返回的内容进行处理
        for (org.springframework.data.elasticsearch.core.SearchHit<FileInfo> searchHit : search.getSearchHits()) {
            //高亮的内容
            Map<String, List<String>> highlightFields = searchHit.getHighlightFields();
            //将高亮的内容填充到content中
            searchHit.getContent().setFileName(highlightFields.get("fileName") == null ? searchHit.getContent().getFileName() : highlightFields.get("fileName").get(0));
            searchHit.getContent().setContent(highlightFields.get("content") == null ? searchHit.getContent().getContent() : highlightFields.get("content").get(0));
            resultList.add(searchHit.getContent());
        }

        return resultList;
    }


}