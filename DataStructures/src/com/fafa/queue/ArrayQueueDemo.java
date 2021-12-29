package com.fafa.queue;

import java.util.Scanner;

/**
 * ʹ������ģ��ʵ�ֶ���
 *
 * @author Sire
 * @version 1.0
 * @date 2021-12-29 16:17
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        // ����һ������
        ArrayQueue arrayQueue = new ArrayQueue(3);
        // �û�ѡ���
        char key = ' ';
        // ѭ���ж�
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        menu();
        while(loop){
            key = sc.next().charAt(0);

            switch (key){
                // ���
                case 'a':
                    System.out.println("�������Ԫ��");
                    int a = sc.nextInt();
                    arrayQueue.addQueue(a);
                    break;
                // ����
                case 'g':
                    try {
                        int g = arrayQueue.getQueue();
                        System.out.println("����Ԫ��Ϊ" + g);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                // ��ʾȫ��
                case 's':
                    arrayQueue.showQueue();
                    break;
                // ��ʾͷ��
                case 'h':
                    try {
                        int h = arrayQueue.headQueue();
                        System.out.println("����Ԫ��Ϊ��" + h);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                // �˳�����
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("�����˳�");
    }

    public static void menu(){
        System.out.println("a:���");
        System.out.println("g:����");
        System.out.println("s:��ʾȫ��");
        System.out.println("h:��ʾ����");
        System.out.println("e:�˳�����");
    }

}

/**
 * ʹ������ģ�����-��дһ��ArrayQueue��
 */
class ArrayQueue {
    /**
     * ��ʾ������������
     */
    private int maxSize;
    /**
     * ����ͷ
     */
    private int front;
    /**
     * ����β
     */
    private int rear;
    /**
     * ģ�����
     */
    private int[] arr;

    /**
     * �������еĹ�����
     */
    public ArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        arr = new int[maxSize];
        // ָ�����ͷ����ָ�����ͷ��ǰһ��λ��
        front = -1;
        // ָ�����β����ָ�����β��λ�ã�����λ�ã���������β����
        rear = -1;
    }

    /**
     * �ж϶����Ƿ�������
     */
    public boolean isFull() {
        // �Լ�д���ж��߼�
       /* if(rear == (maxSize - 1)){
            return true;
        }
        return false;*/
        // ����ʦд���ж��߼�
        return rear == (maxSize - 1);
    }

    /**
     * �ж϶����Ƿ�Ϊ��
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * ������ݵ����У���ӣ�
     * 1�����ж϶����Ƿ��Ѿ�����
     * 2��Ȼ����ȷ���Ƿ�������
     */
    public void addQueue(int o) {
        // ���ж��Ƿ��Ѿ�����
        if (!isFull()) {
            ++rear;
            arr[rear] = o;
            System.out.println("�ɹ����룡");
            return;
        }
        System.out.println("�����Ѿ������޷����");
    }

    /**
     * ��ȡ��������(����)
     * 1�����ж϶����Ƿ�Ϊ��
     * 2��Ȼ����ȷ���Ƿ���г���
     */
    public int getQueue() {
        if (!isEmpty()) {
            // ͷ������
            ++front;
            return arr[front];
        }
        // �׳��쳣����Ҫд return -1;���� throwֱ�Ӿͽ����ˣ����Բ�����д return ��
        throw new RuntimeException("����Ϊ�գ����ܳ��ӣ�����");
    }

    /**
     * չʾ������������
     */
    public void showQueue() {
        if (!isEmpty()) {
           for (int i = front + 1; i <= rear; i++){
               System.out.printf("arr[%d] = %d\t",i + 1,arr[i]);
           }
           return;
        }
        System.out.println("����Ϊ�գ������ݿ�չʾ������");
        return;

    }

    /**
     * չʾ��ͷ
     */
    public int headQueue(){
        if(!isEmpty()){
            return arr[front + 1];
        }
        throw new RuntimeException("����Ϊ�գ��޶���Ԫ�أ�����");
    }

}
