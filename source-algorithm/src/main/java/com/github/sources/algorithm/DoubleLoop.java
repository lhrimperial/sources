package com.github.sources.algorithm;

/**
 *
 */
public class DoubleLoop {

    private static int big = 1000000000;
    private static int small = 1000;

    public static void main(String[] args){
        BigNestSmall();
        smallNestBig();
    }

    public static void BigNestSmall() {
        Long start = System.currentTimeMillis();
        for (int i = 0; i < big; i++) {
            for (int j = 0; j < small; j++) {

            }
        }
        System.out.println("BigNestSmall cast time : " + (System.currentTimeMillis() - start));
    }

    public static void smallNestBig() {
        Long start = System.currentTimeMillis();
        for (int i = 0; i < small; i++) {
            for (int j = 0; j < big; j++) {

            }
        }
        System.out.println("smallNestBig cast time : " + (System.currentTimeMillis() - start));
    }
}
