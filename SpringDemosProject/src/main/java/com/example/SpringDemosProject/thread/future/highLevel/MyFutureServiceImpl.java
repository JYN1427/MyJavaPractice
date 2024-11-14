package com.example.SpringDemosProject.thread.future.highLevel;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/17 21:35:08
 * @Version: 1.0.0
 */
@Service
public class MyFutureServiceImpl implements MyFutureService{

    @Resource(name = "mytaskExecutor")
    ThreadPoolTaskExecutor mytaskExecutor;

    @Override
    public <T, R> List<R> parallelFutureJoin(Collection<T> list, Function<T, R> api, BiFunction<Throwable, T, R> exceptionHandle) {
        // 规整所有任务并执行, 获得一揽子CompletableFuture
        List<CompletableFuture<R>> futureList = list
                .stream()
                .map(model -> createFuture(
                        () -> api.apply(model),  // 传一个Supplier
                        e -> exceptionHandle.apply(e, model) // 传一个Function
                ))
                .collect(Collectors.toList());

        // 所有任务join, 统一返回
        return futureList.stream()
                .map(future -> future.join())
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public <T, R> CompletableFuture<R> getFuture(T model, Function<T, R> task, BiFunction<Throwable, T, R> exceptionHandle) {
        return createFuture(
                () -> task.apply(model),
                e -> exceptionHandle.apply(e, model)
        );
    }


    private <R> CompletableFuture<R> createFuture(Supplier<R> task, Function<Throwable, R> exceptionHandle) {
        // exceptionally接收一个Function<Throwable, R>, 捕获异常后给出一个设定的默认返回值
        return CompletableFuture.supplyAsync(task, mytaskExecutor).exceptionally(exceptionHandle);
    }
}
