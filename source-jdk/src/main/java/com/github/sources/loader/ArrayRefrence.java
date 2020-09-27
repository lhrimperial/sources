package com.github.sources.loader;

/**
 *
 */
public class ArrayRefrence {

    public static void main(String[] args){
        /**
         * 通过数组定义来引用类， 不会触发此类的初始化
         */
        SuperClass[] superClasses = new SuperClass[10];
    }
}
