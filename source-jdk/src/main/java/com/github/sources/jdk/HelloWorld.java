package com.github.sources.jdk;

/**
 *
 */
public class HelloWorld {
    public static void main(String[] args)throws Exception{
        Integer i = 1;//通过java/lang/Integer.valueOf:(I)包装
        String a = "abc";
        String b = "def";
        System.out.println(i);
        System.out.println(a+b); //通过java/lang/StringBuilder.append:(Ljava/lang/String;)拼接
        Thread.sleep(100000000);
    }
}
