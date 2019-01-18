package com.github.sources.proxy.asm.three;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.io.File;
import java.io.FileOutputStream;

/**
 *
 */
public class GenerateClasses {

    public static void main(String[] args)throws Exception{
        ClassWriter cw = new ClassWriter(0);
        cw.visit(Opcodes.V1_7, Opcodes.ACC_PUBLIC, "com/github/sources/proxy/asm/MethodGenClass", null, "java/lang/Object", null);
        cw.visitField(Opcodes.ACC_PRIVATE, "espresso", "I", null, null).visitEnd();
        MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "addEspresso", "(I)V", null, null);
        // 方法访问开始
        mv.visitCode();
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        // label 代表跳转的字节码位置。
        Label label = new Label();
        mv.visitJumpInsn(Opcodes.IFLT, label);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitFieldInsn(Opcodes.PUTFIELD, "com/github/sources/proxy/asm/MethodGenClass", "espresso", "I");
        Label end = new Label();
        mv.visitJumpInsn(Opcodes.GOTO, end);
        mv.visitLabel(label);
        mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
        // 创建Exception对象指令
        mv.visitTypeInsn(Opcodes.NEW, "java/lang/IllegalArgumentException");
        mv.visitInsn(Opcodes.DUP);
        // 调用方法指令
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/IllegalArgumentException", "<init>", "()V", false);
        mv.visitInsn(Opcodes.ATHROW);
        mv.visitLabel(end);
        mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(2, 2);
        // 方法访问结束
        mv.visitEnd();
        cw.visitEnd();

        byte[] b = cw.toByteArray();

        File file = new File("source-jdk\\ext\\proxy\\MethodGenClass.class");
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(b);
        fout.close();

    }
}
