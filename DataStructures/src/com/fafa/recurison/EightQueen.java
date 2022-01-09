package com.fafa.recurison;

import com.sun.scenario.effect.impl.state.AccessHelper;

/**
 * 八皇后问题，经典的回溯问题
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-09 14:17
 */
public class EightQueen {
    /**
     * 数组最大容量（也就是皇后数）
     */
    private int max = 4;
    /**
     * 记录列的数组
     */
    private int[] arr = new int[max];
    /**
     * 解法数
     */
    private static int wayCount = 0;

    public static void main(String[] args) {
        EightQueen queen = new EightQueen();
        queen.checkWay(0);
        System.out.println("wayCount = " + wayCount);
    }

    /**
     * 检测通路
     */
    public void checkWay(int n) {
        // n == max 也就是也就全部走通过了，因为数组是从0开始的
        if (n == max) {
            showWay();
            return;
        }
        // 给列赋值，同时判断寻路
        for (int i = 0; i < max; i++) {
            // 给列赋值
            arr[n] = i;
            // 如果是通路
            if (judgeWay(n)) {
                // 继续检测下一个
                checkWay(n + 1);
            }
        }
    }

    /**
     * 判断是否为通路
     * 1、两个皇后不能在同一列 (arr[i] == arr[n])、同一行(由于n每次都会累加，所以不用考虑)
     * 2、两个皇后不能在同一斜线上（ 等腰三角形，Math.abs(n - i) == Math.abs(arr[n] - arr[i]) ）
     *
     * @return
     */
    public boolean judgeWay(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 显示通路
     */
    public void showWay() {
        wayCount++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        // 换行
        System.out.println();
    }

}
