package com.fafa.stack;

import java.util.Scanner;

/**
 * ����ģ��ջ
 * @author Sire
 * @version 1.0
 * @date 2022-01-05 15:49
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        // �Ƿ�һֱѭ��
            boolean loop = true;
            // �û�������
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
                        System.out.println("��������Ҫ��ջ�����ݣ�");
                        int value = sc.nextInt();
                        arrayStack.push(value);
                        break;
                    case "pop":
                        arrayStack.pop();
                        break;
                    case "exit":
                        loop = false;
                        System.out.println("����ɹ��˳���");
                        break;
                    default:
                        break;
                }
        }


    }

    /**
     * �˵�
     */
    public static void menu(){
        System.out.println("show����ʾ����");
        System.out.println("push��������ջ");
        System.out.println("pop�����ݳ�ջ");
        System.out.println("exit���˳�����");
        System.out.println("����������ѡ��");
    }
}

/**
 * ����ջ
 */
class ArrayStack{
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
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * �ж�ջ��
     * @return
     */
    public boolean isFull(){
        return top == maxSize - 1;
    }
    /**
     * ջ��
     */
    public boolean isEmpty(){
        return top == -1;
    }
    /**
     * ��ջ
     */
    public void push(int value){
        // �ж�ջ�Ƿ�����
        if (isFull()){
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
    public void pop(){
        // �ж�ջ�Ƿ�Ϊ��
        if (isEmpty()){
            System.out.println("ջ�գ��޷���ջ");
            return;
        }
        System.out.println(stack[top] + "�ɹ���ջ");
        top--;
    }
    /**
     * ����������Ԫ��
     */
    public void getAll(){
        if (isEmpty()){
            System.out.println("��ջ�������ݣ�");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + "\t");
        }
        System.out.println();
    }

}
