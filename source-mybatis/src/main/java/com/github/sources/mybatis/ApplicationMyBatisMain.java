package com.github.sources.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 */
@SpringBootApplication
@MapperScan("com.github.sources.**.mapper")
public class ApplicationMyBatisMain {

    public static void main(String[] args){
        SpringApplication.run(ApplicationMyBatisMain.class, args);
    }
}
