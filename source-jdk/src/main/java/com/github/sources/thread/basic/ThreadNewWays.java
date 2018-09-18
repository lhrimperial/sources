package com.github.sources.thread.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程初始化过程：
 * 1. new Thread()过程中会为线程设置线程组、执行目标、线程名、线程栈大小
 *    默认和主线程一个组；Thread 实现了Runnable，本身即为一个执行目标
 * 2. 真正创建线程是在start()中，这里使用了本地调用，通过C代码初始化线程需要的系统资源。
 *    此时start()的这个线程处于就绪状态，当得到CPU的时间片后就会执行其中的run()方法。
 * 3. 线程从创建到最终的消亡，要经历若干个状态。
 *    一般来说，线程包括以下这几个状态：创建(new)、就绪(runnable)、运行(running)、阻塞(blocked)、等待（time waiting、waiting）、消亡（dead）。
 *
 */
public class ThreadNewWays {

    public static void main(String[] args){
        firstWay();
        secondWay();
        thirdWay();
    }

    /**
     * 继承Thead类重写run方法， Thread实现了Runnable接口，本身就是一个执行任务
     */
    public static void firstWay() {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("this is first way to new thread!");
            }
        };
        thread.start();
    }

    /**
     * 通过实现Runnable接口告诉线程执行什么任务
     */
    public static void secondWay() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("this is second way to new thread!");
            }
        }).start();
    }

    /**
     * 通过线程池创建线程
     */
    public static void thirdWay() {
        ExecutorService service = new ThreadPoolExecutor(1, 1, 0L,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("this si third way to new thread !");
            }
        });

        service.shutdown();
    }
}
