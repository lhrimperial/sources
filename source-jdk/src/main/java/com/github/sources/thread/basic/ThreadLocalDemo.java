package com.github.sources.thread.basic;

/**
 *
 */
public class ThreadLocalDemo {

    static ThreadLocal<Integer> count = new ThreadLocal<>();

    public static void main(String[] args){
        count.set(1);
        System.out.println(count.get());
    }
}
