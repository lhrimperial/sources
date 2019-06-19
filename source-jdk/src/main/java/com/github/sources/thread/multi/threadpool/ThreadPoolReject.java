package com.github.sources.thread.multi.threadpool;

import java.util.concurrent.*;

/**
 *
 */
public class ThreadPoolReject {

    public static void main(String[] args){
        ExecutorService executor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10), Executors.defaultThreadFactory()
                , new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println(r.toString() + " is discard");
                    }
        });

        for (int i = 0; i < 1000; i++) {
            executor.submit(new MyTask());
        }

        executor.shutdown();
    }

    public static class MyTask implements Runnable{

        @Override
        public void run() {
            try {
                System.out.println(System.currentTimeMillis() + " run thread: " + Thread.currentThread().getName());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
