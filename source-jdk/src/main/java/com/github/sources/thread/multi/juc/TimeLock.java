package com.github.sources.thread.multi.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class TimeLock implements Runnable {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args){
        TimeLock task = new TimeLock();
        new Thread(task).start();
        new Thread(task).start();
    }

    @Override
    public void run() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName()+" get lock");
                Thread.sleep(6000);
            } else {
                System.out.println("get lock failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
