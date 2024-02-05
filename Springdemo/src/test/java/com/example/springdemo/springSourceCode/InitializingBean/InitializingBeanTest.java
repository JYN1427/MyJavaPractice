package com.example.springdemo.springSourceCode.InitializingBean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/20 18:50:12
 * @Version: 1.0.0
 */
@SpringBootTest
public class InitializingBeanTest {

//    @Resource(name = "myTmpTestObj")
    @Autowired
    private TestObj testObj;

    @Test
    public void test1() {

    }
}
