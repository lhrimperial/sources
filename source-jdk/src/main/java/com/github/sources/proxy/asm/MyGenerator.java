package com.github.sources.proxy.asm;

import com.github.sources.proxy.loader.MyClassLoader;
import com.github.sources.proxy.loader.Program;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ASM 是一个 Java 字节码操控框架。它能够以二进制形式修改已有类或者动态生成类。ASM 可以直接产生二进制 class 文件，
 * 也可以在类被加载入 Java 虚拟机之前动态改变类行为。ASM 从类文件中读入信息后，能够改变类行为，分析类信息，甚至能够根据用户要求生成新类。
 * 不过ASM在创建class字节码的过程中，操纵的级别是底层JVM的汇编指令级别，这要求ASM使用者要对class组织结构和JVM汇编指令有一定的了解。
 */
public class MyGenerator {

    public static void main(String[] args) throws IOException {
        try {
            ClassWriter classWriter = new ClassWriter(0);
            // 通过visit方法确定类的头部信息
            classWriter.visit(Opcodes.V1_7, // java版本
                    Opcodes.ACC_PUBLIC,     // 类修饰符
                    "AsmHelloWorld",           // 类的全限定名
                    null, "java/lang/Object", null);

            //创建构造函数
            MethodVisitor mv = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            mv.visitVarInsn(Opcodes.ALOAD, 0);
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>","()V");
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(1, 1);
            mv.visitEnd();

            // 定义code方法
            MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "sayHello", "()V",
                    null, null);
            methodVisitor.visitCode();
            methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out",
                    "Ljava/io/PrintStream;");
            methodVisitor.visitLdcInsn("I'm a Programmer,Just Coding.....");
            methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println",
                    "(Ljava/lang/String;)V");
            methodVisitor.visitInsn(Opcodes.RETURN);
            methodVisitor.visitMaxs(2, 2);
            methodVisitor.visitEnd();
            classWriter.visitEnd();

            // 使classWriter类已经完成
            // 将classWriter转换成字节数组写到文件里面去
            byte[] data = classWriter.toByteArray();

            Class<?> exampleClass = new MyClassLoader().defineMyClass("AsmHelloWorld", data, 0, data.length);

            //通过反射调用main方法
            Object obj = exampleClass.newInstance();
            java.lang.reflect.Method method = obj.getClass().getMethod("sayHello");
            method.invoke(obj, null);

            //
            File dir = new File(System.getProperty("user.dir")+"/source-jdk/ext");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, "AsmHelloWorld.class");
            //
            FileOutputStream fout = new FileOutputStream(file);
            fout.write(data);
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
