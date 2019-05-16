package com.github.sources.rabbitmq.sboot.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hairen.long
 * @date 2019-05-14
 */
@Configuration
public class TopicRabbitConfig {

    static final String message = "topic.message";
    static final String messages = "topic.messages";

    /**
     * 创建两个 Queue
     *
     * @return
     */
    @Bean
    public Queue queueMessage() {
        return new Queue(TopicRabbitConfig.message);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(TopicRabbitConfig.messages);
    }

    /**
     * 配置 TopicExchange,指定名称为 topicExchange
     *
     * @return
     */
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    /**
     * 给队列绑定 exchange 和 routing_key
     *
     * @param queueMessage
     * @param exchange
     * @return
     */
    @Bean
    public Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    public Binding bingingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
