package com.example.SpringDemosProject.thread.threadlocal.common;


public class UserInfo {

    public UserInfo(String name, String number, String dept) {
        this.name = name;
        this.number = number;
        this.dept = dept;
    }

    public String name;

    public String number;

    public String dept;

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}
