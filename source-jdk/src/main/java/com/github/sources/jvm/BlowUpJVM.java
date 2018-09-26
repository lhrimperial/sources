package com.github.sources.jvm;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 */
public class BlowUpJVM {

    /**
     * -Xms10m -Xmx10m -Xss108k -XX:PermSize=1m -XX:MaxPermSize=1m
     * @param args
     */
    public static void main(String[] args){
//        stackOverFlow();
//        permSizeOutOfMemory();
        permSizeOutOfMemory2();
    }

    public static void permSizeOutOfMemory2(){
        try {
            while (true) {
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOM.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                        return proxy.invokeSuper(obj, args);
                    }
                });
                enhancer.create();
                System.out.println("CGLIB Create Class");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 打算把String常量池堆满，没想到失败了，JDK1.7后常量池放到了堆里，也能进行垃圾回收了。
     * 然后换种方式，使用cglib，用Class把老年代取堆满
     */
    public static void permSizeOutOfMemory() {
        List<String> list = new ArrayList<>();
        while (true) {
            list.add(UUID.randomUUID().toString().intern());
        }
    }

    /**
     * 栈不断递归，而且没有处理，所以虚拟机栈就不断深入不断深入，栈深度就这样溢出了。
     * -Xss108k，设置栈大小，最小设置108k
     */
    public static void stackOverFlow() {
        BlowUpJVM.stackOverFlow();
    }


    public static class OOM{

    }

}
