package com.study.first.receiver;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * User: YHC
 * Date: 2020/8/21 13:57
 * DESC: DirectExchange主题交换机模式
 */
@Component
@RabbitListener(queuesToDeclare = @Queue("TestDirectQueue")) //监听队列名称
public class DirectReceiverNew {

    @RabbitHandler
    public void process(Map message){
        System.out.println("NEW-MQ消息：" + message.toString());
    }
}
