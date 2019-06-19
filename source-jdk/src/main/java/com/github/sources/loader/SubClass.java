package com.github.sources.loader;

/**
 *
 */
public class SubClass extends SuperClass {

    static {
        System.out.println("SubClass static block");
    }

    static int a = 321;

    public SubClass(){
        System.out.println("init SubClass");
    }
}
