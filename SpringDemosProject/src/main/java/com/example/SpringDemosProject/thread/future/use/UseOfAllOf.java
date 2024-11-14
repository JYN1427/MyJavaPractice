package com.example.SpringDemosProject.thread.future.use;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-05-15 15:21:54
 */
public class UseOfAllOf {
    public static void main(String[] args) throws Exception {

        List<CompletableFuture<String>> futureList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> getString(finalI));
            futureList.add(future);
        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).get(5, TimeUnit.SECONDS);

        System.out.println("---");
        for (int i = 0; i < 10; i++) {
            String s = futureList.get(i).get();
            System.out.println(i + s);
        }
    }

    public static String getString(int i){
        System.out.println("...");
        try {
            if (i == 3) {
//                Thread.sleep(10000); // 触发超时
                Thread.sleep(4000); // 不触发超时
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "S";
    }
}