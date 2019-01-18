package com.github.sources.proxy.asm.two;

import org.objectweb.asm.*;

/**
 *
 */
public class RemovingClassesVisitor extends ClassVisitor implements Opcodes {

    public RemovingClassesVisitor(ClassWriter cv) {
        super(ASM5, cv);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        String newName = name.substring(0, name.lastIndexOf("/")+1) + "TaskRemoved";
        cv.visit(version, access, newName, signature, superName, interfaces);
    }

    /**
     * 移除内部类
     * @param name
     * @param outerName
     * @param innerName
     * @param access
     */
    @Override
    public void visitInnerClass(String name, String outerName, String innerName, int access) {
        //cv.visitInnerClass(name, outerName, innerName, access);
//        不去实现方法体来达到移除目的
    }


    //移除属性或方法
//    Method和Field成员的移除需要终止下一层继续调用，也就是返回null 而不是MethodVisitor 或者FieldVisitor实例
    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        if (name.startsWith("is")) {
            return null;
        }
        return cv.visitField(access, name, desc, signature, value);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (name.startsWith("is")) {
            return null;
        }
        return cv.visitMethod(access, name, desc, signature, exceptions);
    }
}
