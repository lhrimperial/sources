package com.github.sources.dubbo.provider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 */
@SpringBootApplication
@EnableDubboConfiguration
public class ProviderMain {

    public static void main(String[] args){
        SpringApplication.run(ProviderMain.class, args);
    }
}
