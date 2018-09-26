package com.github.sources.jdk8;

import java.util.Arrays;

/**
 *
 */
public class DeclarativeDemo {

    public static void main(String[] args){
//        declarative();
        oddNumber();
    }

    public static void oddNumber() {
        int[] arr = {1, 3, 2, 78, 9, 4, 2, 678,5,7,9,11};
//        Arrays.stream(arr).map(x->(x%2==0?x:x+1)).forEach(System.out::println);
    }

    public static void declarative() {
        int[] arr = {1, 3, 2, 78, 9, 4, 2, 678};
//        Arrays.stream(arr).forEach(System.out:: println);
    }
}
