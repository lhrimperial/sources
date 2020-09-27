package com.github.sources.thread.multi.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class TryLock implements Runnable {
    private ReentrantLock lock1 = new ReentrantLock();
    private ReentrantLock lock2 = new ReentrantLock();
    private static int count = 0;

    int lock;

    public TryLock(int lock) {
        this.lock = lock;
    }

    public static void main(String[] args){
        new Thread(new TryLock(1)).start();
        new Thread(new TryLock(2)).start();
        System.out.println(count);
    }

    @Override
    public void run() {
        if (lock == 1) {
            while (true) {
                if (lock1.tryLock()) {
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (lock2.tryLock()) {
                            try {
                                if (count++ > 10) {
                                    break;
                                }
                                System.out.println(Thread.currentThread().getName()+" my job is done");
                            } finally {
                                lock2.unlock();
                            }
                        }
                    } finally {
                        lock1.unlock();
                    }
                }
            }
        } else {
            while (true) {
                if (lock2.tryLock()) {
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (lock1.tryLock()) {
                            try {
                                if (count++ > 10) {
                                    break;
                                }
                                System.out.println(Thread.currentThread().getName()+" my job is done");
                            } finally {
                                lock1.unlock();
                            }
                        }
                    } finally {
                        lock2.unlock();
                    }
                }
            }
        }
    }
}
