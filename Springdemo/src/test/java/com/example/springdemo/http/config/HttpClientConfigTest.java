package com.example.springdemo.http.config;

import cn.hutool.core.date.StopWatch;
import com.example.springdemo.aaaIOC.MyBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/07/16 22:31:03
 * @Version: 1.0.0
 */
@Slf4j
@SpringBootTest
class HttpClientConfigTest {

    private static Map<String, String> headerMap= new HashMap<>();

    private static String url;

    @Resource(name="closeableHttpClient")
    private CloseableHttpClient httpClient;

    static {
        url = "http://127.0.0.1:9910/httpclienttestcontroller/demo?id=";
    }

    @Test
    public void test() throws IOException {
        log.info("---- 开始 ----");
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(() -> {
                StopWatch stopWatch = new StopWatch();
                stopWatch.start();
                String result = "-";
                try {
                    HttpGet httpGet = new HttpGet(url + finalI);
                    if (MapUtils.isNotEmpty(headerMap)) {
                        headerMap.forEach(httpGet::addHeader);
                    }
                    CloseableHttpResponse response = httpClient.execute(httpGet);
                    if (response.getStatusLine().getStatusCode() == 200) {
                        result = EntityUtils.toString(response.getEntity(), "UTF-8");

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    stopWatch.stop();
                    log.error("result: {}, 耗时{}", result, stopWatch.getLastTaskTimeMillis());
                }
            }).start();
        }
        log.info("---- 结束 ----");
    }

}