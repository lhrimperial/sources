package com.github.sources.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 */
@Service
public class DeadCycleService {

    private volatile boolean isBreak =  false;

    private ExecutorService service = Executors.newFixedThreadPool(10);

    public void breakDeadCycle() {
        this.isBreak = true;
    }

    public void startDeadCycle() {
        for (int k = 0;k < 10;k++) {
            service.submit(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if (isBreak) {
                            break;
                        }
                        System.out.println("DeadCycleThread is Running");
                        long sum = 0;
                        for (int i = 0; i < Long.MAX_VALUE;i++) {
                            sum ++;
                            if (sum > Long.MAX_VALUE) {
                                sum = 0;
                            }
                        }
                    }
                }
            });
        }
    }
}
