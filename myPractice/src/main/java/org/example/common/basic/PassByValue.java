package org.example.common.basic;

// 值传递: 把实参的 数值/地址 拷贝一份给形参
public class PassByValue {
    public static void main(String[] args) {
        basic(); // 普通类型
        reference(); // 引用类型
    }

    public static void basic() {
        int m = 1;
        int n = 9;
        System.out.printf("m=%d, n=%d \n", m, n);
        swap(m, n);
        System.out.printf("m=%d, n=%d", m, n);
    }

    public static void swap(int m, int n) {
        int tmp = m;
        m = n;
        n = tmp;
    }

    public static void reference() {

    }


}
