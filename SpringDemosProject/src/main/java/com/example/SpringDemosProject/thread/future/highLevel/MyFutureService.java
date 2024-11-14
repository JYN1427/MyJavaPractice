package com.example.SpringDemosProject.thread.future.highLevel;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/17 22:57:07
 * @Version: 1.0.0
 */
public interface MyFutureService {
    /**
     * 批量处理, 批量返回
     *
     * @param list 入参列表
     * @param api api列表
     * @param exceptionHandle 异常处理逻辑
     * @return 结果列表
     * @param <T> 交给异步现场处理的入参类型
     * @param <R> 处理完的返回类型
     */
    <T, R> List<R> parallelFutureJoin(Collection<T> list, Function<T, R> api, BiFunction<Throwable, T, R> exceptionHandle);


    /**
     * 获取future对象
     *
     * @param task
     * @param exceptionHandle
     * @param <R>
     * @return
     */
    <T, R> CompletableFuture<R> getFuture(T model, Function<T, R> task, BiFunction<Throwable, T, R> exceptionHandle);
}
