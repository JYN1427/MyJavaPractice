package org.example.common.Interface_;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InterfaceLearn {
    public static void main(String args[]) {
        // 测试实现接口
        MathClass mc = new MathClass(1, 5);
        System.out.println(mc.sum());

        // JDK8开始 接口也可以写静态方法
        IMath2.doSomthing();

        // 接口的多态性
        IMath mc2 = new MathClass(0, 0);
        IMath2 mc3 = new MathClass(0, 0);
        IMathSon mc4 = new MathClass(0, 0);
        mc2.sum();
        mc3.cal();
        mc4.cal();

        // 多态性类比:
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        deque.push(1);
        list.add(1);
    }
}
