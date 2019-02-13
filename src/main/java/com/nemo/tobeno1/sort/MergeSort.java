package com.nemo.tobeno1.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 归并排序
 * 时间复杂度为nlog(n),但需要多占据O(n)的空间，从效率角度讲，时间优于空间
 * 分组-排序-归并
 *
 * @author hs
 * @version 1.0
 * @date 2019/2/12 10:02
 */
public class MergeSort {
    public static <T extends Comparable> void MergeSortUtil(T[] arr) {
        int n = arr.length;
        MergeSortUtil(arr, 0, n-1);
    }

    /**
     * 递归使用归并排序，对arr[left,right]闭区间的范围进行排序
     *
     * @param arr
     * @param left
     * @param right
     * @param <T>
     */
    private static <T extends Comparable> void MergeSortUtil(T[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right)/2;
        MergeSortUtil(arr, left, mid);
        MergeSortUtil(arr, mid+1, right);
        Merge(arr, left, mid, right);
    }

    /**
     * 将arr[left,mid]和arr[mid+1, right]这两个部分分别进行归并
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param <T>
     */
    private static <T extends Comparable> void Merge(T[] arr, int left, int mid, int right) {
        Class<T> type = (Class<T>) arr.getClass().getComponentType();
        T[] temps = (T[]) Array.newInstance(type, right-left+1);
        for (int i=left; i<=right; i++){
            temps[i-left] = arr[i];
        }
        int i = left;
        int j = mid+1;
        for (int k=left; k<=right; k++) {
            // 先判断索引的合法性
            if (i > mid) {
                arr[k] = temps[j-left];
                j++;
            } else if (j > right) {
                arr[k] = temps[i-left];
                i++;
            } else if (-1 == temps[i-left].compareTo(temps[j-left])) {
                arr[k] = temps[i-left];
                i++;
            } else {
                arr[k] = temps[j-left];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arrInteger = {1,3,5,7,9,10,8,6,4,2};
        MergeSortUtil(arrInteger);
        System.out.println(Arrays.toString(arrInteger));
    }
}
