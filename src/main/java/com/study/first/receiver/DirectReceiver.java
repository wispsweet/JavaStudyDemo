package com.study.first.receiver;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * User: YHC
 * Date: 2020/8/21 13:57
 * DESC: DirectExchange主题交换机模式|点对点模式|可以创建多个listener监听同一个队列，当前消费端轮询方式获取消息
 */
@Component
@RabbitListener(queuesToDeclare = @Queue("TestDirectQueue")) //监听队列名称
public class DirectReceiver {

    @RabbitHandler
    public void process(Map message){
        try {
            System.out.println("MQ消息：" + message.toString());
        } catch (Exception e) {
            System.out.println("我是异常.....");
        }
    }


}
