package com.github.sources.proxy.asm.three;

import com.github.sources.proxy.loader.MyClassLoader;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;

/**
 *
 */
public class AOPTest {

    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {
        ClassReader classReader = new ClassReader("com.github.sources.proxy.asm.three.SuperClass");
        ClassWriter classWriter = new ClassWriter(0);
        ClassVisitor classVisitor = new SuperClassVisitor(classWriter);

        classReader.accept(classVisitor, 0);
        byte[] data = classWriter.toByteArray();
        Class clazz = new MyClassLoader<>().defineMyClass(null, data, 0, data.length);
        SuperClass superClass = (SuperClass) clazz.newInstance();
        superClass.sayHello();
    }
}
