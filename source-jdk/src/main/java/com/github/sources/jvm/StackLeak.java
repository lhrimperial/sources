package com.github.sources.jvm;

/**
 * 栈中存储：基本数据类型，对象引用，方法等。
 * Exception in thread "main" java.lang.StackOverflowError
 */
public class StackLeak {

    public static void main(String[] args){
        method();
    }

    public static void method() {
        method();
    }
}
