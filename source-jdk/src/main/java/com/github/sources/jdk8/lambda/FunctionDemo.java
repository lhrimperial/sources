package com.github.sources.jdk8.lambda;

import java.util.function.Function;

public class FunctionDemo {

    public static Integer convert(String str, Function<String, Integer> function) {
        return function.apply(str);
    }

    public static void main(String[] args){

        Integer value = convert("28", x -> Integer.parseInt(x));
        System.out.println(value);
    }
}
