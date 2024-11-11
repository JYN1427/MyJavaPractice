package org.example.common.basic;

import org.example.common.Object4Test.Obj4Block;

// 代码块: 非静态代码块和静态代码块
// 先执行静态代码块, 后执行非静态
public class BlockLearn {
    public static void main(String[] args) {
        // 静态代码块: 随着类的加载而执行, 只会执行一次
        Obj4Block.doSomething();

        System.out.println("--");

        // 非静态: 随着对象的创建而执行
        Obj4Block o1 = new Obj4Block();
        Obj4Block o2 = new Obj4Block();
    }
}
