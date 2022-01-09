package com.fafa.recurison;

/**
 * �ݹ����
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-08 13:54
 */
public class RecursionTest {
    public static void main(String[] args) {
        test(4);
//        System.out.println(factorial(5));
//        System.out.println(fab(7));
    }

    /**
     * ���Եݹ��ӡ����
     *
     * @param n
     */
    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n = " + n);
    }

    /**
     * �׳�����
     */
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }

    /**
     * �Ʋ���������
     * 1 1 2 3 5 8 13
     */
    public static int fab(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }else {
            return fab(n -2) + fab(n -1);
        }
    }
}
