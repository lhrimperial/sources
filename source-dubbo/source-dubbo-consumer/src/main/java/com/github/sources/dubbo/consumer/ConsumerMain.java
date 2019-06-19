package com.github.sources.dubbo.consumer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 */
@SpringBootApplication
@EnableDubboConfiguration
public class ConsumerMain {

    public static void main(String[] args){
        SpringApplication.run(ConsumerMain.class, args);
    }
}
