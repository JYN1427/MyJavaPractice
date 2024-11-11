package org.example.common.lambdaAndStream_;

import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamLearn {

    public static List dataList = java.util.stream.Stream.iterate(0, n -> n+1).limit(20).collect(Collectors.toCollection(CopyOnWriteArrayList::new));

    public static void main(String[] args) {
        /*
            1.stram()方法：将集合装为流
            2.collect()方法：将流转为集合
            3.filter()方法：将转为流的集合过滤出满足要求的流
            4.map()方法：将每个元素映射成新元素,每个元素做一些操作
            5.limit(n)：获取n个元素
            6.skip(n)：跳过n元素
            7.skip和limit组合实现分页（对数据库的压力没有减轻，只是看着分页了）
            8.distinct：去除重复元素


            (1)filter用于数据的过滤
                lists.stream()
                .filter(x -> x.length()>4)
                .forEach(y -> System.out.println(y));

            (2)map这个单词在这就是映射的意思
              map用于简单同类型转换：
                lists.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList())
                .forEach(y -> System.out.println(y));
              map还用于获取对象集合的某个属性集合：
                users.stream()
                .map(User::getName)
                .collect(toList());

        */

        /*
        双冒号
            比如Goods::getName、System.out::println
            说白了就是前面是调用方，直接去调用一个方法 。这也可以写作(x -> x.getName())
        箭头
            但是如果说必然要用到x的话，比如.map(x -> (x*2-3))这种
            用箭头是毋庸置疑的
        */

        List<String> stringList = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl", "");
        // 把非空字符串都筛选出来
        List<String> filtered = stringList.stream().filter(x -> !x.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);

        Goods mygoods1 = new Goods("避孕套", 108.5);
        Goods mygoods2 = new Goods("头套", 18.5);
        Goods mygoods3 = new Goods("枕套", 8.99);
        List<Goods> myGoodsList = new ArrayList<>();
        myGoodsList.add(mygoods1);
        myGoodsList.add(mygoods2);
        myGoodsList.add(mygoods3);

        // 两个冒号是对方法的引用。冒号左边的调用者是类名。
        List<String> goods = myGoodsList.stream().map(Goods::getName).collect(Collectors.toList());
        System.out.println(goods); // [避孕套, 头套, 枕套]
        List<Double> prices = myGoodsList.stream().map(x -> x.getPrice()).collect(Collectors.toList());
        System.out.println(prices); // [108.5, 18.5, 8.99]

        prices.stream().limit(2).forEach(System.out::println); // 108.518.5


        goods.forEach(x -> System.out.println("foreach商品："+x));


        // ---------------------------------------------
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        System.out.println(numbers);
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.println(squaresList.getClass());
        System.out.println(squaresList);
    }

    @Test
    public void testSkipAndLimit() {
        List<Integer> myList = new ArrayList<>();
        for(int i=0; i < 103; i++) {
            myList.add(i);
        }

        int step = 4;
        double pageNum = Math.ceil(myList.size() / step);
        for(int i=0; i <= pageNum; i++) {
            System.out.println("\nPage No." + i + " ");
            List<Integer> after = myList.stream()
                    .skip(i*step)
                    .limit(step)
                    .collect(Collectors.toList());
            after.forEach(System.out::print);
        }
    }

    /**
     * Stream.iterate
     * limit
     * parallelStream
     */
    @Test
    public void testIterateAndParallel() {
        int size = 5;
        int stepSize = 3;

        // 一共循环size次 - 对应a
        Stream.iterate(0, n->n+1).limit(size).parallel()
                .map(a -> dataList.parallelStream().skip(a * stepSize).limit(stepSize).collect(Collectors.toList()))// 一次取stepSize个datalist的值
                .collect(Collectors.toList()) // [ [0, 1, 2],[3, 4, 5],[6, 7, 8],[9, 10, 11],[12, 13, 14] ]
                .parallelStream() // 返回并行的stream 充分利用多核优势
                .forEach(System.out::println);


        System.out.println("---");


        // 双循环
        int m = 3;
        int n = 5;
        int jStep = 2;
        Stream.iterate(1, i->i+1).limit(m).parallel()
                .map(x -> Stream.iterate(x, j->j*jStep).limit(n).parallel().collect(Collectors.toList()))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }


    /**
     * collect()里面toMap的话要指明如果key冲突了该怎么办, 比如(v1, v2) -> v2)
     */
    @Test
    public void testCollect(){
        List<Pair<String, Double>> pairArrayList = new ArrayList<>();
        pairArrayList.add(new Pair<>("version", 6.19));
        pairArrayList.add(new Pair<>("version", 10.24));
        pairArrayList.add(new Pair<>("version", 13.14));

        Map<String, Double> map = pairArrayList.stream().collect(
        // 生成的 map 集合中只有一个键值对：{version=13.14}
//                Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v1));
                Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));

        System.out.println(map.toString());



        // 然而需要注意, toMap的时候, key可以为null, value不可以为null, 会抛异常
        // (正常的HashMap 不论key还是value都是可以存null的)
        pairArrayList.add(new Pair<>(null, 3.14));
        Map<String, Double> map2 = pairArrayList.stream().collect(Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));
        System.out.println(map2.toString());

        pairArrayList.add(new Pair<>("test", null));
        Map<String, Double> map3 = pairArrayList.stream().collect(Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));
        System.out.println(map3.toString());
    }




}
