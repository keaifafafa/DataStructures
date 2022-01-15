package com.fafa.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-13 10:45
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        insertSort(arr);
        System.out.println("插入排序后：" + Arrays.toString(arr));
    }

    /**
     * 插入排序
     * 思路：
     * 1、先把第一个元素当做有序的
     * 2、然后依次进行对比（和前面的元素），如果当前插入元素比前面的元素小则 将插入元素位置的值变成前面元素的值
     * 3、while循环结束后，也就是找到了插入位置，再把该位置的值变成 insertVal
     */
    public static void insertSort(int[] arr) {
        // 需要插入的值
        int insertVal = 0;
        // 插入位置的前一个下标
        int insertIndex = 0;
        // 因为第一个是有序的,所以 i = 1
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            // 开始遍历进行查找目标位置
            while(insertIndex >= 0 && insertVal < arr[insertIndex]){
                // 相当于把元素后移
                arr[insertIndex + 1] = arr[insertIndex];
                // 继续向前
                insertIndex--;
            }
            // 不在正确的位置（这样可以减少不必要的赋值，因为有可能已经有序，无需在进行操作）
            if (insertIndex != i - 1){
                // 将最后遍历到的位置 进行 重置
                arr[insertIndex + 1] = insertVal;
            }
        }
    }
}
