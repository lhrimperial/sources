package com.github.sources.algorithm;

import java.util.ArrayList;

/**
 * 矩阵
 *
 * @author hairen.long
 * @date 2019-06-21
 */
public class Matrix {

    public static void main(String[] args){
        int[][] arr = new int[5][5];
        int value = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = value++;
            }
        }
        printMatrix(arr);
        System.out.println(printMatrixClockwise(arr));
    }

    public static ArrayList<Integer> printMatrixClockwise(int[][] array) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (array.length == 0) {
            return result;
        }
        int n = array.length, m = array[0].length;
        if (m == 0) {
            return result;
        }
        // 这个是层数
        int layers = (Math.min(n, m) - 1) / 2 + 1;
        for (int i = 0; i < layers; i++) {
            // 左至右
            for (int k = i; k < m - i; k++) {
                result.add(array[i][k]);
            }
            // 右上至右下
            for (int j = i + 1; j < n - i; j++) {
                result.add(array[j][m - i - 1]);
            }
            // 右至左
            for (int k = m - i - 2; (k >= i) && (n - i - 1 != i); k--) {
                result.add(array[n - i - 1][k]);
            }
            // 左下至左上
            for (int j = n - i - 2; (j > i) && (m - i - 1 != i); j--) {
                result.add(array[j][i]);
            }
        }
        return result;
    }

    public static void printMatrix(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
