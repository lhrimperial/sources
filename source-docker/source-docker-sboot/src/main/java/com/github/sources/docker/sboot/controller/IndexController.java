package com.github.sources.docker.sboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/docker")
public class IndexController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/getIncrement")
    public String getIncrement() {
        Long increment = redisTemplate.opsForValue().increment(1, 1);
        return "This increment：" + increment;
    }

    @GetMapping("/getValue")
    public String getValue() {
        return "Hello Docker";
    }
}
