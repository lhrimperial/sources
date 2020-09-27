package com.github.sources.thread.basic;

/**
 *
 */
public class ThreadBase {

    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("ThreadBase test......");
            }
        }).start();
    }
}
