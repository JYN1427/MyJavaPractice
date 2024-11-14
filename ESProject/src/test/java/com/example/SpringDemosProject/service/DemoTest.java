package com.example.SpringDemosProject.service;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-09-09 13:17:34
 */
@SpringBootTest
public class DemoTest {

    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void test() throws IOException {
        // 查询索引 - 请求对象
        GetIndexRequest request = new GetIndexRequest("crm_search_maindata");
        // 发送请求，获取响应
        GetIndexResponse response = restHighLevelClient.indices().get(request,
                RequestOptions.DEFAULT);

        System.out.println("aliases:"+response.getAliases());
        System.out.println("mappings:"+response.getMappings());
        System.out.println("settings:"+response.getSettings());
    }

}
