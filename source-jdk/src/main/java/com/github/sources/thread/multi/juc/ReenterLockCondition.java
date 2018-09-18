package com.github.sources.thread.multi.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class ReenterLockCondition implements Runnable{

    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) throws Exception{
        ReenterLockCondition task = new ReenterLockCondition();
        new Thread(task).start();
        Thread.sleep(2000);
        lock.lock();
        condition.signal();
        lock.unlock();
    }


    @Override
    public void run() {
        try {
            lock.lock();
            condition.await();
            System.out.println("thread going on");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
