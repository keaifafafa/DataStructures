package com.fafa.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找(数组一定要是有序的)
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-18 14:32
 */
public class BinarySearch {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 8, 8, 8, 8, 8, 8, 9, 10, 89, 1000, 1234};
        int[] arr = {1, 9, 10, 89, 1000, 1000, 1234};
        int target = 1000;
        // 方法一
       /* int res = binarySearch01(arr, 0, arr.length - 1, target);
        System.out.println("res = " + res);*/

        // 方法二
        List<Integer> list = binarySearch02(arr, 0, arr.length - 1, target);
        System.out.println("list = " + list.toString());

    }

    /**
     * 二分查找基础方法（只能找到一个）
     * 递归法
     * 思路：
     * 1、先计算出中间的下标，并保留中间下标对应的数字
     * 2、然后递归查找，如果目标比中间值小，那么向左递归，反之，向右递归
     * 3、如果找到返回其下标，未找到则继续递归，直到 left > right 为止
     *
     * @param arr
     * @param left
     * @param right
     * @param target
     * @return
     */
    public static int binarySearch01(int[] arr, int left, int right, int target) {
        // 递归头（结束标志）
        if (left > right) {
            return -1;
        }
        // 中值下标
        int midIndex = (left + right) / 2;
        // 中值
        int midVal = arr[midIndex];

        // 向左递归
        if (target < midVal) {
            return binarySearch01(arr, left, midIndex - 1, target);
        }
        // 向右递归
        else if (target > midVal) {
            return binarySearch01(arr, midIndex + 1, right, target);
        }
        // 找到目标
        else {
            return midIndex;
        }
    }

    /**
     * 二分查找基础方法（可以找到多个）
     * 递归法
     * 思路：
     * 1、在收到目标后，不要马上返回，而是先扫描其左边的（因为是有序的）
     * 2、如果左边的下标小于0 或者 不等于目标值了，则直接结束，否则将找到下标添加到集合中
     * 3、添加目标的下标
     * 4、扫描目标右面的元素，方法和左边的类似
     * 5、全部扫完，返回即可
     *
     * @param arr
     * @param left
     * @param right
     * @param target
     * @return
     */
    public static List<Integer> binarySearch02(int[] arr, int left, int right, int target) {
        // 递归头（结束标志）
        if (left > right) {
            return new ArrayList<Integer>();
        }
        // 中值下标
        int midIndex = (left + right) / 2;
        // 中值
        int midVal = arr[midIndex];

        // 向左递归
        if (target < midVal) {
            return binarySearch02(arr, left, midIndex - 1, target);
        }
        // 向右递归
        else if (target > midVal) {
            return binarySearch02(arr, midIndex + 1, right, target);
        }
        // 找到目标
        else {
            // 下标集合（用于接受多个目标元素的下标）
            List<Integer> list = new ArrayList<Integer>();
            // 用于遍历下标
            int listIndex = midIndex - 1;
            // 先扫描左边的
            while (listIndex >= left) {
                if (arr[listIndex] == midVal) {
                    list.add(listIndex);
                    listIndex--;
                } else {
                    break;
                }
            }
            list.add(midIndex);
            // 扫描右边
            listIndex = midIndex + 1;
            while (listIndex <= right) {
                if (arr[listIndex] == midVal) {
                    list.add(listIndex);
                    listIndex++;
                } else {
                    break;
                }
            }
            return list;
        }
    }
}
