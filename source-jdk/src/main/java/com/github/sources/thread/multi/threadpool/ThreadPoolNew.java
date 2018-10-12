package com.github.sources.thread.multi.threadpool;

import java.util.concurrent.*;

/**
 *
 */
public class ThreadPoolNew {

    public static void main(String[] args){
        /**
         * corePoolSize：指定线程池中线程的数量
         * maximumPoolSize：指定线程池中最大线程数量
         * keepAliveTime：当线程池中的线程大于corePoolSize时，多余的线程存活的时长
         * timeUnit：keepAliveTime 的单位
         * workQueue：任务队列，存放被提交尚未被执行的任务
         * threadFactory：线程工厂
         * handle：拒绝策略，任务太多，没有多余的线程执行且任务队列已满
         */
        ExecutorService executor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10), Executors.defaultThreadFactory(),  new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 15; i++) {
            executor.submit(new MyTask());
        }

        executor.shutdown();

    }

    public static class MyTask implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println(System.currentTimeMillis() + " run thread : " + Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
