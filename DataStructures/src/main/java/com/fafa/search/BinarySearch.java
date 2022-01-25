package com.fafa.search;

import java.util.ArrayList;
import java.util.List;

/**
 * ���ֲ���(����һ��Ҫ�������)
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-18 14:32
 */
public class BinarySearch {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 8, 8, 8, 8, 8, 8, 9, 10, 89, 1000, 1234};
        int[] arr = {1, 9, 10, 89, 1000, 1000, 1234};
        int target = 1000;
        // ����һ
       /* int res = binarySearch01(arr, 0, arr.length - 1, target);
        System.out.println("res = " + res);*/

        // ������
        List<Integer> list = binarySearch02(arr, 0, arr.length - 1, target);
        System.out.println("list = " + list.toString());

    }

    /**
     * ���ֲ��һ���������ֻ���ҵ�һ����
     * �ݹ鷨
     * ˼·��
     * 1���ȼ�����м���±꣬�������м��±��Ӧ������
     * 2��Ȼ��ݹ���ң����Ŀ����м�ֵС����ô����ݹ飬��֮�����ҵݹ�
     * 3������ҵ��������±꣬δ�ҵ�������ݹ飬ֱ�� left > right Ϊֹ
     *
     * @param arr
     * @param left
     * @param right
     * @param target
     * @return
     */
    public static int binarySearch01(int[] arr, int left, int right, int target) {
        // �ݹ�ͷ��������־��
        if (left > right) {
            return -1;
        }
        // ��ֵ�±�
        int midIndex = (left + right) / 2;
        // ��ֵ
        int midVal = arr[midIndex];

        // ����ݹ�
        if (target < midVal) {
            return binarySearch01(arr, left, midIndex - 1, target);
        }
        // ���ҵݹ�
        else if (target > midVal) {
            return binarySearch01(arr, midIndex + 1, right, target);
        }
        // �ҵ�Ŀ��
        else {
            return midIndex;
        }
    }

    /**
     * ���ֲ��һ��������������ҵ������
     * �ݹ鷨
     * ˼·��
     * 1�����յ�Ŀ��󣬲�Ҫ���Ϸ��أ�������ɨ������ߵģ���Ϊ������ģ�
     * 2�������ߵ��±�С��0 ���� ������Ŀ��ֵ�ˣ���ֱ�ӽ����������ҵ��±���ӵ�������
     * 3�����Ŀ����±�
     * 4��ɨ��Ŀ�������Ԫ�أ���������ߵ�����
     * 5��ȫ��ɨ�꣬���ؼ���
     *
     * @param arr
     * @param left
     * @param right
     * @param target
     * @return
     */
    public static List<Integer> binarySearch02(int[] arr, int left, int right, int target) {
        // �ݹ�ͷ��������־��
        if (left > right) {
            return new ArrayList<Integer>();
        }
        // ��ֵ�±�
        int midIndex = (left + right) / 2;
        // ��ֵ
        int midVal = arr[midIndex];

        // ����ݹ�
        if (target < midVal) {
            return binarySearch02(arr, left, midIndex - 1, target);
        }
        // ���ҵݹ�
        else if (target > midVal) {
            return binarySearch02(arr, midIndex + 1, right, target);
        }
        // �ҵ�Ŀ��
        else {
            // �±꼯�ϣ����ڽ��ܶ��Ŀ��Ԫ�ص��±꣩
            List<Integer> list = new ArrayList<Integer>();
            // ���ڱ����±�
            int listIndex = midIndex - 1;
            // ��ɨ����ߵ�
            while (listIndex >= left) {
                if (arr[listIndex] == midVal) {
                    list.add(listIndex);
                    listIndex--;
                } else {
                    break;
                }
            }
            list.add(midIndex);
            // ɨ���ұ�
            listIndex = midIndex + 1;
            while (listIndex <= right) {
                if (arr[listIndex] == midVal) {
                    list.add(listIndex);
                    listIndex++;
                } else {
                    break;
                }
            }
            return list;
        }
    }
}
