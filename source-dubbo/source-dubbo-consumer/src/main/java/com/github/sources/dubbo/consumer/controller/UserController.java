package com.github.sources.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.sources.dubbo.api.domain.UserDTO;
import com.github.sources.dubbo.api.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class UserController {

    @Reference
    private IUserService userService;

    @RequestMapping("/findUser")
    UserDTO findUser() {
        return userService.findUserByName("");
    }
}
