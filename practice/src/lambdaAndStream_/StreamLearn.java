package lambdaAndStream_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamLearn {
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
            说白了就是前面是调用方，直接去调用一个方法 。这也可以协程(x -> x.getName())
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
}
