package com.fafa.stack;

/**
 * ����ջʵ�ֵļ�����
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-05 18:14
 */
public class Calculator {
    public static void main(String[] args) {
        // ���ݸղŵ�˼·����ɱ��ʽ������
        String expression = "1000+2*6-205+8/4";
        // ��������ջ��һ������ջ��һ������ջ
        ArrayStack2 numStack = new ArrayStack2(5);
        ArrayStack2 oprStack = new ArrayStack2(5);
        // ѭ���������±�����
        int index = 0;
        int nums1 = 0;
        int nums2 = 0;
        // ���ڶ�λ��ƴ��
        String keepNums = "";
        // ��һ���ȰѸ����ȼ���������
        while (true) {
            // ��ȡ�ַ���
            String s = expression.substring(index, index + 1);
            char ch = ' ';
            // ����ǲ����ַ���+��-��*��/��
            if (oprStack.isOperate(s.charAt(0))) {
                ch = s.charAt(0);
                // �������ջΪ��
                if (oprStack.isEmpty()) {
                    oprStack.push(ch);
                }
                // ���ch ���ڵ��� ջ������������ȼ�
                else if (oprStack.priority(ch) <= oprStack.priority((char) oprStack.peek())) {
                    nums1 = numStack.pop();
                    nums2 = numStack.pop();
                    char pop = (char) oprStack.pop();
                    int res = numStack.calResult(nums1, nums2, pop);
                    // ����� ��ջ������ջ��
                    numStack.push(res);
                    oprStack.push(ch);
                } else {
                    oprStack.push(ch);
                }
            }
            // ���������,ֱ�ӽ���ջ
            else {
                /**
                 * ˼·����
                 * 1�� �����λ����Ӧ�۲������һλ�ǲ���Ϊ�������������ǣ�����Ҫ׷��
                 * 2�� �������һλ�����������ֱ����ջ������ջ�󣬼ǵý�keepNums����Ϊ��
                 * 3�� ��Ҫ���⿼�������һ��Ԫ�أ���Ϊ��û����һ�������Կ���ֱ����ջ
                 */
                // ƴ�Ӷ�λ��
                keepNums += s;
                // �����ǰΪ���һλ
                if (index == expression.length() - 1) {
                    // ���ַ�ת�����Σ����֣�
                    int num = Integer.parseInt(keepNums);
                    numStack.push(num);
                } else {
                    // ���¿�һλ�����Ƿ�Ϊ�����
                    if (oprStack.isOperate(expression.substring(index + 1, index + 2).charAt(0))) {
                        // ���ַ�ת�����Σ����֣�
                        int num = Integer.parseInt(keepNums);
                        numStack.push(num);
                        // ��Ϊ��
                        keepNums = "";
                    }
                }

            }
            // ����
            index++;
            // ����±���ڵ��ڱ��ʽ�ĳ��ȣ���ѭ������
            if (index >= expression.length()) {
                break;
            }

        }
        // �ڶ����ʣ�����������꣬����ý��
        while (true) {
            // ֻҪ����ջû�գ��ǾͿ��Լ�������
            if (!oprStack.isEmpty()) {
                nums1 = numStack.pop();
                nums2 = numStack.pop();
                char pop = (char) oprStack.pop();
                int res = numStack.calResult(nums1, nums2, pop);
                // �������ջ
                numStack.push(res);

            } else {
                break;
            }
        }
        System.out.printf("%s = %d", expression, numStack.peek());
    }
}

/**
 * ����ջ
 */
class ArrayStack2 {
    /**
     * ջ���������
     */
    private int maxSize;
    /**
     * ����
     */
    private int[] stack;
    /**
     * ջ��,��ʼ��Ϊ-1����ʾջΪ��
     */
    private int top = -1;

    /**
     * ��ʼ��
     */
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * ��ȡջ��Ԫ��
     */
    public int peek() {
        return stack[top];
    }

    /**
     * �ж�ջ��
     *
     * @return
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * ջ��
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * ��ջ
     */
    public void push(int value) {
        // �ж�ջ�Ƿ�����
        if (isFull()) {
            System.out.println("ջ�����޷���ջ");
            return;
        }
        top++;
        // ��ӵ�����
        stack[top] = value;
        System.out.println(value + "�ɹ���ջ");
    }

    /**
     * ��ջ
     */
    public int pop() {
        // �ж�ջ�Ƿ�Ϊ��
        if (isEmpty()) {
            throw new RuntimeException("ջ�գ��޷���ջ");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * ����������Ԫ��
     */
    public void getAll() {
        if (isEmpty()) {
            System.out.println("��ջ�������ݣ�");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + "\t");
        }
        System.out.println();
    }

    /**
     * Ԫ�����ȼ��ж�
     * ʹ�����ִ�С��Ϊ�Ƚ�
     */
    public int priority(char operate) {
        if (operate == '*' || operate == '/') {
            return 1;
        } else if (operate == '+' || operate == '-') {
            return 0;
        } else {
            // Ŀǰֻ���� �Ӽ��˳�
            return -1;
        }
    }

    /**
     * �ж��Ƿ�Ϊ��Ч������
     */
    public boolean isOperate(char opr) {
        // ����ǼӼ��˳���Ϊtrue
        if (opr == '*' || opr == '-' || opr == '/' || opr == '+') {
            return true;
        }
        return false;
    }

    /**
     * ������
     *
     * @param num1
     * @param num2
     * @param operate ������
     * @return
     */
    public int calResult(int num1, int num2, char operate) {
        int res = 0;
        // �����ж�
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

