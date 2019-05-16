package com.github.sources.rabbitmq.sboot.queue.configura;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hairen.long
 * @date 2019-05-14
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue(){
        return new Queue("hello");
    }

    @Bean
    public Queue queue2(){
        return new Queue("hello2");
    }
}
