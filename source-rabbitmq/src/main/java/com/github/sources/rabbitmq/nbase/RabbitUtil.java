package com.github.sources.rabbitmq.nbase;

import com.rabbitmq.client.ConnectionFactory;

/**
 * @author hairen.long
 * @date 2019-11-07
 */
public class RabbitUtil {
    public static ConnectionFactory getConnectionFactory() {
        //创建连接工程，下面给出的是默认的case
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("www.ifarmshop.com");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setVirtualHost("/");
        return factory;
    }
}
