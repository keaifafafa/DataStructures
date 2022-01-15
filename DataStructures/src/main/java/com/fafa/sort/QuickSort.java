package com.fafa.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-14 18:16
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {-9, 78, 1, 0, 0, -3, 23, -567, 70, -10, 99, 108, 4, -55};
//        int[] arr = {-9, 78, 1, -92, 0, -3, 23, -567, 70};
//        int[] arr = {-9, 78, 1, 0, 0, -3, 23, -567, 70};
        int[] arr = {3, -1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序实现（用空间换时间）
     *
     * @param arr
     */
    public static void quickSort(int[] arr, int left, int right) {
        // 左索引
        int l = left;
        // 右索引
        int r = right;
        // 中轴值
        int pivot = arr[(l + r) / 2];
        int temp = 0;
        // 其实while循环结束后， l == r
        while (l < r) {
            // 寻找左边比 中轴值大的
            while (arr[l] < pivot) {
                l++;
            }
            // 寻找右边比 中轴值小的
            while (arr[r] > pivot) {
                r--;
            }
            // 如果 l >= r,说明pivot的左右两边的值，已经按照左边全部是小于等于pivot值，右边全部是大于等于pivot的值
            // 这一步不加的话，后面的递归会栈溢出
            // 避免 l == r 的情况，因为下面还有两条if语句（对 l 和 r进行重置）
            if (l == r) {
                break;
            }
            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // 如果arr[l] == pivot的话,直接 r--；是其不满足 l < r 的条件，直接跳出循环结束本次
            if (arr[l] == pivot) {
                r--;
            }
            // 如果arr[r] == pivot的话,直接 l++；是其不满足 l < r 的条件，直接跳出循环结束本次
            if (arr[r] == pivot) {
                l++;
            }
        }
        // 接下来就是递归操作了
        // 如果 l == r，否则是个死循环（栈溢出Stack Overflow），最典型的例子就是 l 和 r 都在 pivot 的位置
        if (l == r) {
            // 左指针右移一下
            l++;
            // 右指针左移一下
            r--;
        }
        // 向左递归（因为右指针还未到最左边）
        if (left < r) {
            quickSort(arr, left, r);
        }
        // 右递归 (同上)
        if (right > l) {
            quickSort(arr, l, right);
        }

    }
}
