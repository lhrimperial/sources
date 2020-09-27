package com.github.sources.thread.multi.sync;

import com.github.sources.thread.basic.ThreadNewWays;

/**
 *
 */
public class AccountingSyncClass implements Runnable{

    private static int i = 0;

    public static void main(String[] args) throws Exception{
        /**
         * 静态方法中锁定的是Class对象，这里既是使用的是不同的对象，也能达到锁定的目的
         */
        Thread thread1 = new Thread(new AccountingSyncClass());
        Thread thread2 = new Thread(new AccountingSyncClass());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000; j++) {
            increase();
        }
    }

    public static synchronized void increase() {
        i++;
    }
}
