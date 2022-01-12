package com.fafa.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-11 21:00
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {3, 9, -1, 10, -2, 5, 7, 1, 8};
        int[] arr = {3, 9, 12, -4, -1, 10, -2};
//        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        // 排序
        sort(arr);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
        // 自己写的打印方法
//        show(arr);
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        // 标识变量，标识是否进行过交换
        boolean flag = false;
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            // 直接停止
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void show(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

}
