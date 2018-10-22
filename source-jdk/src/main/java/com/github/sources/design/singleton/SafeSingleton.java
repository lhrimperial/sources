package com.github.sources.design.singleton;

/**
 *
 */
public class SafeSingleton {
    private static SafeSingleton safeSingleton;

    // 必须为private，这是实例独一无二的保证
    private SafeSingleton() {

    }

    //保证线程安全
    public static synchronized SafeSingleton getInstance() {
        // 如果不存在则实例一个
        if (safeSingleton == null) {
            safeSingleton = new SafeSingleton();
        }
        return safeSingleton;
    }
}
