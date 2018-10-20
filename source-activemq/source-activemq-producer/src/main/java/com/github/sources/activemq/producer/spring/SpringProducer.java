package com.github.sources.activemq.producer.spring;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class SpringProducer {

    @Autowired
    private ActiveMQQueue activeMQQueue;

    @Autowired
    private ActiveMQTopic activeMQTopic;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage() {
        for (int i = 0; i < 10; i++) {
            jmsMessagingTemplate.convertAndSend(activeMQQueue, "发送第 "+i+" 个消息");
            jmsMessagingTemplate.convertAndSend(activeMQTopic, "发送第 "+i+" 个消息");
        }
    }
}
