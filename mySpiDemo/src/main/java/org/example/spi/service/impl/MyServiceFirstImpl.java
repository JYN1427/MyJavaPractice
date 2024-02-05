package org.example.spi.service.impl;

import org.example.spi.service.MyService;
import org.springframework.stereotype.Component;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2023/08/24 22:06:41
 * @Version: 1.0.0
 */
@Component
public class MyServiceFirstImpl implements MyService{
    public MyServiceFirstImpl() {
        System.out.println("啊啊啊啊啊啊啊啊啊啊啊啊");
    }
}
