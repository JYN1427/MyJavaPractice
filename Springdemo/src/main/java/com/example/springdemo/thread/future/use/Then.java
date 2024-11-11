package com.example.springdemo.thread.future.use;

import cn.hutool.core.date.StopWatch;
import com.example.springdemo.thread.future.MyExecutorConfig;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/12/21 21:14:21
 * @Version: 1.0.0
 */
public class Then {
    private static ThreadPoolTaskExecutor taskExecutor;

    static  {
        MyExecutorConfig myExecutorConfig = new MyExecutorConfig();
        taskExecutor = myExecutorConfig.mytaskExecutor();
        taskExecutor.initialize();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        testThenRun();
//        testThenAccept();
        testThenApply();
    }

    /**
     * 调用thenRun方法执行第二个任务时，则第二个任务和第一个任务是共用同一个线程池。
     * 调用thenRunAsync执行第二个任务时，则第一个任务使用的是你自己传入的线程池，第二个任务使用的是ForkJoin线程池。
     */
    public static void testThenRun() throws ExecutionException, InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("run future1...");
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, taskExecutor);

        CompletableFuture<Void> future2 = future1.thenRun(() -> {
            System.out.println("run future2 after future1");
        });
        future2.get();
        stopWatch.stop();
        System.out.println(stopWatch.getLastTaskTimeMillis());
    }


    /**
     * 第一个任务执行完成后，执行第二个回调方法任务，会将该任务的执行结果，作为入参，传递到回调方法中，
     * 但是回调方法是没有返回值的。
     */
    public static void testThenAccept() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("run future1...");
            return "abc";
        }, taskExecutor);

        CompletableFuture<Void> future2 = future1.thenAccept(str -> {
            System.out.println("run future2 after future1");
            System.out.println(str + "!");
        });
    }


    /**
     * 表示第一个任务执行完成后，执行第二个回调方法任务，会将该任务的执行结果，作为入参，传递到回调方法中，
     * 并且回调方法是有返回值的。
     */
    public static void testThenApply() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("run future1...");
            return "abc";
        }, taskExecutor);

        CompletableFuture<String> future2 = future1.thenApply(str -> {
            System.out.println("run future2 after future1");
            return str + "!!";
        });

        System.out.println(future2.get());
    }
}
