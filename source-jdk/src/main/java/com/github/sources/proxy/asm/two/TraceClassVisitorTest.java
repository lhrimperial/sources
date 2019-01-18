package com.github.sources.proxy.asm.two;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.util.TraceClassVisitor;

import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 */
public class TraceClassVisitorTest {

    public static void main(String[] args) throws IOException {
        ClassReader cr = new ClassReader("com.github.sources.proxy.asm.Task");
        ClassWriter cw = new ClassWriter(0);
        TraceClassVisitor cv = new TraceClassVisitor(cw, new PrintWriter(System.out));
        cr.accept(cv, 0);
    }
}
