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
    /**
     * 1.自顶向下的归并排序--递归实现
     * 思路：自顶向下，递归划分，至只有两个元素后，层层排序，并向上层归并，最终归并的顶层
     *
     * @param arr
     * @param <T>
     */
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
        /**
         * 算法改进，在此处对arr[mid]和arr[mid+1]两个元素大小进行比较
         * 若arr[mid]<=arr[mid+1]，则说明此时整个数组为有序，不需归并
         * 否则，此时进行归并排序
         */
        if (-1 != arr[mid].compareTo(arr[mid+1])) {
            Merge(arr, left, mid, right);
        }
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

    /**
     * 2.自底向上的归并排序--只需迭代，不需递归
     * 思路：直接划分为最小单元进行归并，再逐层向上重新增加单元大小，再归并，至最顶层，可直接使用数组索引，？链表可用？
     *
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable> void MergeSortUtilBottomToUp(T[] arr) {
        int n = arr.length;
        for (int size=1; size<n; size+=size) {
            for (int i=0; i+size<n; i+=size+size) {
                // 对arr[i,i+size-1]和arr[i+size, i+size+size-1]两部分进行归并
                // 判断i+size+size是否超过边界n
                int right = ((i+size+size) > n) ? (n-1) : (i+size+size-1);
                Merge(arr, i, i+size-1, right);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arrInteger = {1,3,5,7,9,10,8,6,4,2};
        MergeSortUtilBottomToUp(arrInteger);
        System.out.println(Arrays.toString(arrInteger));
    }
}
