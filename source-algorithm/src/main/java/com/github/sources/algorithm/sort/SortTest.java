package com.github.sources.algorithm.sort;

import java.util.Arrays;

public class SortTest {

    public static void main(String[] args){
        int[] arr = {12, 3, 45, 14, 25, 45, 89, 6, 1, 4, 7, 8, 9, 15, 74, 56, 42, 36};
//        insertSort(arr);
//        buttleSort(arr);
        quitSort(arr, 0, arr.length - 1);
    }

    /**
     * 以第一个作为中间点，把大于和小于这个点的数分开，递归往下分
     * @param arr
     * @param start
     * @param end
     */
    public static void quitSort(int[] arr, int start, int end) {
        int low = start;
        int high = end;
        if (low >= high) {
            return;
        }
        int mid = arr[start];
        while (low < high) {
            while (arr[high] >= mid && low < high) {
                high--;
            }
            arr[low] = arr[high];
            while (arr[low] <= mid && low < high) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = mid;
        System.out.println(Arrays.toString(arr));
        quitSort(arr, start, low - 1);
        quitSort(arr, low + 1, end);
    }

    /**
     * 自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。
     * @param arr
     */
    public static void buttleSort(int[] arr) {
        for (int i = 0, len = arr.length; i < len; i++) {
            boolean isSwap = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwap = true;
                }
                if (!isSwap) {
                    continue;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int index, curr;
        for (int i = 1, len = arr.length; i < len; i++) {
            curr = arr[i];
            for (index = i - 1; index >= 0 && curr < arr[index]; index--) {
                arr[index + 1] = arr[index];
            }
            arr[index + 1] = curr;
        }
        System.out.println(Arrays.toString(arr));
    }
}
