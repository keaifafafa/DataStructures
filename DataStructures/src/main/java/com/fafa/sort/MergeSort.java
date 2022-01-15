package com.fafa.sort;

import java.util.Arrays;

/**
 * 归并排序（分治思想，先分而后治）
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-15 17:22
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println("排序后的结果：" + Arrays.toString(arr));
    }

    /**
     * 分割 + 合并
     * 思路：
     * 先将数组元素分隔开（二分处理，直到分成单个元素）
     * 分割完就开始进行合并了（运用递归的栈的机制特性，后进先出，因为是最后被分割成单个元素的，所以肯定是先合并单个元素的）
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        // 首先需要先分割
        if (left < right) {
            int mid = (left + right) / 2;
            // 向左进行递归分解
            mergeSort(arr, left, mid, temp);
            // 向右进行递归分解
            mergeSort(arr, mid + 1, right, temp);
            // 然后进行合并( 根据栈的特性思考哦 )
            merge(arr, left, mid, right, temp);
        }

    }

    /**
     * 合并（分割完后进行的操作）
     *
     * @param arr   原数组
     * @param left  左索引
     * @param mid   中间索引
     * @param right 右索引
     * @param temp  额外的空间
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 左边有序序列的初始索引
        int l = left;
        // 右边有序序列的初始索引
        int r = mid + 1;
        // temp 数组的下标
        int t = 0;
        // 1、先把左右两边（有序）数组按照规则填充到temp数组中
        // 2、直到有一边处理完为止
        while (l <= mid && r <= right) {
            // 如果左边的数 比 右边的大
            if (arr[l] > arr[r]) {
                temp[t] = arr[r];
                r++;
            }
            // 反之
            else {
                temp[t] = arr[l];
                l++;
            }
            t++;
        }

        // 3、然后把另外一边的剩余数字全部拷贝到 temp
        // 假如左边有序数组还有数字未合并
        while (l <= mid) {
            temp[t] = arr[l];
            l++;
            t++;
        }
        // 假如右边有序数组还有数字未合并
        while (r <= right) {
            temp[t] = arr[r];
            r++;
            t++;
        }

        // 4、最后再把 temp 的结果 拷贝到 原数组即可
        // 注意：并不是每一次都需要拷贝所有的temp，因为只有最后依次是拷贝所有，其余都是部分拷贝
        t = 0;
        int tempLeft = left;
        //第一次合并 end = 0 , right = 1 //  end = 2  right = 3 // end = 0 right = 3
        //最后一次 end = 0  right = 7
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }

}
