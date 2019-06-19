package com.github.sources.thread.forkjoin;

/**
 * @author hairen.long
 * @date 2019-05-15
 */
public class WhileTest {

    public static void main(String[] args) {
        int count = 0;
        while (true) {
            System.out.println("hello:" + count);
            if (count++ > 100) {
                break;
            }
        }
    }
}
