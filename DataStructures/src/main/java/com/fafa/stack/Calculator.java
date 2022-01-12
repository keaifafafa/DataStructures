package com.fafa.stack;

/**
 * 基于栈实现的计算器
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-05 18:14
 */
public class Calculator {
    public static void main(String[] args) {
        // 根据刚才的思路，完成表达式的运算
        String expression = "1000+2*6-205+8/4";
        // 创建两个栈，一个数字栈，一个符号栈
        ArrayStack2 numStack = new ArrayStack2(5);
        ArrayStack2 oprStack = new ArrayStack2(5);
        // 循环遍历的下标索引
        int index = 0;
        int nums1 = 0;
        int nums2 = 0;
        // 用于多位数拼接
        String keepNums = "";
        // 第一遍先把高优先级的运算完
        while (true) {
            // 截取字符串
            String s = expression.substring(index, index + 1);
            char ch = ' ';
            // 如果是操作字符（+、-、*、/）
            if (oprStack.isOperate(s.charAt(0))) {
                ch = s.charAt(0);
                // 如果符号栈为空
                if (oprStack.isEmpty()) {
                    oprStack.push(ch);
                }
                // 如果ch 大于等于 栈内运算符的优先级
                else if (oprStack.priority(ch) <= oprStack.priority((char) oprStack.peek())) {
                    nums1 = numStack.pop();
                    nums2 = numStack.pop();
                    char pop = (char) oprStack.pop();
                    int res = numStack.calResult(nums1, nums2, pop);
                    // 将结果 入栈（数字栈）
                    numStack.push(res);
                    oprStack.push(ch);
                } else {
                    oprStack.push(ch);
                }
            }
            // 如果是数字,直接进数栈
            else {
                /**
                 * 思路分析
                 * 1、 处理多位数，应观察其后面一位是不是为运算符，如果不是，则需要追加
                 * 2、 如果后面一位是运算符，则直接入栈，入完栈后，记得将keepNums设置为空
                 * 3、 需要特殊考虑下最后一个元素，因为他没有下一个，所以可以直接入栈
                 */
                // 拼接多位数
                keepNums += s;
                // 如果当前为最后一位
                if (index == expression.length() - 1) {
                    // 将字符转成整形（数字）
                    int num = Integer.parseInt(keepNums);
                    numStack.push(num);
                } else {
                    // 往下看一位，看是否为运算符
                    if (oprStack.isOperate(expression.substring(index + 1, index + 2).charAt(0))) {
                        // 将字符转成整形（数字）
                        int num = Integer.parseInt(keepNums);
                        numStack.push(num);
                        // 设为空
                        keepNums = "";
                    }
                }

            }
            // 后移
            index++;
            // 如果下标大于等于表达式的长度，则循环结束
            if (index >= expression.length()) {
                break;
            }

        }
        // 第二遍把剩余数字运算完，并获得结果
        while (true) {
            // 只要符号栈没空，那就可以继续运算
            if (!oprStack.isEmpty()) {
                nums1 = numStack.pop();
                nums2 = numStack.pop();
                char pop = (char) oprStack.pop();
                int res = numStack.calResult(nums1, nums2, pop);
                // 将结果入栈
                numStack.push(res);

            } else {
                break;
            }
        }
        System.out.printf("%s = %d", expression, numStack.peek());
    }
}

/**
 * 数组栈
 */
class ArrayStack2 {
    /**
     * 栈的最大容量
     */
    private int maxSize;
    /**
     * 数组
     */
    private int[] stack;
    /**
     * 栈顶,初始化为-1，表示栈为空
     */
    private int top = -1;

    /**
     * 初始化
     */
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 获取栈顶元素
     */
    public int peek() {
        return stack[top];
    }

    /**
     * 判断栈满
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 栈空
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈
     */
    public void push(int value) {
        // 判断栈是否已满
        if (isFull()) {
            System.out.println("栈满，无法入栈");
            return;
        }
        top++;
        // 添加到数组
        stack[top] = value;
        System.out.println(value + "成功入栈");
    }

    /**
     * 出栈
     */
    public int pop() {
        // 判断栈是否为空
        if (isEmpty()) {
            throw new RuntimeException("栈空，无法出栈");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 遍历数组内元素
     */
    public void getAll() {
        if (isEmpty()) {
            System.out.println("空栈，无数据！");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 元素优先级判断
     * 使用数字大小作为比较
     */
    public int priority(char operate) {
        if (operate == '*' || operate == '/') {
            return 1;
        } else if (operate == '+' || operate == '-') {
            return 0;
        } else {
            // 目前只考虑 加减乘除
            return -1;
        }
    }

    /**
     * 判断是否为有效操作符
     */
    public boolean isOperate(char opr) {
        // 如果是加减乘除则为true
        if (opr == '*' || opr == '-' || opr == '/' || opr == '+') {
            return true;
        }
        return false;
    }

    /**
     * 计算结果
     *
     * @param num1
     * @param num2
     * @param operate 操作符
     * @return
     */
    public int calResult(int num1, int num2, char operate) {
        int res = 0;
        // 条件判断
        switch (operate) {
            case '*':
                res = num1 * num2;
                break;
            case '+':
                res = num1 + num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            case '-':
                res = num2 - num1;
                break;
        }
        return res;
    }
}

