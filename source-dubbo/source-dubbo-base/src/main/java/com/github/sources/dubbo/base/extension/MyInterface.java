package com.github.sources.dubbo.base.extension;

import com.alibaba.dubbo.common.extension.SPI;

/**
 *
 */
@SPI("defaults")
public interface MyInterface {

    String sayHello(String name, String type) ;
}
