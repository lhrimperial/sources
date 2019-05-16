package com.github.sources.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author hairen.long
 * @date 2019-05-09
 */
public class MyServiceInterceptor implements MethodInterceptor {
    private RealService target;

    public MyServiceInterceptor(){

    }

    public MyServiceInterceptor(RealService target){
        this.target = target;
    }

    /**
     *
     * @param obj CGLib动态生成的代理类实例
     * @param method 代理类实例的方法引用
     * @param args 参数值列表
     * @param proxy 代理类对方法的代理引用
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before exexute");
        Object result = null;
        method.invoke(obj, args);
        result = proxy.invokeSuper(obj, args);
//        result = proxy.invoke(obj, args);
        System.out.println("after exexute");
        return result;
    }
}
