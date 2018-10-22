package com.github.sources.design.singleton;

/**
 *
 */
public class EagerSingleton {
    //JVM加载这个类时就创建
    private static EagerSingleton eagerSingleton = new EagerSingleton();

    private EagerSingleton(){};

    public static EagerSingleton  getInstance(){
        return eagerSingleton;
    }
}
