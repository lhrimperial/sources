package com.github.sources.proxy.perform;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtNewConstructor;
import javassist.CtNewMethod;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hairen.long
 * @date 2019-05-09
 */
public class BookApiDynamicProxy {

  public static void main(String[] args) throws Exception {

    BookApi delegate = new BookApiImpl();
    long time = System.currentTimeMillis();
    BookApi jdkProxy = createJdkDynamicProxy(delegate);
    time = System.currentTimeMillis() - time;
    System.out.println("Create JDK Proxy: " + time + " ms");

    time = System.currentTimeMillis();
    BookApi cglibProxy = createCglibDynamicProxy(delegate);
    time = System.currentTimeMillis() - time;
    System.out.println("Create CGLIB Proxy: " + time + " ms");

    time = System.currentTimeMillis();
    BookApi javassistBytecodeProxy = createJavassistBytecodeDynamicProxy();
    time = System.currentTimeMillis() - time;
    System.out.println("Create JavassistBytecode Proxy: " + time + " ms");

    for (int i = 0; i < 10; i++) {
      jdkProxy.sell(); // warm
    }
    long start = System.currentTimeMillis();
    for (int i = 0; i < 10000000; i++) {
      jdkProxy.sell();
    }
    System.out.println("JDK Proxy invoke cost " + (System.currentTimeMillis() - start) + " ms");

    for (int i = 0; i < 10; i++) {
      cglibProxy.sell(); // warm
    }
    start = System.currentTimeMillis();
    for (int i = 0; i < 10000000; i++) {
      cglibProxy.sell();
    }
    System.out.println("CGLIB Proxy invoke cost " + (System.currentTimeMillis() - start) + " ms");

    for (int i = 0; i < 10; i++) {
      javassistBytecodeProxy.sell(); // warm
    }
    start = System.currentTimeMillis();
    for (int i = 0; i < 10000000; i++) {
      javassistBytecodeProxy.sell();
    }
    System.out.println(
        "JavassistBytecode Proxy invoke cost " + (System.currentTimeMillis() - start) + " ms");

    Class<?> serviceClass = delegate.getClass();
    String methodName = "sell";
    for (int i = 0; i < 10; i++) {
      cglibProxy.sell(); // warm
    }
    // 执行反射调用
    for (int i = 0; i < 10; i++) { // warm
      Method method = serviceClass.getMethod(methodName, new Class[] {});
      method.invoke(delegate, new Object[] {});
    }
    start = System.currentTimeMillis();
    for (int i = 0; i < 10000000; i++) {
      Method method = serviceClass.getMethod(methodName, new Class[] {});
      method.invoke(delegate, new Object[] {});
    }
    System.out.println("反射 invoke cost " + (System.currentTimeMillis() - start) + " ms");

    // 使用 CGLib 执行反射调用
    for (int i = 0; i < 10; i++) { // warm
      FastClass serviceFastClass = FastClass.create(serviceClass);
      FastMethod serviceFastMethod = serviceFastClass.getMethod(methodName, new Class[] {});
      serviceFastMethod.invoke(delegate, new Object[] {});
    }
    start = System.currentTimeMillis();
    for (int i = 0; i < 10000000; i++) {
      FastClass serviceFastClass = FastClass.create(serviceClass);
      FastMethod serviceFastMethod = serviceFastClass.getMethod(methodName, new Class[] {});
      serviceFastMethod.invoke(delegate, new Object[] {});
    }
    System.out.println("CGLIB invoke cost " + (System.currentTimeMillis() - start) + " ms");
  }

  private static BookApi createJdkDynamicProxy(final BookApi delegate) {
    BookApi jdkProxy =
        (BookApi)
            Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(),
                new Class[] {BookApi.class},
                new JdkHandler(delegate));
    return jdkProxy;
  }

  private static class JdkHandler implements InvocationHandler {

    final Object delegate;

    JdkHandler(Object delegate) {
      this.delegate = delegate;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
      // 添加代理逻辑
      if (method.getName().equals("sell")) {
        System.out.print("");
      }
      return null;
      //            return method.invoke(delegate, objects);
    }
  }

  private static BookApi createCglibDynamicProxy(final BookApi delegate) throws Exception {
    Enhancer enhancer = new Enhancer();
    enhancer.setCallback(new CglibInterceptor(delegate));
    enhancer.setInterfaces(new Class[] {BookApi.class});
    BookApi cglibProxy = (BookApi) enhancer.create();
    return cglibProxy;
  }

  private static class CglibInterceptor implements MethodInterceptor {

    final Object delegate;

    CglibInterceptor(Object delegate) {
      this.delegate = delegate;
    }

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy)
        throws Throwable {
      // 添加代理逻辑
      if (method.getName().equals("sell")) {
        System.out.print("");
      }
      return null;
      //            return methodProxy.invoke(delegate, objects);
    }
  }

  private static BookApi createJavassistBytecodeDynamicProxy() throws Exception {
    ClassPool mPool = new ClassPool(true);
    CtClass mCtc = mPool.makeClass(BookApi.class.getName() + "JavaassistProxy");
    mCtc.addInterface(mPool.get(BookApi.class.getName()));
    mCtc.addConstructor(CtNewConstructor.defaultConstructor(mCtc));
    mCtc.addMethod(CtNewMethod.make("public void sell() { System.out.print(\"\") ; }", mCtc));
    Class<?> pc = mCtc.toClass();
    BookApi bytecodeProxy = (BookApi) pc.newInstance();
    return bytecodeProxy;
  }
}
