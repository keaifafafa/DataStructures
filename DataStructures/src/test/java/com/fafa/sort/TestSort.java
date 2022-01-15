package com.fafa.sort;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

/**
 * ���Ը��������㷨���ٶ�
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-11 21:38
 */
public class TestSort {

    /**
     * ����ð������Ч��
     * ����һ��ð�ݵ��ٶ� O(n^2),��8W�����ݣ�����
     */
    @Test
    public void testBubble() {
        // ����
        int capacity = 80000;
        // ���� 8W ����������
        int[] arr = new int[capacity];
        // ��ʼ������
        for (int i = 0; i < capacity; i++) {
            // ���������
            arr[i] = (int) (Math.random() * capacity);
        }
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // ��ʼʱ��
        String start = sd.format(new Date());
        System.out.println("����ǰ��ʱ��" + start);
        BubbleSort.sort(arr);
        String end = sd.format(new Date());
        System.out.println("������ʱ��" + end);
    }

    /**
     * ����ѡ�������Ч��
     */
    @Test
    public void testSelect() {
        // ����
        int capacity = 80000;
        // ���� 8W ����������
        int[] arr = new int[capacity];
        // ��ʼ������
        for (int i = 0; i < capacity; i++) {
            // ���������
            arr[i] = (int) (Math.random() * capacity);
        }
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // ��ʼʱ��
        String start = sd.format(new Date());
        System.out.println("����ǰ��ʱ��" + start);
        // �Ż����ѡ������
        SelectSort.selectSort(arr);
        // δ�Ż���ѡ������
//        SelectSort.selectSort2(arr);
        String end = sd.format(new Date());
        System.out.println("������ʱ��" + end);
    }

    /**
     * ���Բ�������
     */
    @Test
    public void testInsert() {
        // ����
        int capacity = 80000;
        // ���� 8W ����������
        int[] arr = new int[capacity];
        // ��ʼ������
        for (int i = 0; i < capacity; i++) {
            // ���������
            arr[i] = (int) (Math.random() * (capacity * 100));
        }
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // ��ʼʱ��
        String start = sd.format(new Date());
        System.out.println("����ǰ��ʱ��" + start);
        // ��������
        InsertSort.insertSort(arr);
        String end = sd.format(new Date());
        System.out.println("������ʱ��" + end);
//        System.out.println(Arrays.toString(arr));
    }

    /**
     * ����ͨ��������ʵ�ֵ�ϣ������
     */
    @Test
    public void testShellBySwap() {
        // ����
        int capacity = 80000;
        // ���� 8W ����������
        int[] arr = new int[capacity];
        // ��ʼ������
        for (int i = 0; i < capacity; i++) {
            // ���������
            arr[i] = (int) (Math.random() * (capacity * 100));
        }
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // ��ʼʱ��
        String start = sd.format(new Date());
        System.out.println("����ǰ��ʱ��" + start);
        // ϣ�����򣨽�������
        ShellSort.shellSortBySwap2(arr);
        String end = sd.format(new Date());
        System.out.println("������ʱ��" + end);
    }

    /**
     * ����ͨ����λ��ʵ�ֵ�ϣ������
     */
    @Test
    public void testShellByShift() {
        // ����
        int capacity = 8000000;
        // ���� 8W ����������
        int[] arr = new int[capacity];
        // ��ʼ������
        for (int i = 0; i < capacity; i++) {
            // ���������
            arr[i] = (int) (Math.random() * (capacity * 100));
        }
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // ��ʼʱ��
        String start = sd.format(new Date());
        System.out.println("����ǰ��ʱ��" + start);
        // ϣ��������λ����
        ShellSort.shellSortByShift(arr);
        String end = sd.format(new Date());
        System.out.println("������ʱ��" + end);
    }

    /**
     * ���Կ�������(�ÿռ任ʱ��)
     */
    @Test
    public void testQuick() {
        // ����
        int capacity = 8000000;
        // ���� 8W ����������
        int[] arr = new int[capacity];
        // ��ʼ������
        for (int i = 0; i < capacity; i++) {
            // ���������
            arr[i] = (int) (Math.random() * (capacity * 100));
        }
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // ��ʼʱ��
        String start = sd.format(new Date());
        System.out.println("����ǰ��ʱ��" + start);
        // ��������
        QuickSort.quickSort(arr, 0, arr.length - 1);
        String end = sd.format(new Date());
        System.out.println("������ʱ��" + end);
//        System.out.println(Arrays.toString(arr));
    }

    /**
     * ���Թ鲢������ٶ�
     */
    @Test
    public void testMerge() {
        // ����
        int capacity = 8000000;
        // ���� 8W ����������
        int[] arr = new int[capacity];
        // �鲢�������ռ�
        int[] temp = new int[capacity];
        // ��ʼ������
        for (int i = 0; i < capacity; i++) {
            // ���������
            arr[i] = (int) (Math.random() * (capacity * 100));
        }
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // ��ʼʱ��
        String start = sd.format(new Date());
        System.out.println("����ǰ��ʱ��" + start);
        // �鲢����
        MergeSort.mergeSort(arr, 0, arr.length - 1, temp);
        String end = sd.format(new Date());
        System.out.println("������ʱ��" + end);
//        System.out.println(Arrays.toString(arr));
    }

}
