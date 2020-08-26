package com.study.first.receiver;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * User: YHC
 * Date: 2020/8/24 11:43
 * DESC:
 */
@Component
//queuesToDeclare 启动时创建队列 fanout.C
@RabbitListener(queuesToDeclare = @Queue("fanout.C"))
public class FanoutReceiverC {

    @RabbitHandler
    public void process(Map message){
        System.out.println("fanoutC消息：" + message.toString());
    }
}
