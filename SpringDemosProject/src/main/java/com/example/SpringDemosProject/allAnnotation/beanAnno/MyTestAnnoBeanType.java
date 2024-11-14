package com.example.SpringDemosProject.allAnnotation.beanAnno;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-06-14 15:59:58
 */
public class MyTestAnnoBeanType {
    private String name;
    public MyTestAnnoBeanType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyTestAnnoBeanType{" +
                "name='" + name + '\'' +
                '}';
    }
}