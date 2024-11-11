package org.example.common.ArrayList_;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListLearn {
    public static void main(String[] args) {
        // 1. ArrayList定义
        // 这样定义的时候可以加入各种类型的对象，因为没用泛型
        List myList = new ArrayList();
        List mySublist = Arrays.asList(7,8,9,'1');
        myList.add("abc");
        myList.add("123");
        myList.add(100);
        myList.add(mySublist);
        myList.add("abc");

        myList.set(2, "zzz");

        System.out.println(myList);
        System.out.println("第一次出现abc：" + myList.indexOf("abc") + "\t最后一次出现abc：" + myList.lastIndexOf("abc"));
        Integer x = (Integer) myList.get(2);

        // 2. ArrayList遍历的两种方式：
        // .size, .add, .get, iterator
        // Java Object 类是所有类的父类，也就是说 Java 的所有类都继承了 Object
        List mylist2 = new ArrayList(); // 创建ArrayList()集合
        Product pd1 = new Product(4, "木糖醇", 10);
        Product pd2 = new Product(5, "洗发水", 12);
        Product pd3 = new Product(3, "热水壶", 49);
        mylist2.add(pd1);
        mylist2.add(pd2);
        mylist2.add(pd3);
        System.out.println("*************** 商品信息 ***************");
        for (int i = 0; i <mylist2.size(); i++) {
            // 循环遍历集合，输出集合元素
            Product product = (Product) mylist2.get(i); // get返回的是object类型，要强制转换一下
            System.out.println(product); // 当对象被打印，就自动调用toString方法
        }

        // 迭代器
        Iterator myIterator = mylist2.iterator();
        while(myIterator.hasNext()){
            Product p = (Product) myIterator.next();
            System.out.println(p);
        }

        // 其它
        List<Integer> myList3 = new ArrayList<>();
        for(int i=0; i<10; i++) {
            myList3.add(i);
        }
        myList3.stream().filter(num -> num % 2 == 0).forEach(System.out::println);


    }



    @Test
    public void testRemove() {
        List<String> myList = new ArrayList<>();
        myList.add("1");
        myList.add("1");
        myList.add("1");
        myList.add("1");
        myList.add("1");
        myList.add("2");

        // remove(index)
        myList.remove(0);
        System.out.println(myList.size());

        // remove(Object)
        myList.remove("1"); // 也只是去掉一个
        System.out.println(myList.size());
    }

    @Test
    public void testAddAll() {
        List<String> myList = new ArrayList<>();
        myList.add("4");
        List<String> subList = Arrays.asList("1", "2", "3");
        myList.addAll(0, subList);
        myList.forEach(System.out::println);
    }

    @Test
    public void testAsList() {
        List<String> list1 = new ArrayList<>();
        list1.add("1");

        try{
            List<String> list2 = Arrays.asList("1");
            list2.add("2");
        } catch (UnsupportedOperationException e) {
            System.out.println("asList返回的是一个定长的List, 不支持操作");
            e.printStackTrace();
        }
    }
}
