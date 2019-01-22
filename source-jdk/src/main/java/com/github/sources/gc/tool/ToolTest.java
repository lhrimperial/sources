package com.github.sources.gc.tool;

import sun.tools.jps.Jps;
import sun.tools.jstack.JStack;

/**
 *
 */
public class ToolTest {

    public static void main(String[] args) throws Exception {
        testJstack();

    }

    public static void testJstack() throws Exception {
        JStack jStack = new JStack();
        String[] args = {"1464448"};
        jStack.main(args);
    }

    public static void testJps() {
        Jps jps = new Jps();
        String[] ars = {"-l"};
        jps.main(ars);
    }
}
