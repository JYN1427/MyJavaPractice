package org.example.common.A_HighLevel;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author: Jia Yuning
 * @Description: Consumer的使用
 * @Date: 2023/06/26 12:43:04
 * @Version: 1.0.0
 */

/*
    * 方法引用是:
        Consumer<T>，这意味着它们采用参数且不返回任何内容。例如，System.out::println是Consumer<String>。
        Producer<T>，这意味着它们不带参数并返回某些内容。例如，UUID::randomUUID是Producer<UUID>。
        Function<T,Z>，这意味着它们采用类型T的参数（可以是应用该方法的实例）并返回类型Z的结果。
    */

public class ConsumerExample {
    public static void main(String args[]) {
        Consumer<Integer> consumer = i -> System.out.print(" " + i);
        Consumer<Integer> consumerWithAndThen = consumer.andThen(i -> System.out.print("(printed " + i + ")"));
        List<Integer> integerList =
                Arrays.asList(1, 2, 3, 4);
        printList(integerList, consumerWithAndThen);
    }

    public static void printList(List<Integer> listOfIntegers, Consumer<Integer> consumer) {
        for (Integer integer : listOfIntegers) {
            consumer.accept(integer);
        }
    }
}
