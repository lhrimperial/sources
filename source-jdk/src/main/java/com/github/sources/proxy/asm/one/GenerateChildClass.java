package com.github.sources.proxy.asm.one;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.FileOutputStream;

/**
 *
 */
public class GenerateChildClass implements Opcodes{

    public static void main(String[] args)throws Exception{
        String path = "source-jdk\\ext\\proxy\\";
        FileOutputStream fos = new FileOutputStream(path + "ChildClass.class");
        byte[] bytes = gen();
        fos.write(bytes);
        fos.flush();
        fos.close();
    }

    public static byte[] gen() {
        ClassWriter classWriter = new ClassWriter(0);
        classWriter.visit(Opcodes.V1_8,ACC_PUBLIC+ACC_ABSTRACT, "com.github.sources.proxy.asm.one.ChildClass",
                null,"java.lang.Object",new String[]{"com.github.sources.proxy.asm.one.ParentInter"});
        classWriter.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC, "zero", "I", null, new Integer(0)).visitEnd();
        classWriter.visitMethod(ACC_PUBLIC + ACC_ABSTRACT, "compareTo", "(Ljava.lang.Object;)I", null, null).visitEnd();
        classWriter.visitEnd();
        return classWriter.toByteArray();
    }
}
