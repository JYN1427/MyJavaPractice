package org.example.common.extend_;

// 继承
public class Extends {
    public static void main(String[] args) {
        Person p = new Person("0", "jyn", '男', 24, 50000);
        Student stu = new Student("0", "jyn", '男', 24, 50000, "123456");

        // 父类子类同名的属性是不排斥的, 在内部通过super关键字找到
        // 但别这样干
        stu.printBothId();

//        System.out.println("----------------人的信息---------------------");
//        System.out.println(p);
//        System.out.println("----------------学生信息---------------------");
//        System.out.println(stu);
    }
}
