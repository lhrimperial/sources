package com.github.sources.gc;


/**
 * testGC() 方法执行后, objA和objB会不会被GC呢？
 *
 * @author zzm
 */
public class ReferenceCountingGC {
    private static final int _1MB=1024*1024;
    /**
     *VM参数： -verbose： gc-Xms20M-Xmx20M-Xmn10M-XX： +PrintGCDetails
     -XX： SurvivorRatio=8
     */

    public static void main(String[] args){
        testAllocation();
    }

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5,allocation6,allocation7;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB]; //出现一次Minor GC

        allocation5 = new byte[4 * _1MB];
        allocation6 = new byte[4 * _1MB];
//        allocation7 = new byte[4 * _1MB];
    }
}