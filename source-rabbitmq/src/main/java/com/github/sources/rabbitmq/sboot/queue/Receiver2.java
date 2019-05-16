package com.github.sources.rabbitmq.sboot.queue;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author hairen.long
 * @date 2019-05-14
 */
@Component
@RabbitListener(queues = "hello2")
public class Receiver2 {

    @RabbitHandler
    public void process(String message){
        System.out.println("Receiver2:"+message);

    }
}
