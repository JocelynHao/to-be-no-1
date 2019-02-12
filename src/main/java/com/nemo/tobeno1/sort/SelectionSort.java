package com.nemo.tobeno1.sort;

import com.nemo.tobeno1.utils.Util;

import java.util.Arrays;

/**
 * 选择排序
 * @author hs
 * @version 1.0
 * @date 2019/1/29 15:20
 */
public class SelectionSort {
    /**
     * 选择排序
     * 使用泛型，比较泛型大小，要声明<T extends Comparable>，用compareTo比较，前提是只能是包装类
     * 故main方法中arr类型可用Integer[],而不能是int[]
     *
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable> void selectionSortUtil(T[] arr) {
        int arrLength = arr.length;
        for (int i=0; i<arrLength; i++){
            // 当前循环最小值的位置
            int minIndex = i;
            for (int j=i+1; j<arrLength; j++){
                if (-1 == arr[j].compareTo(arr[minIndex])) {
                    minIndex = j;
                }
            }
            // 交换i位置元素与当前最小值的位置
            Util.swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        Integer[] arrInteger = {1,3,5,7,9,10,8,6,4,2};
        selectionSortUtil(arrInteger);
        System.out.println(Arrays.toString(arrInteger));

        Double[] arrDouble = {2.2,4.4,1.1,3.3};
        selectionSortUtil(arrDouble);
        System.out.println(Arrays.toString(arrDouble));

        String[] arrString = {"A", "D", "C", "B"};
        selectionSortUtil(arrString);
        System.out.println(Arrays.toString(arrString));
    }
}
