package com.example.springdemo.A_middleware.rabbit.spring.A_baseUse;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Spring整合
 *
 * @author jiayn01
 * @date 2024-06-13 10:58:16
 */
@RequestMapping("/topic/rabbit")
@RestController
public class ProducerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.host}")
    private String mqHost;

    @GetMapping("/topicToQueue")
    public String topicToQueue(){
        String exchangeName = "topic_exchange";
        System.out.println("连接 " + mqHost);


        Map<String, String> topicMap1 = new HashMap<>();
        topicMap1.put("age","1");
        System.out.printf("发送消息 %s - %s - %s%n", exchangeName, "hello.world", topicMap1);
        rabbitTemplate.convertAndSend(exchangeName,"hello.world",topicMap1);


        Map<String, String> topicMap2 = new HashMap<>();
        topicMap2.put("school","xxxxxx");
        System.out.printf("发送消息 %s - %s - %s%n", exchangeName, "hello.#", topicMap2);
        rabbitTemplate.convertAndSend(exchangeName,"hello.#",topicMap2);

        return "主题消息发送成功";
    }

}
