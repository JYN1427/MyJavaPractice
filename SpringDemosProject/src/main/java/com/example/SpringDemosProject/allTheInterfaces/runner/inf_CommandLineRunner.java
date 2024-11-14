package com.example.SpringDemosProject.allTheInterfaces.runner;

import com.example.SpringDemosProject.allTheInterfaces.A_common.Const;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;



public class inf_CommandLineRunner {

}


@Component
@Order(value = 1)
class firstBean implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println(Const.PRE_STR + " CommandLineRunner 第1个预先加载");
    }
}


@Component
@Order(value = 2)
class secondBean implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println(Const.PRE_STR + " CommandLineRunner 第2个预先加载");
    }
}
