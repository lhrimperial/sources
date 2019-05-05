package com.github.sources.docker.compose;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hairen.long
 * @date 2019-04-25
 */
@SpringBootApplication
@MapperScan("com.github.sources.docker.compose.mapper")
public class ComposeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComposeApplication.class, args);
    }
}
