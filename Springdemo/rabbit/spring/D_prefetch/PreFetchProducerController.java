package com.example.springdemo.A_middleware.rabbit.spring.D_prefetch;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring整合
 *
 * @author jiayn01
 * @date 2024-06-13 10:58:16
 */
@RequestMapping("/preFetch")
@RestController
public class PreFetchProducerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 模拟一次性发很多消息
     * 但消费者只会一个prefetch一个prefetch的消费
     */
    @GetMapping("/go")
    public String topicToQueue() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("test_prefetch_exchange1","#.#","ABC No." + (i+1));
            Thread.sleep(100);
        }
        return "ok";
    }

}
