package com.github.sources.thread.basic;

/**
 * Volatile能保证数据可见性和有序性
 */
public class VolatileVisibility {


    //如果不加入volatile，ReaderThread中读不到Main线程中的改变
//    private volatile static boolean ready;
    private static boolean ready;
    private static int number;

    public static void main(String[] args) throws Exception{
        Thread thread = new ReaderThread();
        thread.start();
        Thread.sleep(2000);
        ready = true;
        number = 32;
        Thread.sleep(2000);
    }

    public static class ReaderThread extends Thread {

        public void run() {
            while (!ready) {

            }
            System.out.println(number);
        }
    }



}
