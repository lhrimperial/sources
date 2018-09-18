package com.github.sources.thread.multi.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class ReenterLock implements Runnable {

    private ReentrantLock lock = new ReentrantLock();
    private static int i = 0;

    public static void main(String[] args) throws Exception{
        ReenterLock task = new ReenterLock();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

    @Override
    public void run() {
        for (int k = 0; k < 1000; k++) {
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
            }
        }
    }
}
