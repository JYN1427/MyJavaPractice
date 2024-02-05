package org.example.common.Interface_;

public interface IMath {
    // 接口没有构造方法，不能被实例化

    // String name;    // 不合法，变量必须初始化!

    // 合法，等同于 public static final double pi = 3.14;
    double pi = 3.14;

    // 方法声明，等同于 public abstract int sum();
    int sum();    // 完成两个数的相加
    int maxNum(int a, int b);    // 获取较大的数
}