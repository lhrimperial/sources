package com.github.sources.server.service.impl;

import com.github.sources.server.domain.UserDO;
import com.github.sources.server.mapper.UserMapper;
import com.github.sources.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hairen.long
 * @date 2019-05-08
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(UserDO userDO) {

        userMapper.save(userDO);
//        String str = null;
//        str.length();
    }

    @Override
    public void update(UserDO userDO) {

    }

    @Override
    public void getById(Integer id) {

    }

    @Override
    public List<UserDO> getAll() {
        return null;
    }
}
