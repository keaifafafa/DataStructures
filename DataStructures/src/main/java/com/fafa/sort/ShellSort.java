package com.fafa.sort;

import java.util.Arrays;

/**
 * 希尔排序
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-13 18:37
 */
public class ShellSort {

    public static void main(String[] args) {
        // 测试数据
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        shellSortBySwap1(arr);
//        shellSortBySwap2(arr);
        shellSortByShift(arr);
    }

    /**
     * 通过交换法实现希尔排序(分步演示)
     * 思路：
     * 1、每次都要分组，即步长，初始步长是 数组长度/2(一开始基本就是两两对比交换)
     * 2、然后继续进行步长 / 2,直到步长 == 0 结束（也就排序完毕了）
     *
     * @param arr
     */
    public static void shellSortBySwap1(int[] arr) {
        int temp = 0;
        // Shell排序的第一轮
        // 第一轮排序，是将10个数据分成5组（二分） 外层循环的数是比较靠后的
        for (int i = 5; i < arr.length; i++) {
            // 遍历各组中所有的元素（共5组，每组两个元素），步长为 5
            for (int j = i - 5; j >= 0; j -= 5) {
                if (arr[j + 5] < arr[j]) {
                    temp = arr[j + 5];
                    arr[j + 5] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("第一轮Shell排序结果：" + Arrays.toString(arr));
        // 第二轮排序
        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >= 0; j -= 2) {
                if (arr[j + 2] < arr[j]) {
                    temp = arr[j + 2];
                    arr[j + 2] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("第二轮Shell排序结果：" + Arrays.toString(arr));
        // 第三轮排序
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j -= 1) {
                if (arr[j + 1] < arr[j]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("第三轮Shell排序结果：" + Arrays.toString(arr));
    }


    /**
     * 通过交换法实现希尔排序（完整代码）
     * 缺点：就像冒泡和选择一样会发生一些没有必要置换（即看到满足条件元素进行置换），很消耗时间
     *
     * @param arr
     */
    public static void shellSortBySwap2(int[] arr) {
        int temp = 0;
        int count = 0;
        // 要再加一层循环  步长（每次内存循环结束，除2）
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                for (int j = i - step; j >= 0; j -= step) {
                    if (arr[j] > arr[j + step]) {
                        temp = arr[j + step];
                        arr[j + step] = arr[j];
                        arr[j] = temp;
                    }
                }
            }

        }
//        System.out.println("交换法希尔排序结果为：" + Arrays.toString(arr));
    }

    /**
     * 希尔排序(移位法)
     * 思路: 可以参考插入排序
     */
    public static void shellSortByShift(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                insertIndex = i;
                insertVal = arr[i];
                // 如果前面的数比后面的数大
                if (arr[insertIndex] < arr[insertIndex - step]){
                    // 当然不能直接有一个就交换一个，要找到最小的位置再换 要注意要用 insertVal 来比
                    while ((insertIndex - step) >= 0 && insertVal < arr[insertIndex - step]){
                        // 相当于将前面的值后移
                        arr[insertIndex] = arr[insertIndex - step];
                        insertIndex -= step;
                    }
                }
                // 如果移动过 insertIndex
                if (insertIndex != i){
                    arr[insertIndex] = insertVal;
                }
            }

        }
//        System.out.println("移位法希尔排序结果为：" + Arrays.toString(arr));
    }
}
