package com.github.sources.rabbitmq.sboot.queue;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author hairen.long
 * @date 2019-05-14
 */
@Component
public class Sender {

    @Autowired private AmqpTemplate amqpTemplate;

    public void send() {
        String context = "hello----" + LocalDateTime.now();
        System.out.println("send:" + context);
        // 往名称为 hello 的queue中发送消息
        this.amqpTemplate.convertAndSend("hello", context);
    }

    public void send2(int i) {
        String context = i + "";
        System.out.println(context + "--send:");
        this.amqpTemplate.convertAndSend("hello2", context);
    }
}
