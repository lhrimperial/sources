package com.github.sources.algorithm.mathematics.lesson1;

/**
 * @author hairen.long
 * @date 2019-03-26
 */
public class Lesson1_2 {

    /**
     * @Description: 向左移位
     *
     * @param num- 等待移位的十进制数, m- 向左移的位数
     * @return int- 移位后的十进制数
     */
    public static int leftShift(int num, int m) {
        return num << m;
    }

    /**
     * @Description: 向右移位
     *
     * @param num- 等待移位的十进制数, m- 向右移的位数
     * @return int- 移位后的十进制数
     */
    public static int rightShift(int num, int m) {
        return num >>> m;
    }

    public static void main(String[] args) {

        int num = 53;
        int m = 1;
        System.out.println(
                String.format(
                        " 数字 %d 的二进制向左移 %d 位是 %d", num, m, Lesson1_2.leftShift(num, m))); // 测试向左移位
        System.out.println(
                String.format(
                        " 数字 %d 的二进制向右移 %d 位是 %d",
                        num, m, Lesson1_2.rightShift(num, m))); // 测试向右移位

        System.out.println();

        m = 3;
        System.out.println(
                String.format(
                        " 数字 %d 的二进制向左移 %d 位是 %d", num, m, Lesson1_2.leftShift(num, m))); // 测试向左移位
        System.out.println(
                String.format(
                        " 数字 %d 的二进制向右移 %d 位是 %d", num, m, Lesson1_2.rightShift(num, m))); // 测试向右移位
    }
}
