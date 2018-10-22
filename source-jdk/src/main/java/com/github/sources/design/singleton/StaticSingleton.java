package com.github.sources.design.singleton;

/**
 *
 */
public class StaticSingleton {

    // 利用了 classloder 机制来保证初始化 instance 时只有一个线程
    private static class SingletonHolder {
        private static final StaticSingleton INSTANCE = new StaticSingleton();
    }

    private StaticSingleton() {
    }

    public static final StaticSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
