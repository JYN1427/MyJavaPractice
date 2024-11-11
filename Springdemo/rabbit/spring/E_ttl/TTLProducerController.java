package com.example.springdemo.A_middleware.rabbit.spring.E_ttl;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-06-25 10:35:31
 */
@RequestMapping("/ttl")
@RestController
public class TTLProducerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发出去之后, 过一会再看后台管理界面, total就从10变成0了
     */
    @GetMapping("/messageTtl")
    public String messageTtl() throws InterruptedException {
        String messageBody = "msg of messageTtl";
        MessageBuilder messageBuilder = MessageBuilder.withBody(messageBody.getBytes(StandardCharsets.UTF_8));
        Message message = messageBuilder
                .setExpiration("10000")
                .build();
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("test_ttl_exchange1", "ttl.msg", message);
            Thread.sleep(100);
        }
        return "ok";
    }


    /**
     * 在config里面 设置了整个队列的过期时间 x-message-ttl
     * 在配置后台中, 该队列可以看到被标注为ttl队列
     */
    @GetMapping("/queueTtl")
    public String queueTtl() throws InterruptedException {
        String messageBody = "msg of queueTtl" + new Date();
        MessageBuilder messageBuilder = MessageBuilder.withBody(messageBody.getBytes(StandardCharsets.UTF_8));
        Message message = messageBuilder
                .build();
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("test_ttl_exchange1", "ttl.que", message);
            Thread.sleep(100);
        }
        return "ok";
    }


}
