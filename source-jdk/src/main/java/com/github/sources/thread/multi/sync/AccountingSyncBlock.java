package com.github.sources.thread.multi.sync;

/**
 *
 */
public class AccountingSyncBlock implements Runnable{

    private static int i = 0;
    private static Object obj = new Object();

    public static void main(String[] args) throws Exception{
        Thread thread1 = new Thread(new AccountingSyncBlock());
        Thread thread2 = new Thread(new AccountingSyncBlock());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }

    public void increase() {
        synchronized (obj) {
            i++;
        }
    }

    @Override
    public void run() {
        for (int k = 0; k < 10000; k++) {
            increase();
        }
    }
}
