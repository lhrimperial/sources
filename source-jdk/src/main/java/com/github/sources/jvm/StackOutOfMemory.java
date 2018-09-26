package com.github.sources.jvm;

import java.util.TreeMap;

/**
 * 栈中存储：基本数据类型，对象引用，方法等
 */
public class StackOutOfMemory {
    public static int count = 1;

    public void noStop() {
        while (true) {

        }
    }

    public void newThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("已创建第"+count+++"个线程");
                    noStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args){
        new StackOutOfMemory().newThread();
    }
}
