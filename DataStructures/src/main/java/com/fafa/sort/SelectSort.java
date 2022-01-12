package com.fafa.sort;

import java.util.Arrays;

/**
 * 选择排序
 * @author Sire
 * @version 1.0
 * @date 2022-01-12 19:41
 */
public class SelectSort {
    public static void main(String[] args) {
        // 测试数据
        int[] nums = {101,34,119,1};
        System.out.println("排序前的结果：" + Arrays.toString(nums));
        selectSort(nums);
        System.out.println("选择排序后的结果：" + Arrays.toString(nums));

    }

    /**
     * 选择排序（已优化）
     * 思路:
     * 1、首先，先假定最小值和最小值的下表索引
     * 2、然后进行寻找，如果找到比最小值还要小的，进行最小值和最小值下表索引的重置
     * 3、然后进行位置置换（换到本次循环的头元素位置，即 i ）
     * @param nums
     */
    public static void selectSort(int[] nums){
        for(int i = 0; i < nums.length - 1; i++){
            int min = nums[i];
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++){
                // 如果最小值 比 后面的数大
                if (min > nums[j]){
                    // 给最小值和最小值的下标 赋值（更小的值）
                    min = nums[j];
                    // 重置 minIndex
                    minIndex = j;
                }
            }
            // 置换位置(这样可以减少不必要的置换,比如本身就在目标位置的情况下)
            if (minIndex != i){
                nums[minIndex] = nums[i];
                nums[i] = min;
            }
        }
    }

    /**
     * 未优化的选择排序
     * @param nums
     */
    public static void selectSort2(int[] nums){
        int temp = 0;
        for (int i= 0; i < nums.length - 1; i++){
            for (int j = i + 1; j < nums.length; j++){
                // 说明假设的最小值，并非最小值
                if (nums[i] > nums[j]){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
