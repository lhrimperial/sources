package com.github.sources.thread.forkjoin;

import java.util.stream.LongStream;

/**
 * @author hairen.long
 * @date 2019-05-14
 */
public class Main {
    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 1000).toArray();
        Calculator calculator = new ForkJoinCalculator();
        System.out.println(calculator.sumUp(numbers));
        // 打印结果500500
    }
}
