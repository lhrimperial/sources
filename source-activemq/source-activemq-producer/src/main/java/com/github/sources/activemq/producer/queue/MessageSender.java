package com.github.sources.activemq.producer.queue;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 *
 */
public class MessageSender {

    public static final int SEND_NUM = 5;
    public static final String BROKER_URL = "tcp://10.200.6.197:61616";
    public static final String DESTINATION = "activemq.test.queue";

    public static void run(){
        Connection connection = null;
        Session session = null;
        try {
            ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER,
                    ActiveMQConnectionFactory.DEFAULT_PASSWORD, BROKER_URL);
            //创建一个连接
            connection = factory.createConnection();
            //启动连接
            connection.start();
            ((ActiveMQConnection)connection).setUseAsyncSend(false);
            //创建会话
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            //创建一个队列
            Destination destination = session.createQueue(DESTINATION);
            //创建消息生产者
            MessageProducer producer = session.createProducer(destination);
            //设置持久模式
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            sendMessage(session, producer);
            //提交会话
            session.commit();
        } catch (Exception e) {
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

    public static void sendMessage(Session session, MessageProducer producer) throws Exception {
        for (int i = 0; i < SEND_NUM; i++) {
            String message = "发送消息第" + (i + 1) + "条";
            TextMessage text = session.createTextMessage(message);

            System.out.println(message);
            producer.send(text);
        }
    }

    public static void main(String[] args){
        run();
    }
}
