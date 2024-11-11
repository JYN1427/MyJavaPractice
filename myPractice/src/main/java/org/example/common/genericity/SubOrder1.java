package org.example.common.genericity;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/07/07 18:59:49
 * @Version: 1.0.0
 */

// 1 都泛型 - 相当于要在new对象的时候指明类型
public class SubOrder1<E> extends Order<E>{

}

// 2 都不指明 - 相当于默认都是Object, 后续要强转
class SubOrder2 extends Order{

}

// 3 指明父类 - 相当于上来订好了都是Integer
class SubOrder3 extends Order<Integer> {

}

// 4 自己泛型, 父类指明 - 那就是用的父类的方法都是指明的, 但自己要新添加一些泛型的东西
class SubOrder4<E> extends Order<Integer> {
    private E e;
}

// 5 延申
class SubOrder5<T, E> extends Order<T> {
    private E e; // E是自己的
    private T t; // T是父类里的T
}