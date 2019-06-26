package com.github.sources.algorithm;

import java.util.Arrays;

/**
 * @author hairen.long
 * @date 2019-06-21
 */
public class SortAlgorithm {

    public static void main(String[] args) {
        int[] arr = {8, 2, 1, 3, 9, 0, 7, 5, 6, 4};
        //        System.out.println("选择排序：");
        //        selectSort(arr);
        //        System.out.println("插入排序：");
        //        insertSort(arr);
        //        System.out.println("冒泡排序：");
        //        bulletSort(arr);
        System.out.println("快速排序：");
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

    public static void bulletSort(int[] arr) {
        for (int i = 0, len = arr.length; i < len; i++) {
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
     * 插入排序，先把第一个看做是有序的，后面的依次放入合适的位置 希尔排序就是插入排序的变种
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int curr, index;
        for (int i = 1, len = arr.length; i < len; i++) {
            curr = arr[i];
            for (index = i - 1; index >= 0 && curr < arr[index]; index--) {
                arr[index + 1] = arr[index];
            }
            arr[index + 1] = curr;
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * 选择排序，从数组中选择最小的排在前面
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0, len = arr.length; i < len; i++) {
            int min = Integer.MAX_VALUE;
            int min_index = -1;
            for (int j = i; j < len; j++) {
                if (arr[j] <= min) {
                    min = arr[j];
                    min_index = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }
}
