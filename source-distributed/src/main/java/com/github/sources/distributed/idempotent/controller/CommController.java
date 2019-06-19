package com.github.sources.distributed.idempotent.controller;

import com.github.sources.distributed.idempotent.annotation.CheckToken;
import com.github.sources.distributed.idempotent.comm.RedisToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class CommController {

    @Autowired
    private RedisToken redisToken;

    @RequestMapping("/getToken")
    public String refreshToken() {
        return redisToken.getToken();
    }
}
