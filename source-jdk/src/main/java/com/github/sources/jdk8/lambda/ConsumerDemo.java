package com.github.sources.jdk8.lambda;

import java.util.function.Consumer;

public class ConsumerDemo {

    public static void donation(Integer money, Consumer<Integer> consumer){
        consumer.accept(money);
    }

    public static void main(String[] args) {
        donation(1000, money -> System.out.println("好心的麦乐迪为Blade捐赠了"+money+"元")) ;
    }
}
