package com.example.SpringDemosProject.thread.watchable;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 两个线程对一个单例对象成员的可见性
 *
 * @author jiayn01
 * @date 2023-10-12 10:41:47
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
//        test2();
        test3();
    }


    /**
     * 测试不同线程对同一个对象的对象类型做更改
     */
    public static void test1() {
        Students students = new Students();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + students.getMap().toString());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + students.getMap().toString());
        }, "线程1").start();

        new Thread(() -> {
            Map<String, String> tmpMap = new HashMap<>();
            tmpMap.put("2", "Lily");
            students.setMap(tmpMap);
            System.out.println(Thread.currentThread().getName() + students.getMap().toString());
        }, "线程2").start();
    }

    /**
     * 测试不同线程对同一个对象的基本类型成员做更改
     * 子线程1对变量修改, 子线程2可以感知
     */
    public static void test2() throws Exception{
        Students students = new Students();

        new Thread(() -> {
            students.print();
        }, "线程1").start();

        new Thread(() -> {
            students.setSchool("UFC");
        }, "线程2").start();
    }

    /**
     * 主线程对变量修改, 子线程无法感知, 除非加 volatile
     *
     * @throws Exception
     */
    public static void test3() throws Exception{
        Students students = new Students();

        new Thread(() -> {
            students.print();
        }, "线程1").start();

        Thread.sleep(100);
        students.setSchool("UFC");
    }
}


class Students {

    Students() {
        map.put("1", "Tom");
        school = "China";
    }

    private Map<String, String> map = new HashMap<>();

    private String school;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void print() {
        int i = 0;
        System.out.println("开始---");
        while(StringUtils.equals(school, "China")) {
            i += 1;
        }
        System.out.println("结束---");
    }
}