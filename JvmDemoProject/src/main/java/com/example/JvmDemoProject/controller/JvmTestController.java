package com.example.JvmDemoProject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/08/05 21:47:51
 * @Version: 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/JvmTestController")
public class JvmTestController {

    @RequestMapping("/test")
    public String test() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    byte[] bytes = new byte[100 * 1024 * 1024];
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        return "ok";
    }

}
