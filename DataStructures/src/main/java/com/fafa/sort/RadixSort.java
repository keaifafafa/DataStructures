package com.fafa.sort;

import java.util.Arrays;

/**
 * ��������Ͱ�������չ��
 * ��˼·��Ͱ�����л�����������ƣ���������ֻ����������򣨺������ڴ棬������̫���ʱ��� OutOfMemoryError ��
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-16 20:17
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println("������������" + Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        // ���� 10 ��Ͱ��0 - 9��,ÿ��Ͱ����һ��һά����
        // Ϊ�˷�ֹ�ڷ����ʱ�������������ÿ��һά���飨Ͱ������С�趨Ϊ arr.length
        int[][] bucket = new int[10][arr.length];
        // ����10������ͳ��Ͱ��Ԫ�ظ���(��ʼֵ����0,��Ͱ��Ԫ�ظ���)
        int[] countBucketEle = new int[10];
        // ������֣����ڻ�ȡ����λ����
        int max = 0;
        // ѭ������Ѱ���������
        for (int data : arr) {
            if (data > max) {
                max = data;
            }
        }
        // ��ȡ����λ���������ȣ�
        int maxLength = (max + "").length();
        for (int i = 0, k = 1; i < maxLength; i++, k *= 10) {
            // ���ÿ��Ԫ�صĶ�Ӧλ������������һ���Ǹ�λ���ڶ�����ʮλ���������ǰ�λ�����Դ�����
            for (int j = 0; j < arr.length; j++) {
                // ��ȡλ��������ʮ����λ�ȣ�
                int digitOfElement = arr[j] / k % 10;
                // �����Ӧ��Ͱ��
                bucket[digitOfElement][countBucketEle[digitOfElement]] = arr[j];
                // ��Ӧ������1
                countBucketEle[digitOfElement]++;
            }
            // �������Ͱ��˳��һά������±�����ȡ�����ݣ��Ż�ԭ�������飩
            // ԭ������ĳ�ʼ�±�
            int index = 0;
            // ���� 10 ��Ͱ
            for (int n = 0; n < countBucketEle.length; n++) {
                // Ͱ��Ԫ�ز�Ϊ��
                if (countBucketEle[n] != 0) {
                    for (int s = 0; s < countBucketEle[n]; s++) {
                        arr[index] = bucket[n][s];
                        index++;
                    }
                }
                // �������㣬��Ϊ����������λ���Ľ���ѭ������
                countBucketEle[n] = 0;
            }
        }
    }

}

