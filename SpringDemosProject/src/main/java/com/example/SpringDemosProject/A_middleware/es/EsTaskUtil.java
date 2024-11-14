package com.example.SpringDemosProject.A_middleware.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/07/09 21:00:51
 * @Version: 1.0.0
 */
public class EsTaskUtil {
    public static void connect(MyEsTask task) {
        // 创建客户端对象
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        try {
            task.doTask(client);
            // 关闭客户端连接
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
