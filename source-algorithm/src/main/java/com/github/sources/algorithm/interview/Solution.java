package com.github.sources.algorithm.interview;

import java.util.Arrays;

/*
 * 阿里30分钟编程小测评
 * 题目：
现在很多家长都会送小孩子去培训中心学习舞蹈，
有一次舞蹈培训中心考试，因为小孩子要哄着才能更喜欢学，
所以老师给孩子们准备了小贴纸奖励孩子，
考试结束以后孩子们按照大小个站成一排，老师按照顺序给孩子们
发小贴纸，每个孩子都会至少得到一个小贴纸，因为是按照大小个
站成一排的，所以相邻的孩子成绩略有高低，为了鼓励相邻孩子
向成绩好的孩子学习，成绩高的孩子会比成绩弱的孩子得到的小贴纸多，
请问至少需要多少小贴纸发给孩子们？
Solution1:
测试例子：
成绩：2，4，5，2，3
贴纸：1，1，1，1，1
贴纸：1，2，3，1，2
Solution1:
成绩：5，4，2，3，2
贴纸：1，1，1，1，1
贴纸：2，2，1，2，1
Solution2:（一直迭代，直到收敛）
成绩：5，4，2，3，2
贴纸：1，1，1，1，1
贴纸：2，2，1，2，1
贴纸：3，2，1，2，1
*
 *
 */
public class Solution {

    public static int gift(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int num = 0;
        int len = ratings.length;
        int[] gift = new int[len];
        Arrays.fill(gift, 1);
        for (int i = 0; i < len; i++) {
            if (i != len - 1 && ratings[i] > ratings[i + 1] && gift[i] <= gift[i + 1]) {
                gift[i] = gift[i + 1] + 1;
            }
            if (i > 0 && ratings[i] > ratings[i - 1] && gift[i] <= gift[i - 1]) {
                gift[i] = gift[i - 1] + 1;
            }
        }
        for (int i = 0; i < len; i++) {
            num += gift[i];
        }
        System.out.println(Arrays.toString(gift));
        return num;
    }

    public static void main(String[] args){
        int[] ratings = {5, 4, 2, 3, 2};
        int num = gift(ratings);
        System.out.println(num);
    }
}
