package com.github.sources.rabbitmq.base;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

/**
 * @author hairen.long
 * @date 2019-05-13
 */
public class Consumer {

    public static void main(String[] args) {
        consumer();
    }

    /** 消费消息 */
    public static void consumer() {
        // 创建一个连接
        Connection conn = ConnectionFactoryUtil.GetRabbitConnection();
        if (conn != null) {
            try {
                // 创建通道
                Channel channel = conn.createChannel();
                // 声明队列【参数说明：参数一：队列名称，参数二：是否持久化；参数三：是否独占模式；参数四：消费者断开连接时是否删除队列；参数五：消息其他参数】
                channel.queueDeclare(
                        ConnectionFactoryUtil.getQueueName(), false, false, false, null);

                // 创建订阅器，并接受消息
                channel.basicConsume(
                        ConnectionFactoryUtil.getQueueName(),
                        false,
                        "",
                        new DefaultConsumer(channel) {
                            @Override
                            public void handleDelivery(
                                    String consumerTag,
                                    Envelope envelope,
                                    AMQP.BasicProperties properties,
                                    byte[] body)
                                    throws IOException {
                                String routingKey = envelope.getRoutingKey(); // 队列名称
                                String contentType = properties.getContentType(); // 内容类型
                                String content = new String(body, "utf-8"); // 消息正文
                                System.out.println("消息正文：" + content);
                                channel.basicAck(
                                        envelope.getDeliveryTag(),
                                        false); // 手动确认消息【参数说明：参数一：该消息的index；参数二：是否批量应答，true批量确认小于index的消息】
                            }
                        });

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
