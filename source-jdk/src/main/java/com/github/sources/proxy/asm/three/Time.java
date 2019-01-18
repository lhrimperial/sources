package com.github.sources.proxy.asm.three;

/**
 *
 */
public class Time {
    public static long timer;

    public Time() {
    }

    public void myCount() throws Exception {
        timer -= System.currentTimeMillis();
        byte i = 5;
        byte j = 10;
        System.out.println(j - i);
        timer += System.currentTimeMillis();
    }

    public void myDeal() {
        timer -= System.currentTimeMillis();

        try {
            int[] e = new int[]{1, 2, 3, 4, 5};
            int f = e[10];
            System.out.println(f);
        } catch (ArrayIndexOutOfBoundsException var3) {
            var3.printStackTrace();
        }

        timer += System.currentTimeMillis();
    }

}
