package com.fafa.sort;

import java.util.Arrays;

/**
 * �鲢���򣨷���˼�룬�ȷֶ����Σ�
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-15 17:22
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println("�����Ľ����" + Arrays.toString(arr));
    }

    /**
     * �ָ� + �ϲ�
     * ˼·��
     * �Ƚ�����Ԫ�طָ��������ִ���ֱ���ֳɵ���Ԫ�أ�
     * �ָ���Ϳ�ʼ���кϲ��ˣ����õݹ��ջ�Ļ������ԣ�����ȳ�����Ϊ����󱻷ָ�ɵ���Ԫ�صģ����Կ϶����Ⱥϲ�����Ԫ�صģ�
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        // ������Ҫ�ȷָ�
        if (left < right) {
            int mid = (left + right) / 2;
            // ������еݹ�ֽ�
            mergeSort(arr, left, mid, temp);
            // ���ҽ��еݹ�ֽ�
            mergeSort(arr, mid + 1, right, temp);
            // Ȼ����кϲ�( ����ջ������˼��Ŷ )
            merge(arr, left, mid, right, temp);
        }

    }

    /**
     * �ϲ����ָ������еĲ�����
     *
     * @param arr   ԭ����
     * @param left  ������
     * @param mid   �м�����
     * @param right ������
     * @param temp  ����Ŀռ�
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // ����������еĳ�ʼ����
        int l = left;
        // �ұ��������еĳ�ʼ����
        int r = mid + 1;
        // temp ������±�
        int t = 0;
        // 1���Ȱ��������ߣ��������鰴�չ�����䵽temp������
        // 2��ֱ����һ�ߴ�����Ϊֹ
        while (l <= mid && r <= right) {
            // �����ߵ��� �� �ұߵĴ�
            if (arr[l] > arr[r]) {
                temp[t] = arr[r];
                r++;
            }
            // ��֮
            else {
                temp[t] = arr[l];
                l++;
            }
            t++;
        }

        // 3��Ȼ�������һ�ߵ�ʣ������ȫ�������� temp
        // ��������������黹������δ�ϲ�
        while (l <= mid) {
            temp[t] = arr[l];
            l++;
            t++;
        }
        // �����ұ��������黹������δ�ϲ�
        while (r <= right) {
            temp[t] = arr[r];
            r++;
            t++;
        }

        // 4������ٰ� temp �Ľ�� ������ ԭ���鼴��
        // ע�⣺������ÿһ�ζ���Ҫ�������е�temp����Ϊֻ����������ǿ������У����඼�ǲ��ֿ���
        t = 0;
        int tempLeft = left;
        //��һ�κϲ� end = 0 , right = 1 //  end = 2  right = 3 // end = 0 right = 3
        //���һ�� end = 0  right = 7
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }

}
