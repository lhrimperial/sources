package com.github.sources.activemq.consumer.queue.receiver;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 *
 */
public class MessageReceiver {

    public static final String BROKER_URL = "tcp://10.200.6.197:61616";
    public static final String DESTINATION = "activemq.test.queue";

    public static void run() {
        Connection connection = null;
        Session session = null;

        try {
            ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                    ActiveMQConnectionFactory.DEFAULT_PASSWORD, BROKER_URL);
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(DESTINATION);
            MessageConsumer consumer = session.createConsumer(destination);
            while (true) {
                TextMessage textMessage=(TextMessage)consumer.receive(100000);
                if(textMessage!=null){
                    System.out.println("收到的消息："+textMessage.getText());
                }else{
                    break;
                }
            }
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            try {
                if (session != null) {
                    session.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        run();
    }

}
