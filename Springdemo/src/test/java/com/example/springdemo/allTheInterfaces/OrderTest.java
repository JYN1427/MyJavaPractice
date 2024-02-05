package com.example.springdemo.allTheInterfaces;

import com.example.springdemo.allTheInterfaces.A_common.Const;
import com.example.springdemo.allTheInterfaces.A_common.MyInitializingBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/26 21:04:48
 * @Version: 1.0.0
 */
@SpringBootTest
public class OrderTest {

    @Autowired
    private MyInitializingBean myInitializingBean;

    @Test
    public void test1() {
        System.out.println(Const.PRE_STR + " 开始测试 ");
    }
}
