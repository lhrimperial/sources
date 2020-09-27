package com.github.sources.distributed.idempotent.service.impl;

import com.github.sources.distributed.idempotent.domain.UserPO;
import com.github.sources.distributed.idempotent.mapper.UserMapper;
import com.github.sources.distributed.idempotent.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public int insertUser(UserPO userPO) {
        return userMapper.insert(userPO);
    }
}
