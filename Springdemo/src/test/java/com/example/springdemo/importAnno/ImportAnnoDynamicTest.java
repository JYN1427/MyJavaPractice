package com.example.springdemo.importAnno;

import com.example.springdemo.importAnno.dynamicUse.ImportSelector.service.MyCacheService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/20 21:44:34
 * @Version: 1.0.0
 */

@SpringBootTest
public class ImportAnnoDynamicTest {

    /**
     * IDEA报错不用管
     */
    @Autowired
    private MyCacheService myCacheService;

    @Test
    public void test1() {
        System.out.println("现在是：" + myCacheService.getClass().getName());
    }
}
