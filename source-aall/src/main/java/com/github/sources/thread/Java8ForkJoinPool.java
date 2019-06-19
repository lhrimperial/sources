package com.github.sources.thread;

import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/**
 * @author hairen.long
 * @date 2019-05-10
 */
public class Java8ForkJoinPool {

    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.parallelStream().forEach(out::println);
    }
}
