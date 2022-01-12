package com.fafa.sort.test;

import com.fafa.sort.BubbleSort;
import com.fafa.sort.SelectSort;
import org.junit.Test;

import java.text.SimpleDateFormat;
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

    @Test
    public void testHash() {
        HashSet<Integer> hashSet = new HashSet<>();
        Integer i = 10;
        hashSet.add(i);
        hashSet.contains(i);
    }


}
