package com.github.sources.proxy.jdk;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 *
 */
public class HelloProxyTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //生成$Proxy0的class文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        /**
         * 第一种
         */
        //获取动态代理类
        Class proxyClass = Proxy.getProxyClass(HelloInterface.class.getClassLoader(), HelloInterface.class);
        //获取代理类的构造函数，并传入参数类型InvocationHandler.class
        Constructor constructor = proxyClass.getConstructor(InvocationHandler.class);
        //通过构造方法创建动态代理对象，传入自定义InvocationHandler实例
        HelloInterface helloProxy = (HelloInterface) constructor.newInstance(new HelloProxyHandler(new HelloInterfaceImpl()));
        //通过代理对象调用目标方法
        helloProxy.sayHello();

        /**
         * 第二种
         */
        HelloProxyHandler helloProxyHandler = new HelloProxyHandler(new HelloInterfaceImpl());
        HelloInterface proxy = (HelloInterface) Proxy.newProxyInstance(HelloProxyTest.class.getClassLoader(), HelloInterfaceImpl.class.getInterfaces(), helloProxyHandler);
        proxy.sayHello();
    }
}
