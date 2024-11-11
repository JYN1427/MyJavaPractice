package com.example.springdemo.thread.threadlocal.contact;

import com.example.springdemo.thread.threadlocal.common.ContextAuth;
import com.example.springdemo.thread.threadlocal.common.UserInfo;
import org.springframework.core.task.TaskDecorator;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2023-09-25 10:24:35
 */
public class MyTaskDecorator implements TaskDecorator {

    /**
     * 相当于在把任务交给线程池之前, 外面包了一层decorator装饰器, 跟AOP环绕有点像
     *
     * @param runnable
     * @return
     */
    @Override
    public Runnable decorate(Runnable runnable) {
        // 1 拿到主线程的threadLocal内容
        UserInfo userInfo = ContextAuth.get();

        // 2 执行子线程
        return () -> {
            try {
                // 2.1 为子线程中的threadLocal赋值
                ContextAuth.set(userInfo);
                // 2.2 子线程执行任务
                runnable.run();
            } finally {
                // 2.3 必须在执行完毕后情况子线程的threadLocal, 防止内存泄漏
                ContextAuth.clear();
            }
        };
    }
}
