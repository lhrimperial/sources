package com.github.sources.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hairen.long
 * @date 2019-05-09
 */
public class DynamicProxyHandler implements InvocationHandler {

  private ProxyInterface target;

  public DynamicProxyHandler(ProxyInterface target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Object result = null;
    System.out.println("++++++before " + method.getName() + "++++++");
    result = method.invoke(target, args);
    System.out.println("++++++after " + method.getName() + "++++++");
    return result;
  }

  public Object getProxy() {
    /*
     * Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
     */
    return Proxy.newProxyInstance(
        this.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
  }
}
