package com.example.springdemo.thread.future;

import cn.hutool.core.date.StopWatch;
import com.example.springdemo.thread.future.highLevel.MyFutureService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/17 21:34:12
 * @Version: 1.0.0
 */


@SpringBootTest
public class MainTest {

    @Autowired
    private MyFutureService myFutureService;

    @Resource(name = "mytaskExecutor")
    ThreadPoolTaskExecutor mytaskExecutor;

    /**
     * 测试parallelFutureJoin
     */
    @Test
    public void test() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("mutiTask");
        List<Integer> resList = myFutureService.parallelFutureJoin(
                Arrays.asList(1, 2, 3), num -> {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        return num;
                    }
                }, (e, num) -> {
                    System.out.println("发生了错误" + e);
                    return -1;
                });

        stopWatch.stop();
        resList.forEach(System.out::println);
        System.out.println(stopWatch.prettyPrint());
    }

    /**
     * 测试getFuture
     */
    @Test
    public void test1() {
        int num = 1;

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("异步task1");
        CompletableFuture<Integer> future1 = myFutureService.getFuture(
                1,
                model -> {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return model;
                },
                (e, model) -> {
                    System.out.println("发生了错误" + e);
                    return -1;
                }
        );
        stopWatch.stop();

        stopWatch.start("异步task2");
        CompletableFuture<Integer> future2 = myFutureService.getFuture(
                1,
                model -> {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return model;
                },
                (e, model) -> {
                    System.out.println("发生了错误" + e);
                    return -1;
                }
        );
        stopWatch.stop();

        stopWatch.start("主线程main");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(future1.join());
        System.out.println(future2.join());
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());
    }


    /**
     *
     */
    @Test
    public void testSubmit() {
        try {
            int x = 5;
            Future<Integer> future1 = mytaskExecutor.submit(() -> {
                System.out.println("x");
                return x;
            });

            Future<Integer> future2 = mytaskExecutor.submit(() -> {
                Thread.sleep(1000);
                System.out.println(x);
                int i = x / 0;
                return i;
            });

            future1.get();
            Integer i = future2.get();
        } catch (Exception e) {
            System.out.println("捕捉到子线程异常");
        }




    }


}
