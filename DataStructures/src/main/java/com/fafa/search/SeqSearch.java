package com.fafa.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 线性查找
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-18 14:14
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {19, 33, 45, 67, 2, 53, 99, 88, 1, 2, 100};
        int target = 55;
        List<Integer> seqSearch = seqSearch(arr, target);
        System.out.println(seqSearch.toString());
    }

    /**
     * 返回数组内目标元素的下标（可能含有多个）
     *
     * @param arr
     * @param target
     * @return
     */
    public static List<Integer> seqSearch(int[] arr, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                // 添加下标
                list.add(i);
            }
        }
        return list;
    }
}
