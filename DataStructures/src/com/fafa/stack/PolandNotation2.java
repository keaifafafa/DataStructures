package com.fafa.stack;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中缀表达式转后缀表达式
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-06 16:03
 */
public class PolandNotation2 {
    public static void main(String[] args) {
        /**
         * 思路：
         * 1、将中缀表达式转成对应的list  即 1+((2+3)*4)-5   =>   [1,+,(,(,2,+,3,),*,4,-,5]
         * 2、将的得到的中缀表达式list 转为 后缀表达式  即 [1,+,(,(,2,+,3,),*,4,-,5]  => 1 2 3 + 4 * + 5 -
         */
        String expression = "1+((2+3)*4)-5";
        // 将中缀表达式格式化
        List<String> stringList = toInfixExpression(expression);
        System.out.println(stringList);
        // 中缀转后缀
        List<String> parseSuffixExpressionList = parseSuffixExpressionList(stringList);
        System.out.println("后缀表达式 = " + parseSuffixExpressionList);
        // 计算结果
        int res = calculate(parseSuffixExpressionList);
        System.out.printf("%s = %d",parseSuffixExpressionList,res);

    }


    /**
     * 将表达式分割存入List集合中
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
     * 计算表达式的结果
     */
    public static int calculate(List<String> list) {
        Stack<Integer> stack = new Stack<Integer>();
        int num1 = 0, num2 = 0, res = 0;
        for (String ele : list) {
            // 如果数字，用正则表达式匹配  \d+ 表示是多位整数
            if (ele.matches("\\d+")) {
                stack.push(Integer.parseInt(ele));
            }
            // 如果为操作符
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
     * 计算结果
     *
     * @param num1
     * @param num2
     * @param operate 操作符
     * @return
     */
    public static int calResult(int num1, int num2, String operate) {
        int res = 0;
        // 条件判断
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
                throw new RuntimeException("操作符有误");
        }
        return res;
    }

    /**
     * 判断是不是操作符
     */
    public static boolean isNum(String s) {
        // 数字的ASCII码区间为：[48,57]
        if (s.charAt(0) >= 48 && s.charAt(0) <= 57) {
            return true;
        }
        return false;
    }

    /**
     * 将中缀表达式转成对应的list
     * 例如：  1+((2+3)*4)-5   =>   [1,+,(,(,2,+,3,),*,4,-,5]
     */
    public static List<String> toInfixExpression(String expression) {
        List<String> list = new ArrayList<String>();
        // 用于多位数拼接
        String keepNums = "";
        for (int i = 0; i < expression.length(); i++) {
            String s = expression.substring(i, i + 1);
            // 如果是运算符
            if (!isNum(s)) {
                list.add(s);
            }
            // 如果是数字
            else {
                keepNums += s;
                // 如果是数组最后一位
                if (i == expression.length() - 1) {
                    list.add(keepNums);
                } else {
                    // 看下一位是否为运算符
                    if (!isNum(expression.substring(i + 1, i + 2))) {
                        list.add(keepNums);
                        // 置为0
                        keepNums = "";
                    }
                }
            }
        }
        return list;
    }

    /**
     * 中缀转后缀
     *
     * @return
     */
    public static List<String> parseSuffixExpressionList(List<String> infixExpression) {
        // 定义两个栈 (一般书上是这样的，但是一个栈加一个集合更为方便高效)
        // s1：符号栈
        Stack<String> s1 = new Stack<>();
        // s2：存储中间结果的集合（为什么不用栈呢，因为s2没有pop操作，而且接下来还需要逆序打印，所以用集合更合适）
        List<String> s2 = new ArrayList<String>();
        // 从左到右扫描表达式
        for (int i = 0; i < infixExpression.size(); i++) {
            String cur = infixExpression.get(i);
            // 如果是数字直接进入s2
            if (isNum(cur)) {
                s2.add(cur);
            }
            // 如果遇到左括号
            else if (cur.equals("(")){
                s1.push(cur);
            }
            // 如果遇到有括号
            else if (cur.equals(")")){
                // 依次弹出s1的运算符，并加入到s2
                while (!s1.peek().equals("(")){
                    String pop = s1.pop();
                    s2.add(pop);
                }
                // 将左括号弹出
                s1.pop();
            }
            // 遇到运算符
            else {
                // 将s1栈顶的运算符弹出并加入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较
                while (s1.size() != 0 && Operation.priority(s1.peek().charAt(0)) >= Operation.priority(cur.charAt(0))){
                    String temp = s1.pop();
                    s2.add(temp);
                }
                // 将cur压入s1
                s1.push(cur);
            }
        }
        // 将s1剩余元素加入s2
        while (s1.size() != 0){
            s2.add(s1.pop());
        }
        return s2;
    }
}

/**
 * 操作符
 */
class Operation {
    /**
     * 加
     */
    private static int ADD = 1;
    /**
     * 减
     */
    private static int SUB = 1;
    /**
     * 乘
     */
    private static int MUL = 2;
    /**
     * 除
     */
    private static int DIV = 2;

    /**
     * 可以返回运算符的优先级
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
