package com.example.springdemo.A_middleware.rabbit.spring.C_ack;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-06-24 15:16:23
 */
@Component
public class AckConsumer {

    @RabbitHandler
    @RabbitListener(queues = "ack_queue2")
    public void getTopicQueue1(@Payload String messageBody, @Headers Map<String, Object> headers, Channel channel){
        System.out.println(messageBody);
        System.out.println(headers);
        System.out.println("channel number = " + channel.getChannelNumber());
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        try {
            System.out.println("Channel内消息唯一标识: amqp_deliveryTag = " + deliveryTag);
            System.out.println("业务处理逻辑 ing ...");
            int a = 3 / 0;  // 模拟错误

            channel.basicAck(deliveryTag, true);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("消息消费失败, 重新放入队列ing");
            try {
                channel.basicReject(deliveryTag, false);
            } catch (Exception exception) {
                exception.printStackTrace();
                System.out.println("消息放回队列失败");
            }
        } finally {
            System.out.println("处理完毕");
        }
    }

}
