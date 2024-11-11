package com.example.springdemo.A_middleware.rabbit.spring.C_ack;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * Consumer ACK机制：
 *  1. 设置手动签收。acknowledge="manual"
 *  2. 让监听器类实现ChannelAwareMessageListener接口
 *  3. 如果消息成功处理,则调用channel的 basicAck()签收
 *  4. 如果消息处理失败,则调用channel的basicNack()拒绝签收,broker重新发送给consumer
 */
@Component("ackListener")
public class AckListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        Thread.sleep(1000);
        // 获取消息传递标记
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            // 接收消息
            System.out.printf("消息标记: %s, 消息体: %s", deliveryTag, new String(message.getBody()));

            // 处理业务逻辑
            System.out.println("处理业务逻辑");
            int a = 3 / 0;  // 模拟错误

            // 手动签收
            /**
             * 确认消息，参数说明：
             * long deliveryTag：唯一标识 ID。
             * boolean multiple：是否批处理，当该参数为 true 时，
             * 则可以一次性确认 deliveryTag 小于等于传入值的所有消息。
             */
            channel.basicAck(deliveryTag, true);
        } catch (Exception e) {
            System.out.println("出现错误");
            e.printStackTrace();

            /**
             * 否定消息，参数说明：
             * long deliveryTag：唯一标识 ID。
             * boolean multiple：是否批处理，当该参数为 true 时，
             * 则可以一次性确认 deliveryTag 小于等于传入值的所有消息。
             * boolean requeue：如果 requeue 参数设置为 true，
             * 则 RabbitMQ 会重新将这条消息存入队列，以便发送给下一个订阅的消费者；
             * 如果 requeue 参数设置为 false，则 RabbitMQ 立即会还把消息从队列中移除，
             * 而不会把它发送给新的消费者。
             */
            //channel.basicNack(deliveryTag, true, false);


            /**
             * 拒绝消息，参数说明：
             * long deliveryTag：唯一标识 ID。
             * boolean requeue：如果 requeue 参数设置为 true，
             * 则 RabbitMQ 会重新将这条消息存入队列，以便发送给下一个订阅的消费者；
             * 如果 requeue 参数设置为 false，则 RabbitMQ 立即会还把消息从队列中移除，
             * 而不会把它发送给新的消费者。
             */
            // 放回队列之后就是一个新的消息了, deliveryTag会变了
            // 为true的话, 如果当前队列只有此一个消费者, 且这个任务一直报错的话, 这个消费者会疯狂循环重复消费这一个消息
             channel.basicReject(deliveryTag, true);
//             channel.basicReject(deliveryTag, false);
        }
    }
}