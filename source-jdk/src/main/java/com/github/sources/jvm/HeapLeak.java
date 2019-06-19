package com.github.sources.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆溢出
 */
public class HeapLeak {

    /**
     * Java堆中存放：对象、数组。
     * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     * @param args
     */
    public static void main(String[] args){
        List<HeapLeak> list = new ArrayList<>();
        while (true) {
            list.add(new HeapLeak());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
