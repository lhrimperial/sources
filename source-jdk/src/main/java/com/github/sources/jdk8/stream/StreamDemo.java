package com.github.sources.jdk8.stream;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamDemo {

    public static void main(String[] args) {
//        List<String> words = Arrays.asList("Java 8","Lambdas","In", "Action");
//        words.stream().map(String::length).forEach(System.out::println);

        List<Dish> dishes = Arrays.asList("小葱", "豆腐", "鸡肉", "饺子皮", "打工诶奇偶")
                .stream().map((Function<String, Dish>) Dish::new).collect(Collectors.toList());

        dishes.stream().forEach(System.out::println);
    }

    static class Dish{
        private String name;

        public Dish(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Dish{" +
                    "name='" + name + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
