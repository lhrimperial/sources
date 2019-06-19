package com.github.sources.proxy.cglib;

/**
 *
 */
public class RealService {

    public void realMethod() {
        System.out.println("realMethod execute");
    }

    final public void testFinal() {
        System.out.println("test final");
    }
}
