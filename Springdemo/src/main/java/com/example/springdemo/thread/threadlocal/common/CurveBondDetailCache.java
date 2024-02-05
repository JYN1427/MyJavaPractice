package com.example.springdemo.thread.threadlocal.common;

import java.util.HashMap;
import java.util.Map;

/**
 * ThreadLocal包装类 —— 如果是Map的写法, Map起到一个缓存的作用
 *
 * @author jiayn01
 * @date 2023-10-12 14:10:45
 */
public class CurveBondDetailCache {

    private static final ThreadLocal<Map<String, CurveBondDetail>> threadLocal = new ThreadLocal<>();

    /**
     * 使用之前初始化一下
     */
    public static void init() {
        remove();
        Map<String, CurveBondDetail> cache = new HashMap<>(64);
        threadLocal.set(cache);
    }

    /**
     * 为啥只有get没有set呢? 因为存的是Map, 需要get出来再put
     * @return
     */
    public static Map<String, CurveBondDetail> get() {
        Map<String, CurveBondDetail> cache = threadLocal.get();
        return cache == null ? new HashMap<>(64) : cache;
    }

    public static void remove() {
        threadLocal.remove();
    }

}



class CurveBondDetail{}