package com.github.sources.proxy.asm.one;

import org.objectweb.asm.ClassReader;

import java.io.IOException;

/**
 *
 */
public class ClassesPrintTest {
    public static void main(String[] args) {
        try {
            ClassReader cr = new ClassReader("com.github.sources.proxy.asm.Task");
            ClassPrintVisitor cp = new ClassPrintVisitor();
            cr.accept(cp, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
