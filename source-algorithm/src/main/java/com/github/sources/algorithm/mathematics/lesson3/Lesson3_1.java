package com.github.sources.algorithm.mathematics.lesson3;

/**
 * @author hairen.long
 * @date 2019-03-27
 */
public class Lesson3_1 {
    /**
     * @Description: 算算舍罕王给了多少粒麦子
     *
     * @param grid- 放到第几格
     * @return long- 麦粒的总数
     */
    public static long getNumberOfWheat(int grid) {

        // 麦粒总数
        long sum = 0;
        // 当前格子里麦粒的数量
        long numberOfWheatInGrid = 0;
        // 第一个格子里麦粒的数量
        numberOfWheatInGrid = 1;
        sum += numberOfWheatInGrid;

        for (int i = 2; i <= grid; i++) {
            // 当前格子里麦粒的数量是前一格的 2 倍
            numberOfWheatInGrid *= 2;
            // 累计麦粒总数
            sum += numberOfWheatInGrid;
        }

        return sum;
    }

    public static void main(String[] args){
        System.out.println(getNumberOfWheat(63));
    }
}
