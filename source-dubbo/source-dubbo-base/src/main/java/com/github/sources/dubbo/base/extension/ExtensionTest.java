package com.github.sources.dubbo.base.extension;

import com.alibaba.dubbo.common.extension.ExtensionLoader;

/**
 *
 **/
public class ExtensionTest {

    /**
     * 根据接口加载com.github.sources.dubbo.base.extension.MyInterface文件中的实现
     * 一个接口有多个实现，具体调用哪个实现的方法，由配置指定，所以需要一个适配类来指定具体是哪个实现类的方法
     * 写死的适配类在类上加上注解@Adaptive，如果是动态适配的就需要动态生成适配类
     * 动态生成适配类 {@See Protocol$Adpative}
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        ExtensionLoader extensionLoader = ExtensionLoader
                .getExtensionLoader(MyInterface.class);
        MyInterface myFirstExtension = (MyInterface) extensionLoader
                .getAdaptiveExtension();
        System.out.println(myFirstExtension.sayHello("xxx",
                ExtensionType.defaults));
    }
}
