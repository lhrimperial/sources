package com.github.sources.proxy.asm.one;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 *
 */
public class ClassPrintVisitor extends ClassVisitor implements Opcodes{

    public ClassPrintVisitor() {
        super(ASM5);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        System.out.println("class name:" + name + "super class name:" + superName);
    }

    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        if (name.startsWith("is")) {
            System.out.println("field name is : " + name + "\t" + desc);
        }
        return null;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (name.startsWith("is")) {
            System.out.println("start with is method: " + name + "\t" + desc);
        }
        return null;
    }

    @Override
    public void visitEnd() {
        System.out.println("}");
    }
}
