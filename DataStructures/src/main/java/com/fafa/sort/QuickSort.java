package com.fafa.sort;

import java.util.Arrays;

/**
 * ��������
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-14 18:16
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {-9, 78, 1, 0, 0, -3, 23, -567, 70, -10, 99, 108, 4, -55};
//        int[] arr = {-9, 78, 1, -92, 0, -3, 23, -567, 70};
//        int[] arr = {-9, 78, 1, 0, 0, -3, 23, -567, 70};
        int[] arr = {3, -1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * ��������ʵ�֣��ÿռ任ʱ�䣩
     *
     * @param arr
     */
    public static void quickSort(int[] arr, int left, int right) {
        // ������
        int l = left;
        // ������
        int r = right;
        // ����ֵ
        int pivot = arr[(l + r) / 2];
        int temp = 0;
        // ��ʵwhileѭ�������� l == r
        while (l < r) {
            // Ѱ����߱� ����ֵ���
            while (arr[l] < pivot) {
                l++;
            }
            // Ѱ���ұ߱� ����ֵС��
            while (arr[r] > pivot) {
                r--;
            }
            // ��� l >= r,˵��pivot���������ߵ�ֵ���Ѿ��������ȫ����С�ڵ���pivotֵ���ұ�ȫ���Ǵ��ڵ���pivot��ֵ
            // ��һ�����ӵĻ�������ĵݹ��ջ���
            // ���� l == r ���������Ϊ���滹������if��䣨�� l �� r�������ã�
            if (l == r) {
                break;
            }
            // ����
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // ���arr[l] == pivot�Ļ�,ֱ�� r--�����䲻���� l < r ��������ֱ������ѭ����������
            if (arr[l] == pivot) {
                r--;
            }
            // ���arr[r] == pivot�Ļ�,ֱ�� l++�����䲻���� l < r ��������ֱ������ѭ����������
            if (arr[r] == pivot) {
                l++;
            }
        }
        // ���������ǵݹ������
        // ��� l == r�������Ǹ���ѭ����ջ���Stack Overflow��������͵����Ӿ��� l �� r ���� pivot ��λ��
        if (l == r) {
            // ��ָ������һ��
            l++;
            // ��ָ������һ��
            r--;
        }
        // ����ݹ飨��Ϊ��ָ�뻹δ������ߣ�
        if (left < r) {
            quickSort(arr, left, r);
        }
        // �ҵݹ� (ͬ��)
        if (right > l) {
            quickSort(arr, l, right);
        }

    }
}
