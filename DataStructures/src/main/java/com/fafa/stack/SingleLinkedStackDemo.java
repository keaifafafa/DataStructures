package com.fafa.stack;

import java.util.Scanner;

/**
 * 使用单链表来模拟栈
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-05 16:34
 */
public class SingleLinkedStackDemo {
    public static void main(String[] args) {
        SingleLinkedStack stack = new SingleLinkedStack();
        // 是否一直循环
        boolean loop = true;
        // 用户交互键
        String key = "";
        Scanner sc = new Scanner(System.in);
        while (loop) {
            menu();
            key = sc.next();
            switch (key) {
                case "show":
                    stack.show();
                    break;
                case "push":
                    System.out.println("请输入需要入栈的数据：");
                    int value = sc.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int pop = stack.pop();
                        System.out.println(pop + "出栈成功");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    loop = false;
                    System.out.println("程序成功退出！");
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 菜单
     */
    public static void menu() {
        System.out.println("show：显示数据");
        System.out.println("push：数据入栈");
        System.out.println("pop：数据出栈");
        System.out.println("exit：退出程序");
        System.out.println("请输入您的选择：");
    }
}

/**
 * 创建单链表栈
 * 思路：
 * 1、使用头插法，进行入栈操作
 * 2、出栈，就是把头结点后面的一个元素移除即可
 */
class SingleLinkedStack {
    /**
     * 头结点（哑结点）
     */
    private LinkStack head = new LinkStack(0);

    /**
     * 判断栈是否为空（链式栈不会有满的情况）
     */
    public boolean isEmpty() {
        return head.getNext() == null;
    }

    /**
     * 入栈（链式栈不会有满的情况）
     * 头插法入栈
     */
    public void push(int value) {
        LinkStack stack = new LinkStack(value);
        // 入栈
        stack.setNext(head.getNext());
        head.setNext(stack);
        System.out.println(value + "成功入栈");
    }

    /**
     * 出栈
     */
    public int pop() {
        // 栈为空
        if (isEmpty()) {
            throw new RuntimeException("栈为空！");
        }
        // 栈不为空
        LinkStack temp = head.getNext();
        int value = temp.getValue();
        // 删除
        head.setNext(temp.getNext());
        return value;
    }

    /**
     * 遍历栈
     */
    public void show() {
        // 栈为空
        if (isEmpty()) {
            System.out.println("栈为空！");
            return;
        }
        // 栈不为空
        LinkStack temp = head.getNext();
        while (temp != null) {
            System.out.print(temp.getValue() + "\t");
            // 后移
            temp = temp.getNext();
        }
        // 换行
        System.out.println();
    }
}

/**
 * 链式栈
 */
class LinkStack {
    private int value;
    private LinkStack next;

    public LinkStack(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkStack getNext() {
        return next;
    }

    public void setNext(LinkStack next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "LinkStack{" +
                "value=" + value +
                '}';
    }
}
