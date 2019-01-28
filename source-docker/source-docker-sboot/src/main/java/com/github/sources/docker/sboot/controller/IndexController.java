package com.github.sources.docker.sboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/docker")
public class IndexController {

    @GetMapping("/getValue")
    public String getValue() {
        return "Hello Docker";
    }
}
