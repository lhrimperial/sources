package com.github.sources.rabbitmq.base;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author hairen.long
 * @date 2019-05-13
 */
public class Publisher {

    public static void main(String[] args) {
        publisher(); // 推送消息
    }

    /** 推送消息 */
    public static void publisher() {
        // 创建一个连接
        Connection conn = ConnectionFactoryUtil.GetRabbitConnection();
        if (conn != null) {
            try {
                // 创建通道
                Channel channel = conn.createChannel();
                // 声明队列【参数说明：参数一：队列名称，参数二：是否持久化；参数三：是否独占模式；参数四：消费者断开连接时是否删除队列；参数五：消息其他参数】
                channel.queueDeclare(
                        ConnectionFactoryUtil.getQueueName(), false, false, false, null);
                String content = String.format("当前时间：%s", System.currentTimeMillis());
                // 发送内容【参数说明：参数一：交换机名称；参数二：队列名称，参数三：消息的其他属性-routing
                // headers，此属性为MessageProperties.PERSISTENT_TEXT_PLAIN用于设置纯文本消息存储到硬盘；参数四：消息主体】
                channel.basicPublish(
                        "", ConnectionFactoryUtil.getQueueName(), null, content.getBytes("UTF-8"));
                System.out.println("已发送消息：" + content);
                // 关闭连接
                channel.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
