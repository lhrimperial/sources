package com.github.sources.proxy.asm.two;


import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 */
public class RemovingClassTest {

    public static void main(String[] args) throws IOException {
        ClassReader classReader = new ClassReader("com.github.sources.proxy.asm.Task");
        ClassWriter classWriter = new ClassWriter(0);
        ClassVisitor classVisitor = new RemovingClassesVisitor(classWriter);
        classReader.accept(classVisitor, 0);
        byte[] bytes = classWriter.toByteArray();
        FileOutputStream fos = new FileOutputStream("source-jdk\\ext\\proxy\\ChangeTask.class");
        fos.write(bytes);
        fos.flush();
    }
}
