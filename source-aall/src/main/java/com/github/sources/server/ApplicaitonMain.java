package com.github.sources.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hairen.long
 * @date 2019-05-08
 */
@SpringBootApplication
@MapperScan("com.github.sources.**.mapper")
public class ApplicaitonMain {

    public static void main(String[] args){
        SpringApplication.run(ApplicaitonMain.class, args);
    }
}
