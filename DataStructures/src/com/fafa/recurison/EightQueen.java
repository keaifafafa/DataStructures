package com.fafa.recurison;

import com.sun.scenario.effect.impl.state.AccessHelper;

/**
 * �˻ʺ����⣬����Ļ�������
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-09 14:17
 */
public class EightQueen {
    /**
     * �������������Ҳ���ǻʺ�����
     */
    private int max = 4;
    /**
     * ��¼�е�����
     */
    private int[] arr = new int[max];
    /**
     * �ⷨ��
     */
    private static int wayCount = 0;

    public static void main(String[] args) {
        EightQueen queen = new EightQueen();
        queen.checkWay(0);
        System.out.println("wayCount = " + wayCount);
    }

    /**
     * ���ͨ·
     */
    public void checkWay(int n) {
        // n == max Ҳ����Ҳ��ȫ����ͨ���ˣ���Ϊ�����Ǵ�0��ʼ��
        if (n == max) {
            showWay();
            return;
        }
        // ���и�ֵ��ͬʱ�ж�Ѱ·
        for (int i = 0; i < max; i++) {
            // ���и�ֵ
            arr[n] = i;
            // �����ͨ·
            if (judgeWay(n)) {
                // ���������һ��
                checkWay(n + 1);
            }
        }
    }

    /**
     * �ж��Ƿ�Ϊͨ·
     * 1�������ʺ�����ͬһ�� (arr[i] == arr[n])��ͬһ��(����nÿ�ζ����ۼӣ����Բ��ÿ���)
     * 2�������ʺ�����ͬһб���ϣ� ���������Σ�Math.abs(n - i) == Math.abs(arr[n] - arr[i]) ��
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
     * ��ʾͨ·
     */
    public void showWay() {
        wayCount++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        // ����
        System.out.println();
    }

}
