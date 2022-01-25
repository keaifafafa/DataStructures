package com.fafa.sort;

import java.util.Arrays;

/**
 * 基数排序（桶排序的扩展）
 * 其思路与桶排序还有基数排序很类似，所以这里只讲解基数排序（很消耗内存，数据量太大的时候会 OutOfMemoryError ）
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-16 20:17
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println("基数排序结果：" + Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        // 创建 10 个桶（0 - 9）,每个桶就是一个一维数组
        // 为了防止在放入的时候，数据溢出，则每个一维数组（桶），大小设定为 arr.length
        int[][] bucket = new int[10][arr.length];
        // 创建10个用于统计桶内元素个数(初始值都是0,即桶内元素个数)
        int[] countBucketEle = new int[10];
        // 最大数字（用于获取最大的位数）
        int max = 0;
        // 循环遍历寻找最大数字
        for (int data : arr) {
            if (data > max) {
                max = data;
            }
        }
        // 获取最大的位数（即长度）
        int maxLength = (max + "").length();
        for (int i = 0, k = 1; i < maxLength; i++, k *= 10) {
            // 针对每个元素的对应位进行排序处理，第一次是个位，第二次是十位，第三次是百位……以此类推
            for (int j = 0; j < arr.length; j++) {
                // 获取位数（个、十、百位等）
                int digitOfElement = arr[j] / k % 10;
                // 放入对应的桶中
                bucket[digitOfElement][countBucketEle[digitOfElement]] = arr[j];
                // 对应索引加1
                countBucketEle[digitOfElement]++;
            }
            // 按照这个桶的顺序（一维数组的下标依次取出数据，放回原来的数组）
            // 原来数组的初始下标
            int index = 0;
            // 遍历 10 个桶
            for (int n = 0; n < countBucketEle.length; n++) {
                // 桶内元素不为空
                if (countBucketEle[n] != 0) {
                    for (int s = 0; s < countBucketEle[n]; s++) {
                        arr[index] = bucket[n][s];
                        index++;
                    }
                }
                // 数据置零，因为还会有其他位数的进行循环遍历
                countBucketEle[n] = 0;
            }
        }
    }

}

