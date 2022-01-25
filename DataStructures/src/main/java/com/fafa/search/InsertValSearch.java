package com.fafa.search;

/**
 * ��ֵ����
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-18 21:51
 */
public class InsertValSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        // ����100�������Ĳ������飨1-100��
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        int target = 66;
        // ���ò�ֵ����
        int search = insertValSearch(arr, 0, arr.length - 1, target);
        System.out.println("��ֵ���ҽ����" + search);

    }

    /**
     * ��ֵ����
     * ��˼·����ֲ��Һ�����
     * ��֮ͬ���ǣ� ��λmidIndex�Ĺ�ʽ��ͬ������Ӧ���㷨��
     * �㷨��ʽ�ǣ� int midIndex = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
     *
     * @param arr
     * @param left
     * @param right
     * @param target
     * @return
     */
    public static int insertValSearch(int[] arr, int left, int right, int target) {
        System.out.println("insertValSearch������~");
        // ��������������Ҫ��target�ĺϷ��Խ���У�飬��Ϊ����Ӧ��ʽ�õ���targetֵ�����Ա���Ҫ��У�飩
        if (left > right || target < arr[left] || target > arr[right]) {
            return -1;
        }
        // ����Ӧ��ʽ
        int midIndex = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[midIndex];
        if (target > midVal) {
            return insertValSearch(arr, midIndex + 1, right, target);
        } else if (target < midVal) {
            return insertValSearch(arr, left, midIndex - 1, target);
        } else {
            return midIndex;
        }
    }
}
