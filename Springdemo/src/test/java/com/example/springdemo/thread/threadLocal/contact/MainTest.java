package com.example.springdemo.thread.threadLocal.contact;

import com.example.springdemo.thread.threadlocal.common.ContextAuth;
import com.example.springdemo.thread.threadlocal.common.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2023-09-25 10:21:48
 */
@SpringBootTest
public class MainTest {

    @Resource(name = "executorWithDecotator")
    ThreadPoolTaskExecutor taskExecutor;

    /**
     * 验证通过TaskDecorator实现: 子线程获取主线程threadLocal
     */
    @Test
    void test() throws InterruptedException {
        // 主线程设置threadLocal
        ContextAuth.set(new UserInfo("Jalen", "123", "YLJYWB"));

        // 子线程异步执行
        CompletableFuture<Void> future = CompletableFuture.runAsync(
                this::doTask,
                taskExecutor);

        // 主线程执行其他逻辑
        Thread.sleep(1000);

        // 主线程清理ThreadLocal
        ContextAuth.clear();
    }

    public void doTask() {
        UserInfo sonThreadUserInfo = ContextAuth.get();
        System.out.println(sonThreadUserInfo.toString());
    }
}
