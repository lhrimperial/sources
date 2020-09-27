package com.github.sources.distributed;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 */
@SpringBootApplication
@MapperScan("com.github.sources.distributed.**.mapper")
public class DistributedMain {

    public static void main(String[] args){
        SpringApplication.run(DistributedMain.class, args);
    }
}
