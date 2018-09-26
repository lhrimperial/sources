package com.github.sources.controller;

import com.github.sources.service.DeadCycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class DeadCycleController {

    @Autowired
    private DeadCycleService deadCycleService;

    @RequestMapping("/deadCycle/{command}")
    private String dealDeadCycle(@PathVariable String command) {
        if ("start".equals(command)) {
            deadCycleService.startDeadCycle();
        } else if ("break".equals(command)) {
            deadCycleService.breakDeadCycle();
        }
        return "success";
    }
    //
}
