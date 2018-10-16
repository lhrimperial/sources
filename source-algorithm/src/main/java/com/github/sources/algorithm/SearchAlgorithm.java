package com.github.sources.algorithm;

/**
 *
 */
public class SearchAlgorithm {

    public static void main(String[] args){
        int[] arr = {12, 3, 45, 14, 25, 45, 89, 6, 1, 4, 7, 8, 9, 15, 74, 56, 42, 36};
        // search 1 index
        System.out.println(orderSearch(arr, 1));
        System.out.println(binarySearch(arr,1));
    }

    public static int binarySearch(int[] arr, int target) {
        SortAlgorithm.quitSort(arr, 0, arr.length -1);
        int start = 0, end = arr.length -1, mid = (start+end)/2;
        while (end >= start) {
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return -1;
    }

    /**
     * 顺序查找适合于存储结构为顺序存储或链接存储的线性表
     * 线性查找是性能最差的查找算法，时间复杂度： O(N)
     * @param arr
     * @param target
     * @return
     */
    public static int orderSearch(int[] arr, int target) {
        for (int i = 0,len = arr.length; i < len; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
