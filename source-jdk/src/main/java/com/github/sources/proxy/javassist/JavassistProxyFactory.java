package com.github.sources.proxy.javassist;

import java.lang.reflect.Method;

/**
 *
 */
public class JavassistProxyFactory implements InvocationHandler{

    //被代理类的对象
    private Object target;

    public JavassistProxyFactory(Object target) {
        this.target = target;
    }

    /*
     * @see cc.lixiaohui.demo.javassist.proxy.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("------- intercept before --------");
        // 调用原来的方法
        Object result = method.invoke(target, args);
        System.out.println("--------intercept after ---------");
        return result;
    }
    // 获取代理类的对象
    public Object getProxy() throws Exception {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass(), this);
    }

}
