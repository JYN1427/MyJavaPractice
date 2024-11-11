package com.example.springdemo.A_middleware.es;

import org.elasticsearch.client.RestHighLevelClient;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/07/09 20:59:55
 * @Version: 1.0.0
 */
@FunctionalInterface
public interface MyEsTask {
    void doTask(RestHighLevelClient client) throws Exception;
}
