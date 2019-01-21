package com.github.sources.proxy.javassist;

import java.lang.reflect.Modifier;

/**
 *
 */
public class TestJavassist {

    public static void main(String[] args) throws Exception {
        Person person = new Person("小明");
        Object proxy = new JavassistProxyFactory(person).getProxy();
        // System.gc(); // 主动触发gc
        Object proxy1 = new JavassistProxyFactory(person).getProxy();
        ((Talkable) proxy).talk("hello world");
        ((Smileable) proxy).smile();

        System.out.println("package: " + proxy.getClass().getPackage().getName());
        System.out.println("classname: " + proxy.getClass().getName());
        System.out.println("modifiers: " + Modifier.toString(proxy.getClass().getModifiers()));
        System.out.println(proxy.getClass() == proxy1.getClass()); // 测试缓存是否起作用
    }
}
