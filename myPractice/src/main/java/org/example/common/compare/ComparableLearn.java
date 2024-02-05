package org.example.common.compare;


import org.example.common.ArrayList_.Product;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: Jia Yuning
 * @Description: 天然排序
 * @Date: 2023/06/30 21:50:10
 * @Version: 1.0.0
 */
public class ComparableLearn {
    // 普通字符串排序
    @Test
    public void test1() {
        String[] stringArray = new String[] {"Lucy", "Sam", "Jack", "Anna", "Tom"};
        Arrays.sort(stringArray);
        for(int i=0; i<stringArray.length; i++) {
            System.out.println(stringArray[i]);
        }
    }

    // 自定义内容排序
    @Test
    public void test2() {
        Product[] arr = new Product[5];
        arr[0] = new Product(1, "B", 10);
        arr[1] = new Product(2, "C", 110);
        arr[2] = new Product(3, "A", 10);
        arr[3] = new Product(4, "C", 140);
        arr[4] = new Product(5, "C", 910);
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i].getName() + arr[i].getPrice());
        }
    }
}
