package com.github.sources.jvm;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.jar.Manifest;

/**
 * 方法区存放每个Class的结构，比如说运行时常量池、域、方法数据、方法体、构造函数、包括类中的专用方法、实例初始化、接口初始化。
 * Java的反射和动态代理可以动态产生Class，另外第三方的CGLIB可以直接操作字节码，也可以动态产生Class
 */
public class MethodAreaLeak {

    public static void main(String[] args){
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invoke(o, objects);
                }
            });
        }
    }

    public static class OOMObject{

    }
}
