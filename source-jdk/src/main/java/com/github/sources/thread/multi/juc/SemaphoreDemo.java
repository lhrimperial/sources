package com.github.sources.thread.multi.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 *
 */
public class SemaphoreDemo {
    static int count = 0;

    public static void main(String[] args) {
        // 线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        //设置信号量同时执行的线程数是5
        final Semaphore semp = new Semaphore(5);

        // 模拟20个客户端访问
        for (int index = 0; index < 20; index++) {
            final int NO = index;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        //使用acquire()获取锁
                        semp.acquire();
                        System.out.println("Accessing: " + NO);
                        for (int i = 0; i < 1000; i++) {
                            count++;
                        }

                    } catch (InterruptedException e) {
                    }  finally {
                        //使用完成释放锁
                        semp.release();
                    }
                }
            };
            exec.execute(run);
        }
        // 退出线程池
        exec.shutdown();
        System.out.println("count: " + count);
    }
}
