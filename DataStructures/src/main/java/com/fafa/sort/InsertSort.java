package com.fafa.sort;

import java.util.Arrays;

/**
 * ��������
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-13 10:45
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        insertSort(arr);
        System.out.println("���������" + Arrays.toString(arr));
    }

    /**
     * ��������
     * ˼·��
     * 1���Ȱѵ�һ��Ԫ�ص��������
     * 2��Ȼ�����ν��жԱȣ���ǰ���Ԫ�أ��������ǰ����Ԫ�ر�ǰ���Ԫ��С�� ������Ԫ��λ�õ�ֵ���ǰ��Ԫ�ص�ֵ
     * 3��whileѭ��������Ҳ�����ҵ��˲���λ�ã��ٰѸ�λ�õ�ֵ��� insertVal
     */
    public static void insertSort(int[] arr) {
        // ��Ҫ�����ֵ
        int insertVal = 0;
        // ����λ�õ�ǰһ���±�
        int insertIndex = 0;
        // ��Ϊ��һ���������,���� i = 1
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            // ��ʼ�������в���Ŀ��λ��
            while(insertIndex >= 0 && insertVal < arr[insertIndex]){
                // �൱�ڰ�Ԫ�غ���
                arr[insertIndex + 1] = arr[insertIndex];
                // ������ǰ
                insertIndex--;
            }
            // ������ȷ��λ�ã��������Լ��ٲ���Ҫ�ĸ�ֵ����Ϊ�п����Ѿ����������ڽ��в�����
            if (insertIndex != i - 1){
                // ������������λ�� ���� ����
                arr[insertIndex + 1] = insertVal;
            }
        }
    }
}
