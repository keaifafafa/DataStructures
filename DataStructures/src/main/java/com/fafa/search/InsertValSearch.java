package com.fafa.search;

/**
 * 插值查找
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-18 21:51
 */
public class InsertValSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        // 生成100个连续的测试数组（1-100）
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        int target = 66;
        // 调用插值查找
        int search = insertValSearch(arr, 0, arr.length - 1, target);
        System.out.println("插值查找结果：" + search);

    }

    /**
     * 插值查找
     * 其思路与二分查找很类似
     * 不同之处是： 定位midIndex的公式不同（自适应的算法）
     * 算法公式是： int midIndex = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
     *
     * @param arr
     * @param left
     * @param right
     * @param target
     * @return
     */
    public static int insertValSearch(int[] arr, int left, int right, int target) {
        System.out.println("insertValSearch被调用~");
        // 新增了两条，需要对target的合法性进行校验，因为自适应公式用到了target值（所以必须要做校验）
        if (left > right || target < arr[left] || target > arr[right]) {
            return -1;
        }
        // 自适应公式
        int midIndex = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[midIndex];
        if (target > midVal) {
            return insertValSearch(arr, midIndex + 1, right, target);
        } else if (target < midVal) {
            return insertValSearch(arr, left, midIndex - 1, target);
        } else {
            return midIndex;
        }
    }
}
