package org.example.common.io.excel;

import java.util.List;


public class PoiExcelRead {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        String[] cols = {
                "name",
                "age"
        };
        List<Person> list = ExcelUtil.getDataFromExcel("jyn.xlsx", Person.class, cols);
        list.forEach(System.out::println);
    }
}

class Person {
    public String name;
    public String age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}

