package com.github.sources.proxy.loader;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 *
 */
public class ClassLoaderTest {

    public static void main(String[] args){
        try {
            String classRoot = Program.class.getResource(".").getPath();
            System.out.println(classRoot);
            InputStream is = new FileInputStream(classRoot+"/Program.class");
            byte[] bs = new byte[is.available()];
            int len = is.read(bs);

            // 将字节码数组转化为内存中的类对象
            Class<Program> clazz = new MyClassLoader<Program>().defineMyClass(null, bs, 0, len);
            System.out.println("生成的class对象为：" + clazz.getCanonicalName());

            // 利用反射生成对象并调用对象的方法
            Object obj = clazz.newInstance();
            clazz.getMethod("sayHello", null).invoke(obj, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
