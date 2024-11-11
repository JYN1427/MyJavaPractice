package com.example.springdemo.A_middleware.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author jiayn01
 * @date 2024-06-13 15:32:44
 */
@Configuration
public class RabbitUseConfig {

    // 死信队列设置
    public static final String DLX_EXCHANGE_NAME = "dlx_exchange_name";  // 死信交换机, 有一个就行了

    public static final String DLX_TTL_QUEUE = "dlx_ttl_queue";  // 死信队列, 一般有多个
    public static final String DLX_ALL_QUEUE = "dlx_all_queue";

    public static final String DLX_ROUTING_KEY_TTL = "dlx.routing.key.ttl";  // 死信的routing key, 一般有多个



    public static final String topicA = "hello.world";
    public static final String topicB = "hello.#";

    /**
     * #################### DLX 配置 开始 ####################
     */

    @Bean
    public TopicExchange dlxExchange() {
        return new TopicExchange(DLX_EXCHANGE_NAME);
    }

    @Bean
    public Queue dlxTtlQueue() {
        return new Queue(DLX_TTL_QUEUE);
    }

    @Bean
    public Binding dlxBinding1() {
        return BindingBuilder
                .bind(dlxTtlQueue())
                .to(dlxExchange())
                .with(DLX_ROUTING_KEY_TTL);
    }

    @Bean
    public Queue dlxAllQueue() {
        return new Queue(DLX_ALL_QUEUE);
    }

    @Bean
    public Binding dlxBinding2() {
        return BindingBuilder
                .bind(dlxAllQueue())
                .to(dlxExchange())
                .with("#");
    }

    /**
     *  ------------------- DLX 配置 结束 -------------------
     */

    /**
     * #################### topic使用配置 开始 ####################
     */
    @Bean
    public TopicExchange topicExchange1() {
        return new TopicExchange("topic_exchange");
    }

    @Bean
    public Queue topicQueue1() {
        return new Queue("topic_queue1");
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue("topic_queue2");
    }

    @Bean
    public Binding topicBinding1() {
        return BindingBuilder
                .bind(topicQueue1())
                .to(topicExchange1())
                .with(topicA);
    }

    @Bean
    public Binding topicBinding2() {
        return BindingBuilder
                .bind(topicQueue2())
                .to(topicExchange1())
                .with(topicB);
    }
    /**
     *  -------------------  topic使用配置 结束 -------------------
     */

    /**
     *  #################### Confirm Callback配置 开始 ####################
     */

    // 为了触发Confirm Callback, 这里什么也不配置, 让broker找不到Producer对应的exchange, 从而触发报错 执行callback

    /**
     *  ------------------- Confirm Callback配置 结束 -------------------
     */


    /**
     * #################### Confirm Callback配置 开始 ####################
     */

    @Bean
    public TopicExchange returnExchange1() {
        return new TopicExchange("test_returns_exchange1");
    }

    @Bean
    public Queue returnQueue() {
        return new Queue("return_queue");
    }

    @Bean
    public Binding returnBinding1() {
        return BindingBuilder
                .bind(returnQueue())
                .to(returnExchange1())
                .with("exist.key");
        // 如果Producer发exist.key以外的routingKey, 则消息到exchange之后找不到绑定的队列 投递不出去, 就会报错并触发
    }

    /**
     *  ------------------- Confirm Callback配置 结束 -------------------
     */


    /**
     * #################### ack 配置 开始 ####################
     */

    @Bean
    public TopicExchange ackExchange1() {
        return new TopicExchange("test_ack_exchange1");
    }

    @Bean
    public Queue ackQueue1() {
        return new Queue("ack_queue1");
    }

    @Bean
    public Binding ackBinding1() {
        return BindingBuilder
                .bind(ackQueue1())
                .to(ackExchange1())
                .with("ack.key");
    }

    @Bean
    public Queue ackQueue2() {
        return new Queue("ack_queue2");
    }

    @Bean
    public Binding ackBinding2() {
        return BindingBuilder
                .bind(ackQueue2())
                .to(ackExchange1())
                .with("ack.key.No2");
    }

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(CachingConnectionFactory connectionFactory,
                                                                         @Qualifier("ackListener") ChannelAwareMessageListener channelAwareMessageListener) {
        // 消费者数量，默认10
        int DEFAULT_CONCURRENT = 1;

        // 每个消费者获取最大投递数量 默认50
        int DEFAULT_PREFETCH_COUNT = 50;

        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(DEFAULT_CONCURRENT);
        container.setMaxConcurrentConsumers(DEFAULT_PREFETCH_COUNT);

        // RabbitMQ默认是自动确认，这里改为手动确认消息
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);

        //设置一个队列
        container.setQueueNames("ack_queue1");

        //如果同时设置多个如下： 前提是队列都是必须已经创建存在的
        //container.setQueueNames("TestDirectQueue","TestDirectQueue2","TestDirectQueue3");
        //另一种设置队列的方法,如果使用这种情况,那么要设置多个,就使用addQueues
        //container.setQueues(new Queue("TestDirectQueue",true));
        //container.addQueues(new Queue("TestDirectQueue2",true));
        //container.addQueues(new Queue("TestDirectQueue3",true));

        container.setMessageListener(channelAwareMessageListener);

        return container;
    }

    /**
     *  ------------------- ack 配置 结束 -------------------
     */


    /**
     * #################### prefetch 配置 开始 ####################
     */

    @Bean
    public TopicExchange prefetchExchange1() {
        return new TopicExchange("test_prefetch_exchange1");
    }

    @Bean
    public Queue prefetchQueue() {
        return new Queue("prefetch_queue");
    }

    @Bean
    public Binding prefetchBinding1() {
        return BindingBuilder
                .bind(prefetchQueue())
                .to(prefetchExchange1())
                .with("#.#");
    }

    /**
     *  ------------------- ttl 配置 结束 -------------------
     */

    /**
     * #################### prefetch 配置 开始 ####################
     */

    @Bean
    public TopicExchange ttlExchange1() {
        return new TopicExchange("test_ttl_exchange1");
    }

    @Bean
    public Queue ttlMsgQueue() {
        return new Queue("ttl_msg_queue");
    }

    @Bean
    public Binding ttlBinding1() {
        return BindingBuilder
                .bind(ttlMsgQueue())
                .to(ttlExchange1())
                .with("ttl.msg");
    }

    @Bean
    public Queue ttlQueQueue() {
        Map<String, Object> args = new HashMap<>();

        // 1. 设置整个队列的过期时间, 5秒
        args.put("x-message-ttl", 5000);

        // 2. 为该队列指定死信交换机
        args.put("x-dead-letter-exchange", DLX_EXCHANGE_NAME);

        // 3. 为该队列指定死信routing key
        args.put("x-dead-letter-routing-key", DLX_ROUTING_KEY_TTL);

        // 这个队列过期之后的消息, 会携带着DLX_ROUTING_KEY_TTL 被发到DLX_EXCHANGE_NAME这个死信交换机上
        return new Queue("ttl_que_queue", true, false, false, args);
    }

    @Bean
    public Binding ttlBinding2() {
        return BindingBuilder
                .bind(ttlQueQueue())
                .to(ttlExchange1())
                .with("ttl.que");
    }

    /**
     *  ------------------- ttl 配置 结束 -------------------
     */


}
