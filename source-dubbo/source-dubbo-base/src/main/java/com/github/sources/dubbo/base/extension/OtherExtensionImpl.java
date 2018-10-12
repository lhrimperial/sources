package com.github.sources.dubbo.base.extension;

/**
 *
 **/
public class OtherExtensionImpl implements MyInterface {

    @Override
    public String sayHello(String name, String type) {
        return this.getClass().getName() + "  " + name + "  " + type;
    }
}
