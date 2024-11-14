package com.example.SpringDemosProject.allTheInterfaces.A_common;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 自定义实现FactoryBean接口
 *
 * @author jiayn01
 * @date 2024-05-06 09:51:42
 */
@Component("NingGe")
public class MyFactoryBean implements FactoryBean<Object> {

    @Value("${test.MyFactoryBean.val}")
    public Boolean val;

    public MyFactoryBean() {
        System.out.println("MyFactoryBean的构造函数被调用");
    }

    @Override
    public Object getObject() throws Exception {
        System.out.println("getObject被调用");
        if (val) {
            long l = System.currentTimeMillis();
            return new Obj4Test("True - Obj4Test" + l);
        }
        else {
            throw new Exception("测试抛出异常");
        }
    }

    @Override
    public Class<?> getObjectType() {
        return Obj4Test.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }

    @Override
    public String toString() {
        return "MyFactoryBean{}";
    }
}


class Obj4Test {
    String name;
    public Obj4Test(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Obj4Test{" +
                "name='" + name + '\'' +
                '}';
    }
}