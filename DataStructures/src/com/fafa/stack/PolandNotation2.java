package com.fafa.stack;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ��׺���ʽת��׺���ʽ
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-06 16:03
 */
public class PolandNotation2 {
    public static void main(String[] args) {
        /**
         * ˼·��
         * 1������׺���ʽת�ɶ�Ӧ��list  �� 1+((2+3)*4)-5   =>   [1,+,(,(,2,+,3,),*,4,-,5]
         * 2�����ĵõ�����׺���ʽlist תΪ ��׺���ʽ  �� [1,+,(,(,2,+,3,),*,4,-,5]  => 1 2 3 + 4 * + 5 -
         */
        String expression = "1+((2+3)*4)-5";
        // ����׺���ʽ��ʽ��
        List<String> stringList = toInfixExpression(expression);
        System.out.println(stringList);
        // ��׺ת��׺
        List<String> parseSuffixExpressionList = parseSuffixExpressionList(stringList);
        System.out.println("��׺���ʽ = " + parseSuffixExpressionList);
        // ������
        int res = calculate(parseSuffixExpressionList);
        System.out.printf("%s = %d",parseSuffixExpressionList,res);

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

    /**
     * �ж��ǲ��ǲ�����
     */
    public static boolean isNum(String s) {
        // ���ֵ�ASCII������Ϊ��[48,57]
        if (s.charAt(0) >= 48 && s.charAt(0) <= 57) {
            return true;
        }
        return false;
    }

    /**
     * ����׺���ʽת�ɶ�Ӧ��list
     * ���磺  1+((2+3)*4)-5   =>   [1,+,(,(,2,+,3,),*,4,-,5]
     */
    public static List<String> toInfixExpression(String expression) {
        List<String> list = new ArrayList<String>();
        // ���ڶ�λ��ƴ��
        String keepNums = "";
        for (int i = 0; i < expression.length(); i++) {
            String s = expression.substring(i, i + 1);
            // ����������
            if (!isNum(s)) {
                list.add(s);
            }
            // ���������
            else {
                keepNums += s;
                // ������������һλ
                if (i == expression.length() - 1) {
                    list.add(keepNums);
                } else {
                    // ����һλ�Ƿ�Ϊ�����
                    if (!isNum(expression.substring(i + 1, i + 2))) {
                        list.add(keepNums);
                        // ��Ϊ0
                        keepNums = "";
                    }
                }
            }
        }
        return list;
    }

    /**
     * ��׺ת��׺
     *
     * @return
     */
    public static List<String> parseSuffixExpressionList(List<String> infixExpression) {
        // ��������ջ (һ�������������ģ�����һ��ջ��һ�����ϸ�Ϊ�����Ч)
        // s1������ջ
        Stack<String> s1 = new Stack<>();
        // s2���洢�м����ļ��ϣ�Ϊʲô����ջ�أ���Ϊs2û��pop���������ҽ���������Ҫ�����ӡ�������ü��ϸ����ʣ�
        List<String> s2 = new ArrayList<String>();
        // ������ɨ����ʽ
        for (int i = 0; i < infixExpression.size(); i++) {
            String cur = infixExpression.get(i);
            // ���������ֱ�ӽ���s2
            if (isNum(cur)) {
                s2.add(cur);
            }
            // �������������
            else if (cur.equals("(")){
                s1.push(cur);
            }
            // �������������
            else if (cur.equals(")")){
                // ���ε���s1��������������뵽s2
                while (!s1.peek().equals("(")){
                    String pop = s1.pop();
                    s2.add(pop);
                }
                // �������ŵ���
                s1.pop();
            }
            // ���������
            else {
                // ��s1ջ������������������뵽s2�У��ٴ�ת��(4.1)��s1���µ�ջ���������Ƚ�
                while (s1.size() != 0 && Operation.priority(s1.peek().charAt(0)) >= Operation.priority(cur.charAt(0))){
                    String temp = s1.pop();
                    s2.add(temp);
                }
                // ��curѹ��s1
                s1.push(cur);
            }
        }
        // ��s1ʣ��Ԫ�ؼ���s2
        while (s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;
    }
}

/**
 * ������
 */
class Operation {
    /**
     * ��
     */
    private static int ADD = 1;
    /**
     * ��
     */
    private static int SUB = 1;
    /**
     * ��
     */
    private static int MUL = 2;
    /**
     * ��
     */
    private static int DIV = 2;

    /**
     * ���Է�������������ȼ�
     * @param ch
     * @return
     */
    public static int priority(char ch) {
        int rank = 0;
        switch (ch) {
            case '+':
                rank =  ADD;
                break;
            case '-':
                rank =  SUB;
                break;
            case '*':
                rank =  MUL;
                break;
            case '/':
                rank =  DIV;
                break;
            default:
                break;
        }
        return rank;
    }

}
