package com.example.ESProject.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Jia Yuning
 * @Description:
 * @Date: 2024/09/05 21:47:51
 * @Version: 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/ESTestController")
public class ESTestController {

    @RequestMapping("/test")
    public String test() {
        return "ok";
    }

}
