package com.github.sources.proxy.jdk;

import com.github.sources.proxy.jdk.impl.ProxyInterfaceImpl;

/**
 * @author hairen.long
 * @date 2019-05-09
 */
public class JdkProxyTest {

    public static void main(String[] args){
        generateProxyClass();
        dynamicProxyTest();
    }

    public static void generateProxyClass() {
        String path = "ext/jdk/$Proxy11.class";
        ProxyGeneratorUtils.writeProxyClassToHardDisk(path);
    }

    public static void dynamicProxyTest() {
        DynamicProxyHandler handler = new DynamicProxyHandler(new ProxyInterfaceImpl());
        ProxyInterface userService = (ProxyInterface) handler.getProxy();
        userService.sayHello("jeck");

    }
}
