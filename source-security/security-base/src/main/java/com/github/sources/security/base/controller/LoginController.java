package com.github.sources.security.base.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class LoginController {

    @RequestMapping("/user/login")
    public String login() {
        System.out.println("login success");
        return "login success";
    }
}
