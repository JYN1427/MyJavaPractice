package org.example.common.Object4Test;

public class Obj4Block {
    private int num = 0;
    public static void doSomething(){
        System.out.println("doing...");
    }

    // 非静态代码块
    {
        System.out.println("执行 非静态代码块1");
    }

    // 静态代码块
    static {
        System.out.println("执行 静态代码块1");
    }
}
