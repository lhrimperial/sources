package com.github.sources.proxy.asm.two;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

/**
 * 在visitEnd方法中去实际添加类成员（因为visitEnd方法总是会被调用到），在visitField方法中加入判断是否已经存在类成员，再继续往下执行。
 */
public class AddingClassVisitor extends ClassVisitor implements Opcodes {

    private int fAcc;
    private String fName;
    private String fDesc;
    private boolean isFieldPresent;

    public AddingClassVisitor(ClassVisitor cv, String fName, int fAcc, String fDesc) {
        super(ASM5, cv);
        this.fAcc = fAcc;
        this.fName = fName;
        this.fDesc = fDesc;
    }

    public AddingClassVisitor(ClassVisitor cv) {
        super(ASM5, cv);
    }


    @Override
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        if (name.equals(fName)) {
            isFieldPresent = true;
        }
        return cv.visitField(access, name, desc, signature, value);
    }

    @Override
    public void visitEnd() {
        if (!isFieldPresent) {
            FieldVisitor fv = cv.visitField(fAcc, fName, fDesc, null, null);
            if (fv != null) {
                fv.visitEnd();
            }
        }
        cv.visitEnd();
    }
}
