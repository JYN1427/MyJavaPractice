package com.example.springdemo.thread.future.use;

import com.example.springdemo.thread.future.MyExecutorConfig;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/12/21 21:30:17
 * @Version: 1.0.0
 */
public class WhenCompleteAndExceptionally {
    private static ThreadPoolTaskExecutor taskExecutor;

    static  {
        MyExecutorConfig myExecutorConfig = new MyExecutorConfig();
        taskExecutor = myExecutorConfig.mytaskExecutor();
        taskExecutor.initialize();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        testWhenCompleteAndExceptionally();
    }

    /**
     * 当CompletableFuture的任务不论是正常完成还是出现异常它都会调用 「whenComplete」回调函数。
     * 如果用supplyAsync, 会把返回值和异常一并交给WhenComplete, 很有意思, 然后异常会再交给exceptionally
     */
    public static void testWhenCompleteAndExceptionally() throws ExecutionException, InterruptedException {
        CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> {
            if (0 < 0.5) {
                throw new RuntimeException("出错了");
            }
            System.out.println("正常结束");
            return 0.11;

        }).whenComplete((result, throwable) -> {
            if (result == null) {
                System.out.println("whenComplete result is null");
            } else {
                System.out.println("whenComplete result is " + result);
            }
            if (throwable == null) {
                System.out.println("whenComplete throwable is null");
            } else {
                System.out.println("whenComplete throwable is " + throwable.getMessage());
            }
        }).exceptionally((throwable) -> {
            System.out.println("exceptionally中异常：" + throwable.getMessage());
            return 0.0;
        });

        System.out.println("最终返回的结果 = " + future.get());
    }
}
