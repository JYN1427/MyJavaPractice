package com.example.springdemo.MockLearn;

import com.example.springdemo.SpringdemoApplication;
import org.junit.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyInt;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/07/03 12:35:48
 * @Version: 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringdemoApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SpyBeanLearn {
    @SpyBean
    Methods methods;

    @Test
    public void testSpyBean() {
        // 相同的when+thenReturn形式, spyBean会执行原函数, 但返回的依旧是mock的答案
        Mockito.when(methods.add(anyInt(), anyInt())).thenReturn(1);

        // doReturn+when+method形式, 不执行原函数
        // Mockito.doReturn(1).when(methods).add(anyInt(), anyInt());

        Integer res = methods.add(1, 2);
        System.out.println(res);
    }
}