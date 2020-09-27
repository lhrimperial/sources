package com.github.sources.jdk8.lambda;

public class LambdaDemo {

    public static void main(String[] args){
        test();
    }

    public static void test(){
        new Thread(() -> System.out.println("do something.")).start();
    }
}
