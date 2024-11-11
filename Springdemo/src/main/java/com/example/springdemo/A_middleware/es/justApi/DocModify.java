package com.example.springdemo.A_middleware.es.justApi;

import com.example.springdemo.A_middleware.es.EsTaskUtil;
import com.example.springdemo.oracle.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/07/09 21:01:57
 * @Version: 1.0.0
 */
public class DocModify {

    private static final String INDEX_NAME = "myuser";

    private static final String MY_TEST_DOC_ID = "1001";

    /**
     * 查询文档
     */
    @Test
    public void searchDoc() {
        EsTaskUtil.connect(client -> {
            //1.创建请求对象
            GetRequest request = new GetRequest()
                    .index(INDEX_NAME)
                    .id(MY_TEST_DOC_ID);
            //2.客户端发送请求，获取响应对象
            GetResponse response = client.get(request, RequestOptions.DEFAULT);
            // 3.打印结果信息
            System.out.println("_index:" + response.getIndex());
            System.out.println("_type:" + response.getType());
            System.out.println("_id:" + response.getId());
            System.out.println("source:" + response.getSourceAsString());
        });
    }

    /**
     * 插入文档
     *      指定了index及id
     */
    @Test
    public void insertDoc() {
        EsTaskUtil.connect(client -> {
            // 新增文档 - 请求对象
            IndexRequest request = new IndexRequest();

            // 设置索引及唯一性标识
            request.index(INDEX_NAME)
                    .id(MY_TEST_DOC_ID);

            // 创建数据对象
            User user = new User();
            user.setUsername("zhangsan");
            user.setEmail("123@qq.com");

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonStr = objectMapper.writeValueAsString(user);

            // 添加文档数据，数据格式为 JSON 格式
            request.source(jsonStr, XContentType.JSON);
            // 客户端发送请求，获取响应对象
            IndexResponse response = client.index(request, RequestOptions.DEFAULT);

            // 打印结果信息
            System.out.println("_index:" + response.getIndex());
            System.out.println("_id:" + response.getId());
            System.out.println("_result:" + response.getResult());
        });
    }

    /**
     * 更新文档
     *      指定json文档的一个 / 几个字段   做局部删除
     */
    @Test
    public void updateDoc() {
        EsTaskUtil.connect(client -> {
            // 修改文档 - 请求对象
            UpdateRequest request = new UpdateRequest();
            // 配置修改参数
            request.index(INDEX_NAME).id(MY_TEST_DOC_ID);
            // 设置请求体，对数据进行修改
            request.doc(XContentType.JSON,
                    "id", 1427L,
                    "username", "lisi");
            // 客户端发送请求，获取响应对象
            UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
            System.out.println("_index:" + response.getIndex());
            System.out.println("_id:" + response.getId());
            System.out.println("_result:" + response.getResult());
        });
    }

    /**
     * 根据id删除文档
     */
    @Test
    public void test() {
        EsTaskUtil.connect(client -> {
            //创建请求对象
            DeleteRequest request = new DeleteRequest().index(INDEX_NAME).id(MY_TEST_DOC_ID);
            //客户端发送请求，获取响应对象
            DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
            //打印信息
            System.out.println(response.toString());
        });

    }

}
