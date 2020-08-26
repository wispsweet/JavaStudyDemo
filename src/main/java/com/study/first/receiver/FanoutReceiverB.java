package com.study.first.receiver;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * User: YHC
 * Date: 2020/8/24 11:41
 * DESC:
 */
@Component
@RabbitListener(queuesToDeclare = @Queue("fanout.B"))
public class FanoutReceiverB {

    @RabbitHandler
    public void process(Map message){
        System.out.println("fanoutB消息：" + message);
    }
}
