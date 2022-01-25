package com.fafa.search;

import java.util.Arrays;

/**
 * 斐波那契查找
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-19 18:11
 */
public class FibonacciSearch {
    /**
     * 最大容量
     */
    private static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 189, 1000, 1234};
        System.out.println("index = " + fibSearch(arr, 1234));
    }

    /**
     * 生成斐波那契数列
     *
     * @return
     */
    public static int[] fibonacci() {
        int[] nums = new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            if (i == 0 || i == 1) {
                nums[i] = 1;
            } else {
                nums[i] = nums[i - 1] + nums[i - 2];
            }
        }
        return nums;
    }

    /**
     * 斐波那契查找（迭代法）
     *
     * @param arr 数组
     * @param key 我们需要查找的关键值
     * @return 返回对应的下标，如果没有，返回 -1
     */
    public static int fibSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        // 存放mid值
        int mid = 0;
        // 生成斐波那契额数组
        int[] f = fibonacci();
        // 表示斐波那契数值的下标
        int k = 0;
        // 获取斐波那契分割数值的下标（只要顺序表长度为 f[k] - 1 ， 即可以使用mid公式）
        while (high > f[k] - 1) {
            k++;
        }
        // 因为 f[k] 值 可能大于 a 的 长度，因此我们需要使用Arrays类，构造一个新的数组，并指向temp[]
        // 不足的部分会使用0填充
        int[] temp = Arrays.copyOf(arr, f[k]);
        //实际上需求使用a数组最后的数填充 temp
        //举例:
        //temp = {1,8, 10, 89, 1000, 1234, 0, 0}  => {1,8, 10, 89, 1000, 1234, 1234, 1234,}
        for (int i = k; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        while (low <= high) {
            mid = low + f[k - 1] - 1;
            // 需要继续往前找（可以理解为向左）
            if (key < temp[mid]) {
                high = mid - 1;
                // 注意：这里为什么是k--;
                // 1、全部元素 = 前面元素 + 后面元素
                // 2、f[k] = f[k -1] + f[k - 2];
                // 因为 前面有 f[k - 1]个元素,所以可以继续拆分 f[k - 1] = f[k - 2] + f[k - 3]
                // 即 在 f[k - 1] 的前面继续查找 k--
                // 即下次循环 mid = f[k - 1 - 1] - 1
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                //为什么是k -=2
                //说明
                //1. 全部元素 = 前面的元素 + 后边元素
                //2. f[k] = f[k - 1] + f[k - 2]
                //3. 因为后面我们有f[k - 2] 所以可以继续拆分 f[k - 2] = f[k-3] + f[k-4]
                //4. 即在f[k - 2] 的前面进行查找 k -= 2
                //5. 即下次循环 mid = f[k - 1 - 2] - 1
                k -= 2;
            } else {
                // 要返回比较小的一个（因为mid，可能会指向扩容的地址）
                return mid = mid <= high ? mid : high;
            }
        }
        return -1;
    }

}
