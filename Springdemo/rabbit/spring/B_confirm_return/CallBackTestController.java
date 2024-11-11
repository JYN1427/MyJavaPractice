package com.example.springdemo.A_middleware.rabbit.spring.B_confirm_return;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-06-18 11:04:51
 */
@RequestMapping("/callback")
@RestController
public class CallBackTestController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/confirm")
    public String confirm(){
        rabbitTemplate.convertAndSend("test_confirm_exchange","test.confirm", "hello world :) ");
        return "ok";
    }

    @GetMapping("/returns")
    public String returns() throws InterruptedException {
        System.out.println("成功case: 到了exchange, 找到绑定队列, 投递消息");
        rabbitTemplate.convertAndSend("test_returns_exchange1","exist.key", "hello world111 ");
        Thread.sleep(1500);
        System.out.println("失败case: 到了exchange, 但找不到绑定队列");
        rabbitTemplate.convertAndSend("test_returns_exchange1","not.exist.at.all", "hello world222 ");
        return "ok";
    }

}
