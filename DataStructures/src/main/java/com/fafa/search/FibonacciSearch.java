package com.fafa.search;

import java.util.Arrays;

/**
 * 쳲���������
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-19 18:11
 */
public class FibonacciSearch {
    /**
     * �������
     */
    private static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 189, 1000, 1234};
        System.out.println("index = " + fibSearch(arr, 1234));
    }

    /**
     * ����쳲���������
     *
     * @return
     */
    public static int[] fibonacci() {
        int[] nums = new int[maxSize];
        for (int i = 0; i < maxSize; i++) {
            if (i == 0 || i == 1) {
                nums[i] = 1;
            } else {
                nums[i] = nums[i - 1] + nums[i - 2];
            }
        }
        return nums;
    }

    /**
     * 쳲��������ң���������
     *
     * @param arr ����
     * @param key ������Ҫ���ҵĹؼ�ֵ
     * @return ���ض�Ӧ���±꣬���û�У����� -1
     */
    public static int fibSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        // ���midֵ
        int mid = 0;
        // ����쳲�����������
        int[] f = fibonacci();
        // ��ʾ쳲�������ֵ���±�
        int k = 0;
        // ��ȡ쳲������ָ���ֵ���±ֻ꣨Ҫ˳�����Ϊ f[k] - 1 �� ������ʹ��mid��ʽ��
        while (high > f[k] - 1) {
            k++;
        }
        // ��Ϊ f[k] ֵ ���ܴ��� a �� ���ȣ����������Ҫʹ��Arrays�࣬����һ���µ����飬��ָ��temp[]
        // ����Ĳ��ֻ�ʹ��0���
        int[] temp = Arrays.copyOf(arr, f[k]);
        //ʵ��������ʹ��a������������� temp
        //����:
        //temp = {1,8, 10, 89, 1000, 1234, 0, 0}  => {1,8, 10, 89, 1000, 1234, 1234, 1234,}
        for (int i = k; i < temp.length; i++) {
            temp[i] = arr[high];
        }

        while (low <= high) {
            mid = low + f[k - 1] - 1;
            // ��Ҫ������ǰ�ң��������Ϊ����
            if (key < temp[mid]) {
                high = mid - 1;
                // ע�⣺����Ϊʲô��k--;
                // 1��ȫ��Ԫ�� = ǰ��Ԫ�� + ����Ԫ��
                // 2��f[k] = f[k -1] + f[k - 2];
                // ��Ϊ ǰ���� f[k - 1]��Ԫ��,���Կ��Լ������ f[k - 1] = f[k - 2] + f[k - 3]
                // �� �� f[k - 1] ��ǰ��������� k--
                // ���´�ѭ�� mid = f[k - 1 - 1] - 1
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                //Ϊʲô��k -=2
                //˵��
                //1. ȫ��Ԫ�� = ǰ���Ԫ�� + ���Ԫ��
                //2. f[k] = f[k - 1] + f[k - 2]
                //3. ��Ϊ����������f[k - 2] ���Կ��Լ������ f[k - 2] = f[k-3] + f[k-4]
                //4. ����f[k - 2] ��ǰ����в��� k -= 2
                //5. ���´�ѭ�� mid = f[k - 1 - 2] - 1
                k -= 2;
            } else {
                // Ҫ���رȽ�С��һ������Ϊmid�����ܻ�ָ�����ݵĵ�ַ��
                return mid = mid <= high ? mid : high;
            }
        }
        return -1;
    }

}
