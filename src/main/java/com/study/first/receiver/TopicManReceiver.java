package com.study.first.receiver;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * User: YHC
 * Date: 2020/8/24 10:27
 * DESC:
 */
@Component
@RabbitListener(queuesToDeclare = @Queue("topic.man"))
public class TopicManReceiver {

    @RabbitHandler
    public void process(Map message){
        System.out.println("TopicManReceiver消息：" + message.toString());
    }
}
