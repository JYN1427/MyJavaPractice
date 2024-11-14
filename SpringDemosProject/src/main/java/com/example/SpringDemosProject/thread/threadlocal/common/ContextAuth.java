package com.example.SpringDemosProject.thread.threadlocal.common;

/**
 * ThreadLocal包装类 —— 一般写法
 * ThreadLocal包装类中: threadLocal和操作方法都是静态的
 *
 * @author jiayn01
 * @date 2023-09-25 10:20:00
 */
public class ContextAuth {
    private static final ThreadLocal<UserInfo> userInfoThreadLocal = new ThreadLocal<>();

    public static UserInfo get() {
        return userInfoThreadLocal.get();
    }

    public static void set(UserInfo userInfo) {
        userInfoThreadLocal.set(userInfo);
    }

    public static void clear() {
        userInfoThreadLocal.remove();
    }
}
