package com.github.sources.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 */
public class HelloProxyHandler implements InvocationHandler {
    private Object subject;

    public HelloProxyHandler(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before invoke " + method.getName());
        Object result = method.invoke(subject, args);
        System.out.println("After invoke " + method.getName());
        return result;
    }
}
