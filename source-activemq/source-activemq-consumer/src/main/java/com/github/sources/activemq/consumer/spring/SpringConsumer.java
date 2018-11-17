package com.github.sources.activemq.consumer.spring;

import com.github.sources.activemq.consumer.configure.ActivemqConfigure;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class SpringConsumer {

//    @JmsListener(destination = ActivemqConfigure.DESTINATION_TOPIC, containerFactory = "jmsListenerContainerTopic")
//    public void onTopicMessage(String message) {
//        System.out.println("接收topic消息:"+message);
//    }

    @JmsListener(destination = ActivemqConfigure.DESTINATION_QUEUE, containerFactory = "jmsListenerContainerQueue")
    public void onQueueMessage(String message) {
        System.out.println("接收queue消息:"+message);
    }
}
