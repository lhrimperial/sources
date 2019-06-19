package com.github.sources.proxy.jdk.impl;

import com.github.sources.proxy.jdk.ProxyInterface;

/**
 * @author hairen.long
 * @date 2019-05-09
 */
public class ProxyInterfaceImpl implements ProxyInterface {

  @Override
  public void sayHello(String name) {
    System.out.println("hello " + name);
  }
}
