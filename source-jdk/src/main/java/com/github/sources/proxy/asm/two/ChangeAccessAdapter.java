package com.github.sources.proxy.asm.two;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;

/**
 *
 */
public class ChangeAccessAdapter extends ClassVisitor {
    public ChangeAccessAdapter( ClassVisitor cv) {
        super(Opcodes.ASM5, cv);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        cv.visit(version, Opcodes.ACC_PUBLIC, name+"Temp", signature, superName, interfaces);
    }
}
