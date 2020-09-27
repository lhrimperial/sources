package com.github.sources.sboot.security.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String helloWorld(){
        return "spring security hello world";
    }

    @RequestMapping("/whoim")
    public Object whoIm() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
