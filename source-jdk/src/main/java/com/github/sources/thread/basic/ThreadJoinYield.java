package com.github.sources.thread.basic;

/**
 *
 */
public class ThreadJoinYield {
    public volatile  static int i = 0;
    public static void main(String[] args) throws Exception{
        Thread thread = new AddThread();
        thread.start();
        //阻塞当前线程，即main线程，直到AddThread线程执行完毕
        thread.join();
        System.out.println(i);

    }

    public static class AddThread extends Thread {
        public void run() {
            System.out.println("AddThread started ...");
            for (i=0;i<1000000;i++) {
                if (i%50000==0) {
                    System.out.println("thread yield cpu");
                    //使当前线程让出CPU时间
                    Thread.yield();
                }
            }
        }
    }
}
