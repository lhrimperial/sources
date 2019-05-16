package com.github.sources.server.controller;

import com.github.sources.server.domain.UserDO;
import com.github.sources.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author hairen.long
 * @date 2019-05-08
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired private IUserService userService;

    @RequestMapping("/save")
    public String save() {
        Random random = new Random();
        UserDO userDO =
                UserDO.builder()
                        .userName("andy_" + random.nextInt(100))
                        .password("" + random.nextInt(100))
                        .build();
        userService.save(userDO);
        return "success";
    }
}
