package com.github.sources.activemq.consumer.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 *
 */
public class Consumer2 {
    public static final String BROKER_URL = "tcp://10.200.6.197:61616";
    public static final String DESTINATION = "activemq.test.topic";

    public static void main(String[] args){
        Connection connection = null;
        Session session = null;

        try {
            ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                    ActiveMQConnectionFactory.DEFAULT_PASSWORD, BROKER_URL);
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createTopic(DESTINATION);
            MessageConsumer consumer = session.createConsumer(destination);
            consumer.setMessageListener(new Consumer2.MessageConsumerListener());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static class MessageConsumerListener implements javax.jms.MessageListener{
        @Override
        public void onMessage(Message message) {
            try {
                System.out.println("Consumer2 接收到的消息："+((TextMessage)message).getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
