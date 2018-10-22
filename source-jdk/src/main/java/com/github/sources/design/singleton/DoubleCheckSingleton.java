package com.github.sources.design.singleton;

/**
 *
 */
public class DoubleCheckSingleton {

    private volatile static DoubleCheckSingleton doubleCheckSingleton;

    private DoubleCheckSingleton() {
    };

    public static DoubleCheckSingleton getInstance() {
        //这里没有加synchronized
        if (doubleCheckSingleton == null) {
            //很多线程都能到达这里
            synchronized (DoubleCheckSingleton.class) {
                //有可能已经有线程更早一步创建了单利
                if (doubleCheckSingleton == null)
                    doubleCheckSingleton = new DoubleCheckSingleton();
            }
        }
        return doubleCheckSingleton;
    }
}
