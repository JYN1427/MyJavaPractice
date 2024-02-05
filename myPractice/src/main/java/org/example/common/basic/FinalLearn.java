package org.example.common.basic;

// 学习final关键字
// 1. 用final修饰类: 这个类不能被继承，比如String, StringBuffer, StringBuilder
// 2. 用final修饰方法: 这个方法不能被重写, 比如常用的getClass()方法
// 3. 用final修饰变量: 常量, 不可更改
// 4. final和static连用: 全局常量, 例如Math.PI
public class FinalLearn {

    private final String name;

    private final Integer age;


    public FinalLearn(String name, Integer age) {
        // final修饰的变量必须在构造器中进行初始化
        // 这也是为什么Spring的构造器注入要对注入的Bean成员变量用final修饰
        this.name = name;
        this.age = age;
    }
}
