package com.fafa.sort;

import java.util.Arrays;

/**
 * ϣ������
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-13 18:37
 */
public class ShellSort {

    public static void main(String[] args) {
        // ��������
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        shellSortBySwap1(arr);
//        shellSortBySwap2(arr);
        shellSortByShift(arr);
    }

    /**
     * ͨ��������ʵ��ϣ������(�ֲ���ʾ)
     * ˼·��
     * 1��ÿ�ζ�Ҫ���飬����������ʼ������ ���鳤��/2(һ��ʼ�������������ԱȽ���)
     * 2��Ȼ��������в��� / 2,ֱ������ == 0 ������Ҳ����������ˣ�
     *
     * @param arr
     */
    public static void shellSortBySwap1(int[] arr) {
        int temp = 0;
        // Shell����ĵ�һ��
        // ��һ�������ǽ�10�����ݷֳ�5�飨���֣� ���ѭ�������ǱȽϿ����
        for (int i = 5; i < arr.length; i++) {
            // �������������е�Ԫ�أ���5�飬ÿ������Ԫ�أ�������Ϊ 5
            for (int j = i - 5; j >= 0; j -= 5) {
                if (arr[j + 5] < arr[j]) {
                    temp = arr[j + 5];
                    arr[j + 5] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("��һ��Shell��������" + Arrays.toString(arr));
        // �ڶ�������
        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >= 0; j -= 2) {
                if (arr[j + 2] < arr[j]) {
                    temp = arr[j + 2];
                    arr[j + 2] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("�ڶ���Shell��������" + Arrays.toString(arr));
        // ����������
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j -= 1) {
                if (arr[j + 1] < arr[j]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("������Shell��������" + Arrays.toString(arr));
    }


    /**
     * ͨ��������ʵ��ϣ�������������룩
     * ȱ�㣺����ð�ݺ�ѡ��һ���ᷢ��һЩû�б�Ҫ�û�����������������Ԫ�ؽ����û�����������ʱ��
     *
     * @param arr
     */
    public static void shellSortBySwap2(int[] arr) {
        int temp = 0;
        int count = 0;
        // Ҫ�ټ�һ��ѭ��  ������ÿ���ڴ�ѭ����������2��
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
//        System.out.println("������ϣ��������Ϊ��" + Arrays.toString(arr));
    }

    /**
     * ϣ������(��λ��)
     * ˼·: ���Բο���������
     */
    public static void shellSortByShift(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for (int step = arr.length / 2; step > 0; step /= 2) {
            for (int i = step; i < arr.length; i++) {
                insertIndex = i;
                insertVal = arr[i];
                // ���ǰ������Ⱥ��������
                if (arr[insertIndex] < arr[insertIndex - step]){
                    // ��Ȼ����ֱ����һ���ͽ���һ����Ҫ�ҵ���С��λ���ٻ� Ҫע��Ҫ�� insertVal ����
                    while ((insertIndex - step) >= 0 && insertVal < arr[insertIndex - step]){
                        // �൱�ڽ�ǰ���ֵ����
                        arr[insertIndex] = arr[insertIndex - step];
                        insertIndex -= step;
                    }
                }
                // ����ƶ��� insertIndex
                if (insertIndex != i){
                    arr[insertIndex] = insertVal;
                }
            }

        }
//        System.out.println("��λ��ϣ��������Ϊ��" + Arrays.toString(arr));
    }
}
