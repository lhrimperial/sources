package com.github.sources.distributed.idempotent.comm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 *
 */
@Component
public class RedisToken {

    @Autowired
    private RedisServer redisServer;

    private static final long TOKEN_TIMEOUT = 60 * 60;

    public String getToken() {
        String token = "token_" + UUID.randomUUID();
        redisServer.setString(token, token, TOKEN_TIMEOUT);
        return token;
    }

    public boolean checkToken(String tokenKey) {
        String tokenValue = redisServer.getString(tokenKey);
        if (StringUtils.isEmpty(tokenValue)) {
            return false;
        }
        //保证每个接口对应的token只能访问一次
        redisServer.deleteKey(tokenKey);
        return true;
    }
}
