package org.example.common.Object4Test;

import java.util.Objects;

public class Person{
    private String name ;
    private int age ;
    private char gender;

    //构造器
    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    //在子类中重写equals()方法
    //当重写之后，equals的作用变成了比较两个对象的内容是否相同
    @Override
    public boolean equals(Object obj){
        //首先判断对象是否一致
        if(this == obj){
            //对象一样，内容自然是一样的
            return true;
        }
        //判断传入的对象运行类型是不是和调用equals方法的对象运行类型一致
        if(obj instanceof Person){
            //向下转型 将obj 的编译类型改成 Person
            //
            //目的是
            //(1)为了让obj的编译类型和调用equals方法的对象的编译类型保持一致，
            //   这样才能同时可以调用拥有重写的equals方法,达到比较内容的目地
            //(2)为了可以调用obj 的属性 与 调用equals方法的对象 进行比较
            Person p = (Person)obj;
            return this.name.equals(p.name) && this.age == p.age && this.gender == p.gender ;
        }
        //obj 运行类型不是 person
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }

    //getting and setting

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }


}
