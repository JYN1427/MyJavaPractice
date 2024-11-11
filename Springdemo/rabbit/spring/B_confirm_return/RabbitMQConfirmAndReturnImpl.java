package com.example.springdemo.A_middleware.rabbit.spring.B_confirm_return;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-06-18 10:54:44
 */
@Component
public class RabbitMQConfirmAndReturnImpl
        implements RabbitTemplate.ConfirmCallback,
        RabbitTemplate.ReturnCallback,
        RabbitTemplate.ReturnsCallback {

    /**
     * confirm机制只保证消息到达exchange，不保证消息可以路由到正确的queue,如果exchange错误，就会触发confirm机制
     *
     * @param correlationData
     * @param ack
     * @param cause
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (!ack) {
            System.out.printf("报错: rabbitmq confirm fail,cause:%s \n", cause);
        }
    }


    /**
     * Return 消息机制用于处理一个不可路由的消息。在某些情况下，如果我们在发送消息的时候，
     * 当前的 exchange 不存在或者指定路由 key 路由不到，这个时候我们需要监听这种不可达的消息
     * 就需要这种return机制 
     * @param message
     * @param replyCode
     * @param replyText
     * @param exchange
     * @param routingKey
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.printf("mq消息不可达,message:%s,replyCode:%d,replyText:%s,exchange:%s,routing:%s \n", message.toString(), replyCode, replyText, exchange, routingKey);
        String messageId = message.getMessageProperties().getMessageId();
        System.out.println("messageId: " + messageId);
    }

    @Override
    public void returnedMessage(ReturnedMessage returned) {
        System.out.println("报错: " + returned.getMessage());
    }
}