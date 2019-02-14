package com.nemo.tobeno1.sort;

import com.nemo.tobeno1.utils.Util;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author hs
 * @version 1.0
 * @date 2019/2/14 10:34
 */
public class QuickSort {
    /**
     * 对arr[0, n-1]进行快排
     *
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable> void QuickSortUtil(T[] arr) {
        int n = arr.length;
        QuickSortUtil(arr, 0, n-1);
    }

    private static <T extends Comparable> void QuickSortUtil(T[] arr, int left, int right) {
        // 递归结束标识
        if (left >= right) {
            return;
        }
        int p = Partition(arr, left, right);
        QuickSortUtil(arr, left, p-1);
        QuickSortUtil(arr, p+1, right);
    }

    /**
     * 对arr[left, right]部分进行partition操作
     * 使得arr[left, p-1]<arr[p], arr[p+1, right]>arr[p]，返回索引位置p
     *
     * @param arr
     * @param left
     * @param right
     * @param <T>
     * @return p
     */
    private static <T extends Comparable> int Partition(T[] arr, int left, int right) {
        T temp = arr[left];
        // arr[left, p-1]<temp && arr[p+1, right]>temp
        int p = left;
        for (int i=left+1; i<=right; i++) {
            if (-1 == arr[i].compareTo(temp)) {
                Util.Swap(arr, p+1, i);
                p++;
            }
        }
        Util.Swap(arr, left, p);
        return p;
    }

    public static void main(String[] args) {
        Integer[] arrInteger = {1,3,5,7,9,10,8,6,4,2};
        QuickSortUtil(arrInteger);
        System.out.println(Arrays.toString(arrInteger));
    }
}
