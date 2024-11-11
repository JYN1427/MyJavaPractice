package com.example.springdemo.A_middleware.rabbit.spring.F_dlx;

import com.example.springdemo.A_middleware.rabbit.config.RabbitUseConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-06-27 11:37:47
 */
@Component
public class DlxConsumer {

    /**
     * 监听死信队列作为延时队列
     */
    @RabbitHandler
    @RabbitListener(queues = RabbitUseConfig.DLX_TTL_QUEUE)
    public void getDelay(@Payload String messageBody, @Headers Map<String, Object> headers, Channel channel) throws IOException, InterruptedException {
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);

        System.out.println(new Date() + "延迟队列获得消息: " + messageBody);

        // 正常应该catch住然后reject, 我这就不写那么规范了
        channel.basicAck(deliveryTag, false);
    }


    @RabbitHandler
    @RabbitListener(queues = RabbitUseConfig.DLX_ALL_QUEUE)
    public void getTest(@Payload String messageBody, @Headers Map<String, Object> headers, Channel channel) throws IOException, InterruptedException {
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        System.out.println(new Date() + "ALL 获得消息: " + messageBody);
        channel.basicAck(deliveryTag, false);
    }

}
