package com.github.sources.rabbitmq.nbase;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author hairen.long
 * @date 2019-11-07
 */
public class DirectConsumer {
    private static final String exchangeName = "direct.exchange";

    public void msgConsumer(String queueName, String routingKey) {
        try {
            MsgConsumer.consumerMsg(exchangeName, queueName, routingKey);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DirectConsumer consumer = new DirectConsumer();
        String[] routingKey = new String[] {"aaa", "bbb"};
        String[] queueNames = new String[] {"qa", "qb"};

        for (int i = 0; i < 2; i++) {
            consumer.msgConsumer(queueNames[i], routingKey[i]);
        }

        Thread.sleep(1000 * 60 * 10);
    }
}
