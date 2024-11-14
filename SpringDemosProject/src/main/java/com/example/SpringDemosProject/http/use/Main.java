package com.example.SpringDemosProject.http.use;

import cn.hutool.core.date.StopWatch;
import com.example.SpringDemosProject.http.util.MyHttpUtil;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 实际请求一下
 *
 * @author jiayn01
 * @date 2023-11-08 14:45:50
 */
public class Main {

    private static Map<String, String> headerMap= new HashMap<>();

    private static String url;

    private static ThreadPoolTaskExecutor executor= new ThreadPoolTaskExecutor();


    static {
        headerMap.put("X-Open-Token", "128302cdb1101b148df565cfc625a10a");
        url = "http://127.0.0.1:9906/api/crm/mis/pension/pension/scale/infoV2?pensionType=TRUSTOR";

        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(9999);
        executor.setKeepAliveSeconds(60);
        executor.setThreadNamePrefix("jyn-test");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
    }



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testTimeCost();
    }

    /**
     * test
     * 测一下用http连接池和不用 有啥区别
     */
    public static void testTimeCost() throws ExecutionException, InterruptedException {

        int num = 100;

        CompletableFuture<Long> poolFuture = CompletableFuture.supplyAsync(() -> {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            for (int i = 0; i < num; i++) {
                MyHttpUtil.doGetWithPool(url, headerMap);
            }
            stopWatch.stop();
            return stopWatch.getLastTaskTimeMillis();
        }, executor);

        CompletableFuture<Long> noPoolFuture = CompletableFuture.supplyAsync(() -> {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            for (int i = 0; i < num; i++) {
                MyHttpUtil.doGetWithoutPool(url, headerMap);
            }
            stopWatch.stop();
            return stopWatch.getLastTaskTimeMillis();
        }, executor);

        Long aLong = poolFuture.get();
        Long aLong1 = noPoolFuture.get();
        System.out.println(aLong);
        System.out.println(aLong1);
    }

}