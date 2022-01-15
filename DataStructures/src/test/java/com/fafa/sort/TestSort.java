package com.fafa.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

/**
 * 测试各种排序算法的速度
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-11 21:38
 */
public class TestSort {

    /**
     * 测试冒泡排序效率
     * 测试一下冒泡的速度 O(n^2),给8W个数据，测试
     */
    @Test
    public void testBubble() {
        // 容量
        int capacity = 80000;
        // 创建 8W 容量的数组
        int[] arr = new int[capacity];
        // 初始化数据
        for (int i = 0; i < capacity; i++) {
            // 生成随机数
            arr[i] = (int) (Math.random() * capacity);
        }
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 开始时间
        String start = sd.format(new Date());
        System.out.println("排序前的时间" + start);
        BubbleSort.sort(arr);
        String end = sd.format(new Date());
        System.out.println("排序后的时间" + end);
    }

    /**
     * 测试选择排序的效率
     */
    @Test
    public void testSelect() {
        // 容量
        int capacity = 80000;
        // 创建 8W 容量的数组
        int[] arr = new int[capacity];
        // 初始化数据
        for (int i = 0; i < capacity; i++) {
            // 生成随机数
            arr[i] = (int) (Math.random() * capacity);
        }
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 开始时间
        String start = sd.format(new Date());
        System.out.println("排序前的时间" + start);
        // 优化后的选择排序
        SelectSort.selectSort(arr);
        // 未优化的选择排序
//        SelectSort.selectSort2(arr);
        String end = sd.format(new Date());
        System.out.println("排序后的时间" + end);
    }

    /**
     * 测试插入排序
     */
    @Test
    public void testInsert() {
        // 容量
        int capacity = 80000;
        // 创建 8W 容量的数组
        int[] arr = new int[capacity];
        // 初始化数据
        for (int i = 0; i < capacity; i++) {
            // 生成随机数
            arr[i] = (int) (Math.random() * (capacity * 100));
        }
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 开始时间
        String start = sd.format(new Date());
        System.out.println("排序前的时间" + start);
        // 插入排序
        InsertSort.insertSort(arr);
        String end = sd.format(new Date());
        System.out.println("排序后的时间" + end);
//        System.out.println(Arrays.toString(arr));
    }

    /**
     * 测试通过交换法实现的希尔排序
     */
    @Test
    public void testShellBySwap() {
        // 容量
        int capacity = 80000;
        // 创建 8W 容量的数组
        int[] arr = new int[capacity];
        // 初始化数据
        for (int i = 0; i < capacity; i++) {
            // 生成随机数
            arr[i] = (int) (Math.random() * (capacity * 100));
        }
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 开始时间
        String start = sd.format(new Date());
        System.out.println("排序前的时间" + start);
        // 希尔排序（交换法）
        ShellSort.shellSortBySwap2(arr);
        String end = sd.format(new Date());
        System.out.println("排序后的时间" + end);
    }

    /**
     * 测试通过移位法实现的希尔排序
     */
    @Test
    public void testShellByShift() {
        // 容量
        int capacity = 8000000;
        // 创建 8W 容量的数组
        int[] arr = new int[capacity];
        // 初始化数据
        for (int i = 0; i < capacity; i++) {
            // 生成随机数
            arr[i] = (int) (Math.random() * (capacity * 100));
        }
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 开始时间
        String start = sd.format(new Date());
        System.out.println("排序前的时间" + start);
        // 希尔排序（移位法）
        ShellSort.shellSortByShift(arr);
        String end = sd.format(new Date());
        System.out.println("排序后的时间" + end);
    }

    /**
     * 测试快速排序(用空间换时间)
     */
    @Test
    public void testQuick() {
        // 容量
        int capacity = 8000000;
        // 创建 8W 容量的数组
        int[] arr = new int[capacity];
        // 初始化数据
        for (int i = 0; i < capacity; i++) {
            // 生成随机数
            arr[i] = (int) (Math.random() * (capacity * 100));
        }
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 开始时间
        String start = sd.format(new Date());
        System.out.println("排序前的时间" + start);
        // 快速排序
        QuickSort.quickSort(arr, 0, arr.length - 1);
        String end = sd.format(new Date());
        System.out.println("排序后的时间" + end);
//        System.out.println(Arrays.toString(arr));
    }

    /**
     * 测试归并排序的速度
     */
    @Test
    public void testMerge() {
        // 容量
        int capacity = 8000000;
        // 创建 8W 容量的数组
        int[] arr = new int[capacity];
        // 归并排序额外空间
        int[] temp = new int[capacity];
        // 初始化数据
        for (int i = 0; i < capacity; i++) {
            // 生成随机数
            arr[i] = (int) (Math.random() * (capacity * 100));
        }
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 开始时间
        String start = sd.format(new Date());
        System.out.println("排序前的时间" + start);
        // 归并排序
        MergeSort.mergeSort(arr, 0, arr.length - 1, temp);
        String end = sd.format(new Date());
        System.out.println("排序后的时间" + end);
//        System.out.println(Arrays.toString(arr));
    }

}
