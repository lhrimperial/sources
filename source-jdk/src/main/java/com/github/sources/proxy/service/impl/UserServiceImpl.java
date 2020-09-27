package com.github.sources.proxy.service.impl;

import com.github.sources.proxy.service.IUserService;

/**
 *
 */
public class UserServiceImpl implements IUserService {

    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }

    @Override
    public void sayBye(String name) {
        System.out.println("Bye " + name);
    }
}
