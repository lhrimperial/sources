package com.github.sources.thread.multi.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class ThreadFactory {

    public static void main(String[] args){
        ExecutorService executor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(), new java.util.concurrent.ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                System.out.println("ThreadFactory create a thread : " + thread);
                return thread;
            }
        });

        for (int i = 0; i < 15; i++) {
            executor.submit(new MyTask());
        }

        executor.shutdown();
    }

    public static class MyTask implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println(System.currentTimeMillis()+" run thread: " + Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
