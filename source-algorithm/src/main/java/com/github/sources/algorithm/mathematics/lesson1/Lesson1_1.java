package com.github.sources.algorithm.mathematics.lesson1;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author hairen.long
 * @date 2019-03-26
 */
public class Lesson1_1 {

    /**
     * 十进制转二进制
     * @param decimalSource
     * @return
     */
    public static String decimalToBinary(int decimalSource) {
        BigInteger decimal = new BigInteger(String.valueOf(decimalSource));
        //参数2 指定转化成二进制
        return decimal.toString(2);
    }

    /**
     * 二进制转化成十进制
     * @param binarySource
     * @return
     */
    public static int binaryToDecimal(String binarySource) {
        //转化成BigInteger 参数2 指定转化成二进制
        BigInteger binary = new BigInteger(binarySource, 2);
        return Integer.parseInt(binary.toString());
    }


    public static void main(String[] args){
        int a = 53;
        String b = "110101";
        System.out.println(decimalToBinary(a));
        System.out.println(binaryToDecimal(b));
    }
}
