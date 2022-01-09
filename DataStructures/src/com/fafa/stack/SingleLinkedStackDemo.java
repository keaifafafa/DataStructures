package com.fafa.stack;

import java.util.Scanner;

/**
 * ʹ�õ�������ģ��ջ
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-05 16:34
 */
public class SingleLinkedStackDemo {
    public static void main(String[] args) {
        SingleLinkedStack stack = new SingleLinkedStack();
        // �Ƿ�һֱѭ��
        boolean loop = true;
        // �û�������
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
                    System.out.println("��������Ҫ��ջ�����ݣ�");
                    int value = sc.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int pop = stack.pop();
                        System.out.println(pop + "��ջ�ɹ�");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
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
    public static void menu() {
        System.out.println("show����ʾ����");
        System.out.println("push��������ջ");
        System.out.println("pop�����ݳ�ջ");
        System.out.println("exit���˳�����");
        System.out.println("����������ѡ��");
    }
}

/**
 * ����������ջ
 * ˼·��
 * 1��ʹ��ͷ�巨��������ջ����
 * 2����ջ�����ǰ�ͷ�������һ��Ԫ���Ƴ�����
 */
class SingleLinkedStack {
    /**
     * ͷ��㣨�ƽ�㣩
     */
    private LinkStack head = new LinkStack(0);

    /**
     * �ж�ջ�Ƿ�Ϊ�գ���ʽջ���������������
     */
    public boolean isEmpty() {
        return head.getNext() == null;
    }

    /**
     * ��ջ����ʽջ���������������
     * ͷ�巨��ջ
     */
    public void push(int value) {
        LinkStack stack = new LinkStack(value);
        // ��ջ
        stack.setNext(head.getNext());
        head.setNext(stack);
        System.out.println(value + "�ɹ���ջ");
    }

    /**
     * ��ջ
     */
    public int pop() {
        // ջΪ��
        if (isEmpty()) {
            throw new RuntimeException("ջΪ�գ�");
        }
        // ջ��Ϊ��
        LinkStack temp = head.getNext();
        int value = temp.getValue();
        // ɾ��
        head.setNext(temp.getNext());
        return value;
    }

    /**
     * ����ջ
     */
    public void show() {
        // ջΪ��
        if (isEmpty()) {
            System.out.println("ջΪ�գ�");
            return;
        }
        // ջ��Ϊ��
        LinkStack temp = head.getNext();
        while (temp != null) {
            System.out.print(temp.getValue() + "\t");
            // ����
            temp = temp.getNext();
        }
        // ����
        System.out.println();
    }
}

/**
 * ��ʽջ
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
