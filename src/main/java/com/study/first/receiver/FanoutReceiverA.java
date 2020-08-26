package com.study.first.receiver;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * User: YHC
 * Date: 2020/8/24 11:39
 * DESC:
 */
@Component
@RabbitListener(queuesToDeclare = @Queue("fanout.A"))
public class FanoutReceiverA {

    @RabbitHandler
    public void process(Map message){
        System.out.println("fanoutA消息：" + message.toString());
    }
}
