package com.github.sources.proxy.asm.two;


import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 */
public class AddingClassTest {

    public static void main(String[] args) throws IOException {
        ClassReader classReader = new ClassReader("com.github.sources.proxy.asm.Task");
        ClassWriter classWriter = new ClassWriter(0);
        ClassVisitor classVisitor = new AddingClassVisitor(classWriter,"addedField", Opcodes.ACC_PRIVATE, "I");
        classReader.accept(classVisitor, 0);
        FileOutputStream fos = new FileOutputStream("source-jdk\\ext\\proxy\\TaskAdded.class");
        fos.write(classWriter.toByteArray());
        fos.flush();
        fos.close();
    }
}
