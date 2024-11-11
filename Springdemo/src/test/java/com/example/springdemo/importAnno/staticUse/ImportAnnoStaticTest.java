package com.example.springdemo.importAnno.staticUse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/20 18:36:44
 * @Version: 1.0.0
 */

@SpringBootTest
public class ImportAnnoStaticTest {

//    不需要写也一样的
//    @Autowired
//    private ImportAnnoStaticLearn importAnnoLearn;

    /**
     * 测试一下@Import的静态注入使用方法
     */
    @Test
    public void test1() {
        // 看日志可以看到ImportAnnoLearn在被注入的时候, 通过Import把PersonObj也给注入进去了
        System.out.println("...");
    }
}
