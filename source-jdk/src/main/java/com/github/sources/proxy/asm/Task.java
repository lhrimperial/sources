package com.github.sources.proxy.asm;

/**
 *
 */
public class Task {

    private int isTask = 0;

    private long tell = 0;

    public void isTask(){
        System.out.println("call isTask");
    }
    public void tellMe(){
        System.out.println("call tellMe");
    }

    class TaskInner{
        int inner;
    }

}
