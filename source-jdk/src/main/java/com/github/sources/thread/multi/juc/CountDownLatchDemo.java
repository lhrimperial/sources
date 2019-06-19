package com.github.sources.thread.multi.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/**
 *
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception{
        //开始计数
        final CountDownLatch begin = new CountDownLatch(1);

        //结束计数
        final CountDownLatch end = new CountDownLatch(10);

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for(int i = 0; i < 10; i++) {
            final int NO = i + 1;
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        begin.await();
                        Thread.sleep((long) (Math.random()*10000));
                        System.out.println(NO + " is arrived");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        end.countDown();
                    }
                }
            });
        }

        System.out.println("start run....");
        begin.countDown();
        end.await();
        System.out.println("game over");

        executor.shutdown();
    }

}
