package org.example.common.extend_;

public class Person {
    public String id;
    public String name;
    public char gender;
    protected int age;
    private long income;

    // 构造方法
    public Person(String id, String name, char gender, int age, long income) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.income = income;
    }

    public long getIncome() {
        return this.income;
    }

    public void showName() {
        System.out.println(this.name);
    }

    public String toString() {
        return "姓名：" + this.name + "\n年龄：" + this.age + "\n性别：" + this.gender;
    }
}