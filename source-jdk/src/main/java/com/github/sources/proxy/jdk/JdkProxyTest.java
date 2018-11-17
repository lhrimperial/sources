package com.github.sources.proxy.jdk;

import com.github.sources.proxy.service.IUserService;
import com.github.sources.proxy.service.impl.UserServiceImpl;

/**
 *
 */
public class JdkProxyTest {

    public static void main(String[] args){
//        testStaticProxy();
        testDynamicProxy();
//        generateProxyClass();
    }

    public static void generateProxyClass() {
        String path = "D:\\idea_works\\study\\sources\\source-jdk\\ext\\$Proxy11.class";
        ProxyGeneratorUtils.writeProxyClassToHardDisk(path);
    }

    public static void testDynamicProxy() {
        DynamicProxyHandler handler = new DynamicProxyHandler(new UserServiceImpl());
        IUserService userService = (IUserService) handler.getProxy();
        userService.sayHello("jeck");
        userService.sayBye("jeck");

    }

    public static void testStaticProxy() {
        IUserService userService = new UserServiceImpl();
        StaticProxy proxy = new StaticProxy(userService);
        proxy.sayHello("andy");
        proxy.sayBye("andy");

    }
}
