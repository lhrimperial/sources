package com.github.sources.activemq.producer.configure;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

/**
 *
 */
@Configuration
public class ActivemqConfigure {

    public static final String BROKER_URL = "tcp://10.200.6.197:61616";
    public static final String DESTINATION_TOPIC = "activemq.test.topic";
    public static final String DESTINATION_QUEUE = "activemq.test.queue";

    @Bean
    public ConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory(BROKER_URL);
    }

    @Bean("queueDestination")
    public ActiveMQQueue queueDestination() {
        return new ActiveMQQueue(DESTINATION_QUEUE);
    }

    @Bean("topicDestination")
    public ActiveMQTopic topicDestination() {
        return new ActiveMQTopic(DESTINATION_TOPIC);
    }

    @Bean
    public JmsMessagingTemplate jmsMessagingTemplate(ConnectionFactory connectionFactory) {
        return new JmsMessagingTemplate(connectionFactory);
    }
}
