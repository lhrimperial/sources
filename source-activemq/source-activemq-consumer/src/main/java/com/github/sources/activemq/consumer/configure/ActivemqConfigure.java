package com.github.sources.activemq.consumer.configure;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.autoconfigure.jms.JmsProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.ConnectionFactory;

/**
 *
 */
@Configuration
@EnableJms
public class ActivemqConfigure {

    public static final String BROKER_URL = "tcp://10.200.6.197:61616";
    public static final String DESTINATION_TOPIC = "activemq.test.topic";
    public static final String DESTINATION_QUEUE = "activemq.test.queue";

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
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
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
//        bean.setConcurrency("3-5");
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }

}
