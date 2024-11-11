package org.example.common.basic;

// 可变个数形参方法
public class Changeable {
    public static void main(String[] args) {
        printSomething();
        printSomething(1);
        printSomething(2, 3);
        printSomething("", 4, 5, 6);
        printSomething(new int[]{7, 8, 9}); // 也是可以的
    }

    // 格式是：函数名(类型 ... 名称)
    public static void printSomething(int... nums) {
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void printSomething(String s, int... nums) {
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
