package com.example.SpringDemosProject.http.util;

import org.apache.commons.collections4.MapUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2023-11-09 16:34:20
 */
public class MyHttpUtil {

    /**
     * Get请求 - 通过连接池
     * 把拼好参数的url和header放进来
     *
     * @param url
     * @param headerMap
     * @return
     */
    public static String doGetWithPool(String url, Map<String, String> headerMap) {
        CloseableHttpClient client = HttpPool.getClientFromHttpPool();

        HttpGet httpGet = new HttpGet(url);

        // 设置Header
        if (MapUtils.isEmpty(headerMap) || !headerMap.containsKey("Content-type")) {
            httpGet.addHeader("Content-type" , "text/html; charset=utf-8");
        }

        if (MapUtils.isNotEmpty(headerMap)) {
            headerMap.forEach(httpGet::addHeader);
        }

        long start = System.currentTimeMillis();
        String result = null;
        try {
            // 执行
            CloseableHttpResponse response = client.execute(httpGet);

            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
            }

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            // 释放连接
            // httpClient必须releaseConnection,但不是abort。
            // 因为releaseconnection是归还连接到到连接池,而abort是直接抛弃这个连接,而且占用连接池的数目。
            httpGet.releaseConnection();
        }

        System.out.println("end..Duration MS:" + (System.currentTimeMillis() - start));

        return result;
    }

    public static String doGetWithoutPool(String url, Map<String, String> headerMap) {
        CloseableHttpClient client = HttpClientBuilder.create().build();

        HttpGet httpGet = new HttpGet(url);

        // 设置Header
        if (MapUtils.isEmpty(headerMap) || !headerMap.containsKey("Content-type")) {
            httpGet.addHeader("Content-type" , "text/html; charset=utf-8");
        }

        if (MapUtils.isNotEmpty(headerMap)) {
            headerMap.forEach(httpGet::addHeader);
        }

        long start = System.currentTimeMillis();
        String result = null;
        CloseableHttpResponse response = null;
        try {
            // 执行
            response = client.execute(httpGet);

            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("end..Duration MS:" + (System.currentTimeMillis() - start));

        return result;
    }


    public static String makeGetURL(String url, Map<String, Object> map) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(url);
        uriBuilder.setCharset(StandardCharsets.UTF_8);
        if (map != null) {
            // 遍历map,拼接请求参数
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                uriBuilder.setParameter(key, value != null ? value.toString() : "");
            }
        }

        return uriBuilder.build().toString();
    }
}