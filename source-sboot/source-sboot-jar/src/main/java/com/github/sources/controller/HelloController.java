package com.github.sources.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        JSON.toJSONString("");
        return "Hello World";
    }
}
