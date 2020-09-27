package com.github.sources.proxy.cglib;

import com.github.sources.proxy.service.IUserService;
import com.github.sources.proxy.service.impl.UserServiceImpl;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 *
 */
public class CglibTest {

    public static void main(String[] args){
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\idea_works\\study\\sources\\source-jdk\\ext\\proxy\\cglib");
        CglibMethodInterceptor cglibProxy = new CglibMethodInterceptor();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(cglibProxy);

        IUserService service = (IUserService)enhancer.create();
        service.sayHello("andy");
        service.sayBye("andy");

    }
}
