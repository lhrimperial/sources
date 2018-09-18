package com.github.sources.thread.multi.sync;

/**
 *
 */
public class AccountingSyncInstance implements Runnable {

    private static int i = 0;

    public static void main(String[] args) throws Exception{
        AccountingSyncInstance instance = new AccountingSyncInstance();
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
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

    /**
     * synchronized 修饰实例方法，即锁的是当前对象this
     */
    public synchronized void increase() {
        i++;
    }
}
