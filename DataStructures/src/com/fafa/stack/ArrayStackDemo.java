package com.fafa.stack;

import java.util.Scanner;

/**
 * 数组模拟栈
 * @author Sire
 * @version 1.0
 * @date 2022-01-05 15:49
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        // 是否一直循环
            boolean loop = true;
            // 用户交互键
            String key = "";
            Scanner sc = new Scanner(System.in);
            while(loop){
                menu();
                key = sc.next();
                switch (key){
                    case "show":
                        arrayStack.getAll();
                        break;
                    case "push":
                        System.out.println("请输入需要入栈的数据：");
                        int value = sc.nextInt();
                        arrayStack.push(value);
                        break;
                    case "pop":
                        arrayStack.pop();
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
    public static void menu(){
        System.out.println("show：显示数据");
        System.out.println("push：数据入栈");
        System.out.println("pop：数据出栈");
        System.out.println("exit：退出程序");
        System.out.println("请输入您的选择：");
    }
}

/**
 * 数组栈
 */
class ArrayStack{
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
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 判断栈满
     * @return
     */
    public boolean isFull(){
        return top == maxSize - 1;
    }
    /**
     * 栈空
     */
    public boolean isEmpty(){
        return top == -1;
    }
    /**
     * 入栈
     */
    public void push(int value){
        // 判断栈是否已满
        if (isFull()){
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
    public void pop(){
        // 判断栈是否为空
        if (isEmpty()){
            System.out.println("栈空，无法出栈");
            return;
        }
        System.out.println(stack[top] + "成功出栈");
        top--;
    }
    /**
     * 遍历数组内元素
     */
    public void getAll(){
        if (isEmpty()){
            System.out.println("空栈，无数据！");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + "\t");
        }
        System.out.println();
    }

}
