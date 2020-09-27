package com.github.sources.thread.multi.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class ThreadPoolExpansion {

    public static void main(String[] args){
        ExecutorService executor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10)){
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行： " + ((MyTask)r).name);
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("执行完成： " + ((MyTask)r).name);
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");
            }
        };

        for (int i = 0; i < 5; i++) {
            executor.execute(new MyTask("TASK-NAME-" + i));
        }
        executor.shutdown();
    }

    public static class MyTask implements Runnable {

        private String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(System.currentTimeMillis() + " run thread " + Thread.currentThread().getName());
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
