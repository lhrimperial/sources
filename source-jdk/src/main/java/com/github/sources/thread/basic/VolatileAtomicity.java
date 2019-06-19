package com.github.sources.thread.basic;

/**
 * volatile 不能保证原子性操作，volatile代替不了锁
 */
public class VolatileAtomicity {

    static volatile int i = 0;

    public static void main(String[] args) throws Exception{
        Thread[] threads = new Thread[10];
        for (int j = 0; j < 10; j++) {
            threads[j] = new Thread(new PlusTask());
            threads[j].start();
        }

        for (int j = 0; j < 10; j++) {
            threads[j].join();
        }

        System.out.println(i);
    }

    public static class PlusTask implements Runnable {

        @Override
        public void run() {
            for (int k = 0; k < 10000; k++) {
                i++;
            }
        }
    }
}
