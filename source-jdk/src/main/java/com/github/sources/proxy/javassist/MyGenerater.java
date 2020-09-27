package com.github.sources.proxy.javassist;

import javassist.*;

import java.io.File;
import java.lang.reflect.Method;

/**
 * Javassist是一个开源的分析、编辑和创建Java字节码的类库。它已加入了开放源代码JBoss 应用服务器项目,
 * 通过使用Javassist对字节码操作为JBoss实现动态AOP框架。javassist是jboss的一个子项目，
 * 其主要的优点，在于简单，而且快速。直接使用java编码的形式，而不需要了解虚拟机指令，就能动态改变类的结构，或者动态生成类。
 */
public class MyGenerater {

    public static void main(String[] args){

        try {
            ClassPool classPool = ClassPool.getDefault();
            //创建类
            CtClass helloClass = classPool.makeClass("com.github.sources.proxy.javassist.JavassistHelloWorld");
            //定义方法
            CtMethod sayHelloMethod = CtNewMethod.make("public void sayHello(){}", helloClass);
            // 插入方法代码
            sayHelloMethod.insertBefore("System.out.print(\"Hello World， Javassist\");");
            helloClass.addMethod(sayHelloMethod);

            //添加构造函数
//            CtConstructor ctConstructor = new CtConstructor(new CtClass[]{}, helloClass);
//            helloClass.addConstructor(ctConstructor);

            Object obj = helloClass.toClass().newInstance();
            Method sayHello = obj.getClass().getMethod("sayHello");
            sayHello.invoke(obj);


            //保存生成的字节码
            File dir = new File(System.getProperty("user.dir")+"/source-jdk/ext");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            helloClass.writeFile(dir.getCanonicalPath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
