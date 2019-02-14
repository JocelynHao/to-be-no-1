package com.nemo.tobeno1.utils;

/**
 * @author hs
 * @version 1.0
 * @date 2019/1/29 15:48
 */
public class Util {
    /**
     * 交换数组中两个元素的位置
     *
     * @param arr 待处理的数组
     * @param x 一个元素的下标
     * @param y 另一个元素的下标
     * @param <T> 数组类型
     */
    public static <T> void Swap(T[] arr, int x, int y){
        T temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
