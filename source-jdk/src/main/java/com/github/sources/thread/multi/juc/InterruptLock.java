package com.github.sources.thread.multi.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class InterruptLock implements Runnable {

    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public InterruptLock(int lock) {
        this.lock = lock;
    }

    public static void main(String[] args) throws Exception{
        Thread thread1 = new Thread(new InterruptLock(1));
        Thread thread2 = new Thread(new InterruptLock(2));
        thread1.start();
        thread2.start();
        Thread.sleep(800);
        //两个线程产生死锁，通过中断thread2打破死锁
        thread2.interrupt();

    }

    @Override
    public void run() {
        try {
            if (lock == 1) {
                lock1.lockInterruptibly();
                Thread.sleep(500);
                lock2.lockInterruptibly();
            } else {
                lock2.lockInterruptibly();
                Thread.sleep(500);
                lock1.lockInterruptibly();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getName()+":线程退出");
        }
    }
}
