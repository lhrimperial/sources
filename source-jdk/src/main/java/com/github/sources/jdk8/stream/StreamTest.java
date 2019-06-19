package com.github.sources.jdk8.stream;

import java.util.Collections;
import java.util.List;

/**
 * @author hairen.long
 * @date 2019-03-29
 */
public class StreamTest {

    public static void main(String[] args){
        List<Integer> list = Collections.emptyList();
        list.stream().forEach(System.out::println);
    }
}
