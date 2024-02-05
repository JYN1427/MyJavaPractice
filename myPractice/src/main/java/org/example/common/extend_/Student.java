package org.example.common.extend_;

public class Student extends Person {
    public String id; //

    public Student(String id, String name, char gender, int age, long income, String studentID) {
        super(id, name, gender, age, income);
        this.id = studentID;
    }

    public void printBothId() {
        System.out.printf("father id:%s \n", super.id);
        System.out.printf("son id:%s", this.id);
    }

    public String toString() {
        return "姓名：" + this.name + "\n年龄：" + this.age + "\n性别：" + this.gender + "\n身份证号：" + this.getIncome();
    }
}