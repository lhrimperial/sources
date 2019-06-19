package com.github.sources.jdk8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

    public static List<String> filter(List<String> fruit, Predicate<String> predicate) {
        List<String> result = new ArrayList<>();
        for (String str : fruit) {
            if (predicate.test(str)){
                result.add(str);
            }
        }
        return result;
    }

    public static void main(String[] args){
        List<String> fruit = Arrays.asList("香蕉", "哈密瓜", "榴莲", "火龙果", "水蜜桃");
        List<String> newFruit = filter(fruit, (f) -> f.length() == 2);
        System.out.println(newFruit);
    }
}
