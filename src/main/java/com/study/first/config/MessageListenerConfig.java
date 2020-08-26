package com.study.first.config;

import com.study.first.receiver.MyAckRecevier;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * User: YHC
 * Date: 2020/8/24 16:24
 * DESC: rabbitmq消息监听配置|消息手动确认
 */
//@Configuration
public class MessageListenerConfig {

    @Autowired
    private CachingConnectionFactory connectionFactory;

    @Autowired
    private MyAckRecevier myAckRecevier;

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(1);
        container.setMaxConcurrentConsumers(1);
        //修改确认模式为手动
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        //设置一个队列
        container.setQueueNames("TestDirectQueue", "fanout.A");
        //同事设置多个队列格式：
        //container.setQueueNames("TestDirectQueue0","TestDirectQueue1","TestDirectQueue2");
        container.setMessageListener(myAckRecevier);
        return container;
    }
}
