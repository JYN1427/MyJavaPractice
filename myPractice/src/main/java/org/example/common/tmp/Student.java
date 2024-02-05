package org.example.common.tmp;

public class Student {
    public String name;

    public Student(String name) {
        this.name = name;
    }

    public void sayName1() {
        System.out.println(name);
    }

    public void sayName2() {
        System.out.println(this.name);
    }
}
