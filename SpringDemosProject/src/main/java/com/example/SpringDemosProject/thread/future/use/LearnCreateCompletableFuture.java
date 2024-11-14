package com.example.SpringDemosProject.thread.future.use;

import com.example.SpringDemosProject.thread.future.MyExecutorConfig;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


/**
 * join()方法获取结果方法里不会抛异常，但是执行结果会抛异常，抛出的异常为CompletionException;
 * join()方法抛出的是uncheck异常（即未经检查的异常),不会强制开发者抛出。
 *
 * get()方法获取结果方法里将抛出异常，执行结果抛出的异常为ExecutionException;
 * get()方法抛出的是经过检查的异常，ExecutionException, InterruptedException 需要用户手动处理（抛出或者 try catch）
 *
 * 需要注意的是:
 *      get()方法是阻塞的，如果使用它来获取异步调用的返回值，需要添加超时时间。
 *      get(3, TimeUnit.SECONDS)
 *
 */
public class LearnCreateCompletableFuture {

    private static ThreadPoolTaskExecutor taskExecutor;

    static  {
        MyExecutorConfig myExecutorConfig = new MyExecutorConfig();
        taskExecutor = myExecutorConfig.mytaskExecutor();
        taskExecutor.initialize();
    }

    /**
     * get
     * get(3, TimeUnit.SECONDS)
     * join
     * getNow
     * @param args
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
//        useGet();
        useGetWithTimeOut();
//        useJoin();
//        useGetNow();
    }




    /**
     * 「supplyAsync」执行任务，支持返回值。
     * 「runAsync」执行任务，没有返回值。
     */
    public static CompletableFuture getSupplyAsync(String str) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//            int i = 1 / 0;
            try {
                System.out.println("异步执行ing");
                Thread.sleep(3000);
                return str + "abc";
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }, taskExecutor);
        return future;
    }


    public static void useJoin() {
        System.out.println("开始");
        CompletableFuture<String> future = getSupplyAsync("111");
        // 不需要捕获异常
        String s = future.join();
        System.out.println("结束");
    }


    public static void useGet() {
        System.out.println("开始");
        CompletableFuture<String> future = getSupplyAsync("111");
        try {
            String s = future.get();
        } catch (Exception e) {
            System.out.println(".get()方法捕获异常:" + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("结束");
    }

    public static void useGetNow() {
        System.out.println("开始");
        CompletableFuture<String> future = getSupplyAsync("111");
        try {
            Thread.sleep(1000);
            String s = future.getNow("默认值");
            System.out.println("主线程执行到getNow的时候就立即获取: " + s);
        } catch (Exception e) {
            System.out.println(".get()方法捕获异常:" + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("结束");
    }


    public static void useGetWithTimeOut() {
        System.out.println("开始");

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("future doing");
            MyExecutorConfig.sleepTool(5000L);
            System.out.println("finished");
            return "k";
        }, taskExecutor);

        try {
            String s = future.get(3L, TimeUnit.SECONDS);
        }catch (Exception e) {
            System.out.println("检测到异步处理超时");
        }

        System.out.println("结束");
    }


}
