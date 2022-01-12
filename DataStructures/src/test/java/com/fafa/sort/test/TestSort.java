package com.fafa.sort.test;

import com.fafa.sort.BubbleSort;
import com.fafa.sort.SelectSort;
import org.junit.Test;

import java.text.SimpleDateFormat;
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

    @Test
    public void testHash() {
        HashSet<Integer> hashSet = new HashSet<>();
        Integer i = 10;
        hashSet.add(i);
        hashSet.contains(i);
    }


}
