package org.example.common.basic;


import org.example.common.Object4Test.Person;

// 根类Object的常用方法
public class ObjectMethods {
    public static void main(String[] args) {
        // 1. clone()
        // 克隆一个对象
        aboutClone();

        // 2. equals()
        // 当我们的子类没有重写equals 时，我们调用的时Object 的equals方法，只有判断两个引用类型的地址是否相同；
        // 当我们的子类重写equals 时,如同String和 Integer 一样，判断的是内容是否相等，这里我们自己重写了equals，需要判断来对象是否相同
        aboutEquals();
    }

    // Object.clone()方法
    public static void aboutClone() {
        Object4Clone o1 = new Object4Clone(1); // 实现了Cloneable接口 重写clone()方法
        try{
            Object4Clone o2 = (Object4Clone) o1.clone();
            o2.setNum(2);
            System.out.println(o1.getNum());
            System.out.println(o2.getNum());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    // Object.equals()方法
    // equals和hashcode方法可以alt+insert直接IDEA自动生成
    public static void aboutEquals() {
        Person person1 = new Person("YLX", 21, '男');
        Person person2 = new Person("YLX", 21, '男');
        System.out.println(person1.equals(person2));
    }
}
