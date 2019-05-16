package com.github.sources.rabbitmq.sboot.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author hairen.long
 * @date 2019-05-14
 */
@Component
@RabbitListener(queues = "topic.messages")
public class TopicReceiver2 {

    @RabbitHandler
    public void process(String message) {

        System.out.println("Receiver2 topic.messages: " + message);
    }
}
