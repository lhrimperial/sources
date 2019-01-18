package com.github.sources.proxy.asm.two;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.*;

/**
 *
 */
public class TransformClasses {
    public static void main(String[] args) throws IOException {
        File file = new File("source-jdk\\ext\\proxy\\ChildClass.class");
        InputStream input = new FileInputStream(file);
        // 构造一个byte数组
        byte[] byt = new byte[input.available()];
        input.read(byt);
        ClassWriter cw = new ClassWriter(0);
//        ClassVisitor cv = new ClassVisitor (Opcodes.ASM5,cw){};
        //  改变class的访问修饰
        ClassVisitor cv = new ChangeAccessAdapter(cw);
        ClassReader cr = new ClassReader(byt);
        cr.accept(cv, 0);
        byte[] toByte = cw.toByteArray();// byt 和toByte其实是相同的数组
        // 输出到class文件
        File tofile = new File("source-jdk\\ext\\proxy\\ChildClassTemp.class");
        FileOutputStream fout = new FileOutputStream(tofile);
        fout.write(toByte);
        fout.close();

    }

}
