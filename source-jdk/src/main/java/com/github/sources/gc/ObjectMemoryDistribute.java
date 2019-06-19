package com.github.sources.gc;

public class ObjectMemoryDistribute {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args){
//        testAllocation();
        testPretenureSizeThreshold();
    }

    /**
     * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
     * 对象超过3M 时直接进入老年代
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];  //直接分配在老年代中
        Long temp = null;
        Integer integer = null;

    }

    /**
     *  * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * 	 * 限制java堆大小为20M，年轻代为10M，Eden为8M，两个survivor分别为1M
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];  // 出现一次Minor GC

        /**
         * [GC (Allocation Failure) [PSYoungGen: 6826K->808K(9216K)] 6826K->4912K(19456K), 0.0096119 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
         * Heap
         *  PSYoungGen      total 9216K, used 7160K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
         *   eden space 8192K, 77% used [0x00000000ff600000,0x00000000ffc343a0,0x00000000ffe00000)
         *   from space 1024K, 78% used [0x00000000ffe00000,0x00000000ffeca020,0x00000000fff00000)
         *   to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
         *  ParOldGen       total 10240K, used 4104K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
         *   object space 10240K, 40% used [0x00000000fec00000,0x00000000ff002020,0x00000000ff600000)
         *  Metaspace       used 3273K, capacity 4496K, committed 4864K, reserved 1056768K
         *   class space    used 357K, capacity 388K, committed 512K, reserved 1048576K
         */
    }

}
