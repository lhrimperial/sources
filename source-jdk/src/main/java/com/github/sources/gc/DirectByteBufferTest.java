package com.github.sources.gc;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class DirectByteBufferTest {

    public static void main(String[] args) throws Exception{
        test();
    }

    public static void test() throws Exception{
        //分配128MB直接内存
        ByteBuffer bb = ByteBuffer.allocateDirect(1024*1024*128);

        TimeUnit.SECONDS.sleep(10);
        System.out.println("ok");
        bb = null;

        TimeUnit.SECONDS.sleep(1000000);
    }
}
