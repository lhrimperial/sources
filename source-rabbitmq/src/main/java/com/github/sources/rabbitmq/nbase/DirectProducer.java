package com.github.sources.rabbitmq.nbase;

import com.rabbitmq.client.BuiltinExchangeType;

/**
 * @author hairen.long
 * @date 2019-11-07
 */
public class DirectProducer {
    private static final String EXCHANGE_NAME = "direct.exchange";

    public void publishMsg(String routingKey, String msg) {
        try {
            MsgProducer.publishMsg(EXCHANGE_NAME, BuiltinExchangeType.DIRECT, routingKey, msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DirectProducer directProducer = new DirectProducer();
        String[] routingKey = new String[] {"aaa", "bbb"};
        String msg = "hello >>> ";

        for (int i = 0; i < 30; i++) {
            directProducer.publishMsg(routingKey[i % 2], msg + i);
        }
        System.out.println("----over-------");
    }
}
