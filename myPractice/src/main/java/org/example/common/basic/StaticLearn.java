package org.example.common.basic;

import org.example.common.Object4Test.Obj4Static;

// 学习static关键字
// 一般而言，工具类中的方法都是静态方法。比如什么Math.max(a, b)、Arrays.sort(nums)、Character.isDigit(ch)...
// 另，注意: static方法中不能存在this关键字！！！！！！！！！！
public class StaticLearn {
    public static void main(String[] args) {
        // 类静态属性的改变 预示着对于所有对象而言都改变了
        changeSameTime();
    }

    public static void changeSameTime() {
        Obj4Static o1 = new Obj4Static();
        Obj4Static o2 = new Obj4Static();
        System.out.println(o1.getNum());
        Obj4Static.setNum(5.55D);
        System.out.println(o1.getNum());
        o1.setNum(9.99D);
        System.out.println(o2.getNum());
    }
}
