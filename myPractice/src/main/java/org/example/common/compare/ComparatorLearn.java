package org.example.common.compare;


import org.example.common.ArrayList_.Product;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Jia Yuning
 * @Description: 定制排序
 * @Date: 2023/06/30 21:50:30
 * @Version: 1.0.0
 */

// 什么情况下用Comparator:
// 1 当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码(例如:一些第三方的类,你只有.class文件，没有源文件）
// 2 如果一个类，实现了Comparable接口，但不是我所需要的，我又不能随意修改，因为会影响其他地方的使用.
public class ComparatorLearn {
    public static void main(String[] args) {

    }

    @Test
    public void test1() {
        List<Product> myList = new ArrayList<>();
        myList.add(new Product(1, "B", 10));
        myList.add(new Product(2, "A", 10));
        myList.add(new Product(3, "X", 0));


        // 方式1: 另外建立一个类去实现Comparator
        Collections.sort(myList, new myProductComparator());



        // 方式2: 直接在传入的时候重写compare()方法
        Collections.sort(myList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if(Float.compare(o1.getPrice(), o2.getPrice()) == 0) {
                    return o1.getName().compareTo(o2.getName());
                } else {
                    return Float.compare(o1.getPrice(), o2.getPrice());
                }
            }
        });



        // 方式3: 直接用lambda写一个函数就行
        Collections.sort(myList, (o1, o2) -> {
            if(Float.compare(o1.getPrice(), o2.getPrice()) == 0) {
                return o1.getName().compareTo(o2.getName());
            } else {
                return Float.compare(o1.getPrice(), o2.getPrice());
            }
        });



        // 方式4: ::调用静态方法
        Collections.sort(myList, ComparatorLearn::insideCompare);




        for(int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
    }



    public static int insideCompare(Product o1, Product o2) {
        if(o1 == o2) {
            // 地址相等即相等
            return 0;
        }
        int res = Float.compare(o1.getPrice(), o2.getPrice());
        if(res == 0) {
            // price相等则比较name
            return o1.getName().compareTo(o2.getName());
        }
        // 反序
        return -1 * res;
    }

}


class myProductComparator implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        if(o1 == o2) {
            // 地址相等即相等
            return 0;
        }
        int res = Float.compare(o1.getPrice(), o2.getPrice());
        if(res == 0) {
            // price相等则比较name
            return o1.getName().compareTo(o2.getName());
        }
        return res;
    }
}