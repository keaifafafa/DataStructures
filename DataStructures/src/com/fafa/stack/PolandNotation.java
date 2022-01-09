package com.fafa.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * �沨������������׺���ʽ��
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-06 16:03
 */
public class PolandNotation {
    public static void main(String[] args) {
        // �ȶ���һ���沨�����ʽ
        // (3+4)*5-6   => 3 4 + 5 * 6 -
        // (30+4)*5-6   => 3 4 + 5 * 6 -
        // 4 * 5 - 8 + 60 + 8 / 2   =>  4 5 * 8 - 60 + 8 2 / +
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        List<String> list = getListString(suffixExpression);
        System.out.println("list = " + list);
        System.out.printf("%s = %d", suffixExpression, calculate(list));
    }

    /**
     * �����ʽ�ָ����List������
     */
    public static List<String> getListString(String suffixExpression) {
        List<String> list = new ArrayList<>();
        String[] s = suffixExpression.split(" ");
        for (String ele : s) {
            list.add(ele);
        }
        return list;
    }

    /**
     * ������ʽ�Ľ��
     */
    public static int calculate(List<String> list) {
        Stack<Integer> stack = new Stack<Integer>();
        int num1 = 0, num2 = 0, res = 0;
        for (String ele : list) {
            // ������֣���������ʽƥ��  \d+ ��ʾ�Ƕ�λ����
            if (ele.matches("\\d+")) {
                stack.push(Integer.parseInt(ele));
            }
            // ���Ϊ������
            else {
                num1 = stack.pop();
                num2 = stack.pop();
                res = calResult(num1, num2, ele);
                stack.push(res);
            }

        }
        return res;
    }

    /**
     * ������
     *
     * @param num1
     * @param num2
     * @param operate ������
     * @return
     */
    public static int calResult(int num1, int num2, String operate) {
        int res = 0;
        // �����ж�
        switch (operate) {
            case "*":
                res = num1 * num2;
                break;
            case "+":
                res = num1 + num2;
                break;
            case "/":
                res = num2 / num1;
                break;
            case "-":
                res = num2 - num1;
                break;
            default:
                throw new RuntimeException("����������");
        }
        return res;
    }
}
