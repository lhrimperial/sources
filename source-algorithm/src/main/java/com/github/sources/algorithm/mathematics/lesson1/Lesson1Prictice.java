package com.github.sources.algorithm.mathematics.lesson1;

/**
 * @author hairen.long
 * @date 2019-03-26
 */
public class Lesson1Prictice {

    /**
     * @Title: decimalToBinary @Description: 十进制转二进制，方法1：余数短除法除以二
     *
     * @param decimalSource
     * @return: String
     */
    /*public static String decimalToBinary(int decimalSource) {
    StringBuilder sb = new StringBuilder();
    while (decimalSource != 0) {
    sb.append(decimalSource % 2);
    decimalSource = decimalSource >> 1;
    }
    return sb.reverse().toString();
    }*/

    /**
     * @Title: decimalToBinary @Description: 十进制转二进制，方法2：降二次幂及减法混合运算
     *
     * @param decimalSource
     * @return: String
     */
    /*public static String decimalToBinary(int decimalSource) {
    int length = (int) (Math.log(decimalSource) / Math.log(2));
    StringBuffer sb = new StringBuffer();
    do {
    decimalSource = (int) (decimalSource - Math.pow(2, length));
    int power = decimalSource <= 0 ? -1 : (int) (Math.log(decimalSource) / Math.log(2));
    for (int i = length; i > power; i--) {
    if (i == length) {
    sb.append("1");
    } else {
    sb.append("0");
    }
    }
    length = power;
    } while (decimalSource > 0);
    return sb.toString();
    }*/
    /**
     * @Title: decimalToBinary @Description: 十进制转二进制，方法3：位运算法
     *
     * @param decimalSource
     * @return
     * @return: String
     */
    public static String decimalToBinary(int decimalSource) {
        StringBuffer sb = new StringBuffer();
        while (decimalSource != 0) {
            // 此&运算，decimalSource & 1，目的是获取最低位的二进制数值
            sb.append(decimalSource & 1);
            // 此>>运算，decimalSource >> 1，目的是将获取到的最低位二进制数值除去
            decimalSource = decimalSource >> 1;
        }
        return sb.reverse().toString();
    }
    //    负整数转换为二进制 要点：
    //    取反加一 解释：将该负整数对应的正整数先转换成二进制，然后对其“取补”，再对取补后的结果加1即可。
    //    例如要把-52换算成二进制：
    //            1.先取得52的二进制：00110100
    //            2.对所得到的二进制数取反：11001011
    //            3.将取反后的数值加一即可：11001100 即：(-52)10=(11001100)2
}
