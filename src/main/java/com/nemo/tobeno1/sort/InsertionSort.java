package com.nemo.tobeno1.sort;

import com.nemo.tobeno1.utils.Util;

import java.util.Arrays;

/**
 * 插入排序
 * 当数组近乎有序时，内层循环，可能只进行一步操作，插入排序的时间复杂度可以减低到n，而不再是n^2，具有一定的使用场景。
 *
 * @author hs
 * @version 1.0
 * @date 2019/1/29 17:32
 */
public class InsertionSort {
    /**
     * 插入排序方法
     *
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable> void insertionSortUtil(T[] arr) {
        int arrLength = arr.length;
        for (int i=1; i<arrLength; i++){
            for (int j=i; j>0; j--){
                if (-1 == arr[j].compareTo(arr[j-1])){
                    // 交换方法需要进行三步操作
                    Util.swap(arr, j, j-1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 改进插入排序
     *
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable> void insertionSortUpdate (T[] arr) {
        int arrLength = arr.length;
        for (int i=1; i<arrLength; i++) {
            T temp = arr[i];
            for (int j=i; j>0; j--){
                if (-1 == arr[j].compareTo(arr[j-1])){
                    // 不进行交换操作，只赋值，降低操作步骤
                    arr[j] = arr[j-1];
                } else {
                    break;
                }
            }
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        Integer[] arrInteger = {1,3,5,7,9,10,8,6,4,2};
        insertionSortUtil(arrInteger);
        System.out.println(Arrays.toString(arrInteger));
    }
}
