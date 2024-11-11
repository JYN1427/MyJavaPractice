package com.example.springdemo.A_middleware.rabbit.spring.D_prefetch;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * 消费端限流
 *
 * @author jiayn01
 * @date 2024-06-13 17:16:45
 */
@Component
public class PreFetchTestConsumer {

    @Value("${spring.rabbitmq.listener.simple.prefetch}")
    private String prefetchNumber;

    private Integer i = 0;

    /**
     * 监听死信队列, 实现延迟消息
     */
    @RabbitHandler
    @RabbitListener(queues = "prefetch_queue")
    public void getByPreFetch(@Payload String messageBody, @Headers Map<String, Object> headers, Channel channel) throws IOException, InterruptedException {

        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        System.out.printf("[preFetch=%s] xxxxxxxx 消费 deliveryTag=%s - 消息: %s\n", prefetchNumber, deliveryTag, messageBody);

        // 模拟耗时, 如果此时生产者生产了很多消息, 只会积压在队列里, 因为消费者还没回复ACK
        Thread.sleep(2000);


        // 看拒绝之后是放在队尾还是队首 ———————— 结论: 队首
        if ("ABC No.3".equals(messageBody) && i < 5) {
            channel.basicReject(deliveryTag, true);
            i++;
            return;
        }

        // 正常应该catch住然后reject, 我这就不写那么规范了
        channel.basicAck(deliveryTag, false);
    }

}
