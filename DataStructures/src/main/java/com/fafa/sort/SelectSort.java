package com.fafa.sort;

import java.util.Arrays;

/**
 * ѡ������
 * @author Sire
 * @version 1.0
 * @date 2022-01-12 19:41
 */
public class SelectSort {
    public static void main(String[] args) {
        // ��������
        int[] nums = {101,34,119,1};
        System.out.println("����ǰ�Ľ����" + Arrays.toString(nums));
        selectSort(nums);
        System.out.println("ѡ�������Ľ����" + Arrays.toString(nums));

    }

    /**
     * ѡ���������Ż���
     * ˼·:
     * 1�����ȣ��ȼٶ���Сֵ����Сֵ���±�����
     * 2��Ȼ�����Ѱ�ң�����ҵ�����Сֵ��ҪС�ģ�������Сֵ����Сֵ�±�����������
     * 3��Ȼ�����λ���û�����������ѭ����ͷԪ��λ�ã��� i ��
     * @param nums
     */
    public static void selectSort(int[] nums){
        for(int i = 0; i < nums.length - 1; i++){
            int min = nums[i];
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++){
                // �����Сֵ �� ���������
                if (min > nums[j]){
                    // ����Сֵ����Сֵ���±� ��ֵ����С��ֵ��
                    min = nums[j];
                    // ���� minIndex
                    minIndex = j;
                }
            }
            // �û�λ��(�������Լ��ٲ���Ҫ���û�,���籾�����Ŀ��λ�õ������)
            if (minIndex != i){
                nums[minIndex] = nums[i];
                nums[i] = min;
            }
        }
    }

    /**
     * δ�Ż���ѡ������
     * @param nums
     */
    public static void selectSort2(int[] nums){
        int temp = 0;
        for (int i= 0; i < nums.length - 1; i++){
            for (int j = i + 1; j < nums.length; j++){
                // ˵���������Сֵ��������Сֵ
                if (nums[i] > nums[j]){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
