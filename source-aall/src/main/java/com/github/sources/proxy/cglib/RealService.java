package com.github.sources.proxy.cglib;

/**
 * @author hairen.long
 * @date 2019-05-09
 */
public class RealService {

    public void realMethod() {
        System.out.println("realMethod execute");
    }

    final public void testFinal() {
        System.out.println("test final");
    }

    private void testPrivate(){
        System.out.println("test private");
    }

    protected void testProtected(){
        System.out.println("test protected");
    }
}
