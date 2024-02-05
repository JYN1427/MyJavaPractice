package org.example.common.genericity;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jia Yuning
 * @Description: 泛型学习 , 通配符的使用 , 泛型方法
 * @Date: 2023/07/07 18:53:10
 * @Version: 1.0.0
 */
public class GenericityLearn {
    // 1 诸如ArrayList<Object> 和 ArrayList<String> 并不等价
    @Test
    public void test1() {
        //  1.1 泛型参数在指明时，是不可以使用基本数据类型的!!!!!!
        Order<String> order = new Order<>();

        // 1.2 引用类型中的泛型, 不符合基本类型中多态的规律
        Object[] l1 = null;
        String[] l2 = null;
        l1 = l2; // ok

        ArrayList<Object> l3 = null;
        ArrayList<String> l4 = null;
//        l3 = l4; // 不可以
    }
    

    // 2 通配符?的使用
    @Test
    public void test2() {
        // 使通用性:
        List<?> list = null;
        List<Object> list1 = null;
        List<String> list2 = new ArrayList<>();
        list = list1;
        list = list2;

        // 但是list<?>中无法add对象(null除外)
        list.add(null);
        list.get(0);

        method(list);
        method(list1);
        method(list2);
    }

    public void method(List<?> list) {
    }


    // 3 泛型方法
    @Test
    public void testGeneralMethod() {
        int[] arr1 = new int[] {1, 2};
        // copyFromArray2List(arr1);  // 必须用包装类
        Integer[] arr2 = new Integer[] {1, 2};
        copyFromArray2List(arr2);
    }

    // 语法: 修饰符 <T,E,…> 返回值类型 方法名（形参列表）{}
    public <E> ArrayList<E> copyFromArray2List(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for(E e : arr) {
            list.add(e);
        }
        return list;
    }
}
