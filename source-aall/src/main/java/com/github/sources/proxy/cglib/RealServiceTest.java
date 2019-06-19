package com.github.sources.proxy.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author hairen.long
 * @date 2019-05-09
 */
public class RealServiceTest {

    public static void main(String[] args){
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "ext/cglib/");
        Enhancer enhancer = new Enhancer();
        //设置超类，因为cglib基于父类 生成代理子类
        enhancer.setSuperclass(RealService.class);
        //设置回调，也就是我们的拦截处理
//        enhancer.setCallback(new MyServiceInterceptor(new RealService()));
        enhancer.setCallback(new MyServiceInterceptor());

        //创建代理类
        RealService realService = (RealService) enhancer.create();
        //代用代理类的方法
        realService.realMethod();
        realService.testFinal();
        realService.testProtected();

    }
}
