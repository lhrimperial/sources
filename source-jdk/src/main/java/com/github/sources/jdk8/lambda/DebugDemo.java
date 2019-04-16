package com.github.sources.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hairen.long
 * @date 2019-03-31
 */
public class DebugDemo {

    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7);
        test2(numbers);

    }

    public static void test2(List<Integer> numbers) {
        List<Integer> result = numbers.stream()
                .peek(x -> System.out.println("from stream: " + x))
                .map(x -> x + 17)
                .peek(x -> System.out.println("after map: " + x))
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("after filter: " + x))
                .limit(3)
                .peek(x -> System.out.println("after limit: " + x))
                .collect(Collectors.toList());
    }

    public static void test1(List<Integer> numbers) {
        numbers.stream().map(x -> x+17)
                .filter(x -> x % 2 == 0)
                .limit(3)
                .forEach(System.out::println);

    }
}

