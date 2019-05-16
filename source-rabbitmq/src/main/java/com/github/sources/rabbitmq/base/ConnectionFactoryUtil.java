package com.github.sources.rabbitmq.base;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author hairen.long
 * @date 2019-05-13
 */
public class ConnectionFactoryUtil {

    static Config config = Config.builder()
            .host("ifarmshop.com")
            .password("admin")
            .userName("admin")
            .port("5672")
            .vhost("/")
            .queueName("Hello")
            .build();

    public static String getQueueName(){
        return config.getQueueName();
    }

    public static Connection GetRabbitConnection() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(config.getUserName());
        factory.setPassword(config.getPassword());
        factory.setVirtualHost(config.getVhost());
        factory.setHost(config.getHost());
        factory.setPort(Integer.valueOf(config.getPort()));
        Connection conn = null;
        try {
            conn = factory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static Connection GetRabbitConnection2() {
        ConnectionFactory factory = new ConnectionFactory();
        // 连接格式：amqp://userName:password@hostName:portNumber/virtualHost
        String uri =
                String.format(
                        "amqp://%s:%s@%s:%d%s",
                        config.getUserName(),
                        config.getPassword(),
                        config.getHost(),
                        config.getPort(),
                        config.getVhost());
        Connection conn = null;
        try {
            factory.setUri(uri);
            factory.setVirtualHost(config.getVhost());
            conn = factory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
