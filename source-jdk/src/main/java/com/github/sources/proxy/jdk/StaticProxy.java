package com.github.sources.proxy.jdk;

import com.github.sources.proxy.service.IUserService;

/**
 *
 */
public class StaticProxy implements IUserService{

    private IUserService target;

    public StaticProxy(IUserService target) {
        this.target = target;
    }

    @Override
    public void sayHello(String name) {
        System.out.println("StaticProxy before sayHello......");
        target.sayHello(name);
    }

    @Override
    public void sayBye(String name) {
        System.out.println("StaticProxy before sayBye......");
        target.sayBye(name);
    }
}
