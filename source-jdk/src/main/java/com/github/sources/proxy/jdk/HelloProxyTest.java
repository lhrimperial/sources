package com.github.sources.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 *
 */
public class HelloProxyTest {

    public static void main(String[] args){
        HelloProxyHandler helloProxyHandler = new HelloProxyHandler(new HelloInterfaceImpl());
        HelloInterface proxy = (HelloInterface) Proxy.newProxyInstance(HelloProxyTest.class.getClassLoader(), HelloInterfaceImpl.class.getInterfaces(), helloProxyHandler);
        Class clazz = null;
        proxy.sayHello();
    }
}
