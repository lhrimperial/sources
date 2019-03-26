package com.github.sources.algorithm.sort;

import java.util.Arrays;

/**
 *
 **/
public class SortAlgorithm {

    public static void main(String[] args) {
        int[] arr = {12, 3, 45, 14, 25, 45, 89, 6, 1, 4, 7, 8, 9, 15, 74, 56, 42, 36};
//        selectSort(arr);
//        insertSort(arr);
//        shellSort(arr);
//        bulletSort(arr);
        quitSort(arr, 0, arr.length - 1);
    }



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
     * 冒泡排序
     * 在要排序的一组数中，对当前还未排好序的范围内的全部数，
     * 自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。
     * @param arr
     */
    public static void bulletSort(int[] arr) {
        for (int i = 0,len = arr.length; i < len; i++) {
            boolean isSwap = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 希尔排序
     * 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，
     * 待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int index, curr, dk = arr.length / 2;
        while (dk >= 1) {
            for (int i = dk, len = arr.length; i < len; i++) {
                curr = arr[i];
                for (index = i - dk; index >= 0 && curr < arr[index]; index -= dk) {
                    arr[index + dk] = arr[index];
                }
                arr[index + dk] = curr;
                System.out.println(Arrays.toString(arr));
            }
            dk = dk / 2;
        }
    }

    /**
     * 插入排序
     * 先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int index, curr;
        for (int i = 1,len = arr.length; i < len; i++) {
            curr = arr[i];
            for (index = i -1; index >= 0 && curr < arr[index]; index--) {
                arr[index + 1] = arr[index];
            }
            arr[index + 1] = curr;
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 选择排序 O(N2)
     * 从数组中选中小的数放在前面
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0,len = arr.length; i < len; i++) {
            int min = Integer.MAX_VALUE;
            int min_index = -1;
            for(int j = i; j < len; j++) {
                if (arr[j] <= min) {
                    min_index = j;
                    min = arr[j];
                }
            }
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }
}
