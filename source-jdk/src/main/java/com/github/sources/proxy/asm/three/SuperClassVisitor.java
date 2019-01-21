package com.github.sources.proxy.asm.three;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 *
 */
public class SuperClassVisitor extends ClassVisitor {

    public SuperClassVisitor(ClassWriter classWriter) {
        super(Opcodes.ASM5, classWriter);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        String enhancedName = name + "$EnhancedByASM";  // 改变类命名
        superName = name; // 改变父类，这里是”Account”
        super.visit(version, access, enhancedName, signature, superName, interfaces);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (!name.equals("<init>")) {
            System.out.println("AOP visit.............");
        }
        return cv.visitMethod(access, name, desc, signature, exceptions);
    }
}
