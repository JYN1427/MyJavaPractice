package com.example.SpringDemosProject.thread.future.use;

import com.example.SpringDemosProject.thread.future.MyExecutorConfig;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/12/23 19:17:52
 * @Version: 1.0.0
 */
public class AllOfAnfAnyOf {

    private static ThreadPoolTaskExecutor taskExecutor;

    static  {
        MyExecutorConfig myExecutorConfig = new MyExecutorConfig();
        taskExecutor = myExecutorConfig.mytaskExecutor();
        taskExecutor.initialize();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testAllOf();
    }

    /**
     * allOf + get 等待所有任务完成
     */
    public static void testAllOf() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            MyExecutorConfig.sleepTool(1000L);
            return "future1";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            MyExecutorConfig.sleepTool(2000L);
            return "future2";
        });

        CompletableFuture<Void> all = CompletableFuture.allOf(future1, future2);

        // 将all阻塞, 等待所有任务都完成
        all.get();

        System.out.println(future1.get());
        System.out.println(future2.get());
    }


    /**
     * anyOf + get: 只要有一个任务完成
     */
    public static void testAnyOf() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            MyExecutorConfig.sleepTool(1000L);
            return "future1";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            MyExecutorConfig.sleepTool(2000L);
            return "future2";
        });

        CompletableFuture<Object> any = CompletableFuture.anyOf(future1, future2);

        // 将all阻塞, 等待所有任务都完成
        any.get();

        System.out.println(future1.get());
        System.out.println(future2.get());
    }
}
