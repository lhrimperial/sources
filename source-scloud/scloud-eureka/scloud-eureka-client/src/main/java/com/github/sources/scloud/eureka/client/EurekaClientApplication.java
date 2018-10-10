package com.github.sources.scloud.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@EnableEurekaClient
@SpringBootApplication
@RestController
public class EurekaClientApplication {

    public static void main(String[] args){
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @RequestMapping("/hi")
    public String say() {
        return "Hi, Nice To Meet You";
    }
}
