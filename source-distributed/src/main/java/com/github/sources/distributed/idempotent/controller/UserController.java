package com.github.sources.distributed.idempotent.controller;

import com.github.sources.distributed.idempotent.annotation.CheckToken;
import com.github.sources.distributed.idempotent.domain.ResponseStatus;
import com.github.sources.distributed.idempotent.domain.UserPO;
import com.github.sources.distributed.idempotent.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @CheckToken
    @RequestMapping("/saveUser")
    public ResponseStatus saveUser(@RequestBody UserPO userPO) {
        ResponseStatus response = new ResponseStatus();
        userService.insertUser(userPO);
        response.setRespMsg("保存成功");
        return response;
    }
}
