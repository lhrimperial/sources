package com.github.sources.docker.compose.conctroller;

import com.github.sources.docker.compose.domain.UserDO;
import com.github.sources.docker.compose.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hairen.long
 * @date 2019-04-25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired private UserMapper userMapper;

    @RequestMapping("/save")
    public UserDO save(@RequestBody UserDO userDO) {
        userMapper.save(userDO);
        return userDO;
    }

    @RequestMapping("/queryById/{id}")
    public UserDO queryById(@PathVariable Integer id) {
        return userMapper.queryById(id);
    }

    @RequestMapping("/queryAll")
    public List<UserDO> queryAll() {
        return userMapper.queryAll();
    }
}
