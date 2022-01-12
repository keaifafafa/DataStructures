package com.fafa.sort;

import java.util.Arrays;

/**
 * ð������
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-11 21:00
 */
public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {3, 9, -1, 10, -2, 5, 7, 1, 8};
        int[] arr = {3, 9, 12, -4, -1, 10, -2};
//        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println("����ǰ��");
        System.out.println(Arrays.toString(arr));
        // ����
        sort(arr);
        System.out.println("�����");
        System.out.println(Arrays.toString(arr));
        // �Լ�д�Ĵ�ӡ����
//        show(arr);
    }

    /**
     * ð������
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        // ��ʶ��������ʶ�Ƿ���й�����
        boolean flag = false;
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // ���ǰ������Ⱥ���������򽻻�
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            // ֱ��ֹͣ
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }

    /**
     * ��ӡ����
     *
     * @param arr
     */
    public static void show(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

}
