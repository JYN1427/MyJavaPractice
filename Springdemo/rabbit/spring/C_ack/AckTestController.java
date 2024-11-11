package com.example.springdemo.A_middleware.rabbit.spring.C_ack;

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
@RequestMapping("/ack")
@RestController
public class AckTestController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 触发方案1: implements ChannelAwareMessageListener
     * @return
     */
    @GetMapping("/trigger_ack")
    public String triggerAck(){
        rabbitTemplate.convertAndSend("test_ack_exchange1","ack.key", "trigger_ack");
        return "ok";
    }

    /**
     * 触发方案2: @RabbitListener
     * @return
     */
    @GetMapping("/trigger_ack_no2")
    public String triggerAckNo2(){
        rabbitTemplate.convertAndSend("test_ack_exchange1","ack.key.No2", "trigger_ack_No2");
        return "ok";
    }

}
