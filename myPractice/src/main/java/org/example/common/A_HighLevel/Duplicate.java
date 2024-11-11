package org.example.common.A_HighLevel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

/**
 * @Author: Jia Yuning
 * @Description: 去掉列表中的重复元素
 * @Date: 2023/06/26 12:18:00
 * @Version: 1.0.0
 */
public class Duplicate {
    public static void main(String[] args) {
        // 1 用set去重: 推荐
        calFunctionTime(getTestList(), Duplicate::useSet2Distinct);

        // 3 使用遍历contains()去重: 不推荐
        calFunctionTime(getTestList(), (list) -> Duplicate.useSet2Distinct(list));
    }

    // 测试函数执行的时间
    /*
    * 方法引用是:
        Consumer<T>，这意味着它们采用参数且不返回任何内容。例如，System.out::println是Consumer<String>。
        Producer<T>，这意味着它们不带参数并返回某些内容。例如，UUID::randomUUID是Producer<UUID>。
        Function<T,Z>，这意味着它们采用类型T的参数（可以是应用该方法的实例）并返回类型Z的结果。
    */
    public static void calFunctionTime(List<String> testList, Consumer<List<String>> consumer) {
        long start = System.currentTimeMillis();
        consumer.accept(testList);
        long end = System.currentTimeMillis();
        System.out.println("耗时: " + String.valueOf((end - start)));
    }

    // 构建一个含重复元素的列表
    public static List<String> getTestList() {
        List<String> testList = new ArrayList<>();
        // 构造1000个重复元素:
        for(int i=0; i<1000; i++) {
            testList.add(i+"");
        }
        for(int i=0; i<1000; i++) {
            testList.add(i+"");
        }
        return testList;
    }

    // 1 用set去重: 推荐
    public static void useSet2Distinct(List<String> beforeList) {
        Set<String> afterSet = new HashSet<>(beforeList);
        List<String> afterList = new ArrayList<>(afterSet);
    }



    // 3 使用遍历contains()去重: 不推荐
    public static void useContains2Distinct(List<String> beforeList) {
        List<String> afterList = new ArrayList<>();
        for(int i = 0; i < beforeList.size(); i++) {
            String now = beforeList.get(i);
            if(!afterList.contains(now)) {
                afterList.add(now);
            }
        }
    }


}


