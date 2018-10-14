package com.github.sources.loader;

/**
 *
 */
public class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init!");
    }

    static int a = 321;

    public SubClass(){
        System.out.println("init SubClass");
    }
}
