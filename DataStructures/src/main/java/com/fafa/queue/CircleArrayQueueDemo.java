package com.fafa.queue;

import java.util.Scanner;

/**
 * �����������
 *
 * @author Sire
 * @version 1.0
 * @date 2021-12-29 19:56
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        // ���Ի�������
        // ����һ������ ����ʵ�ʿ��ò���ֻ�� 4 ������Ϊ���һ���ռ�Ҫ��ΪԼ��
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(5);
        // �û�ѡ���
        char key = ' ';
        // ѭ���ж�
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        menu();
        while (loop) {
            key = sc.next().charAt(0);

            switch (key) {
                // ���
                case 'a':
                    System.out.println("�������Ԫ��");
                    int a = sc.nextInt();
                    circleArrayQueue.addQueue(a);
                    break;
                // ����
                case 'g':
                    try {
                        int g = circleArrayQueue.getQueue();
                        System.out.println("����Ԫ��Ϊ" + g);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                // ��ʾȫ��
                case 's':
                    circleArrayQueue.showQueue();
                    break;
                // ��ʾͷ��
                case 'h':
                    try {
                        int h = circleArrayQueue.headQueue();
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

    /**
     * �˵�����
     */
    public static void menu() {
        System.out.println("a:���");
        System.out.println("g:����");
        System.out.println("s:��ʾȫ��");
        System.out.println("h:��ʾ����");
        System.out.println("e:�˳�����");
    }
}

/**
 * ʹ������ģ�⻷�ζ���-CircleArrayQueue��
 */
class CircleArrayQueue {
    /**
     * ��ʾ������������
     */
    private int maxSize;
    /**
     * front ���еĵ�һ��Ԫ��
     */
    private int front;
    /**
     * rear ָ����е����һ��Ԫ�صĺ�һ��λ��. ��Ϊϣ���ճ�һ���ռ���ΪԼ��.
     */
    private int rear;
    /**
     * ģ�����
     */
    private int[] arr;

    /**
     * �������еĹ�����
     */
    public CircleArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        arr = new int[maxSize];
        // front ���еĵ�һ��Ԫ��
        front = 0;
        // rear ָ����е����һ��Ԫ�صĺ�һ��λ��. ��Ϊϣ���ճ�һ���ռ���ΪԼ��.
        rear = 0;
    }

    /**
     * �ж϶����Ƿ�������
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
            arr[rear] = o;
            // �� rear ���ƣ��������Ҫ����ȡģ����ֹ�����±�Խ�磩
            rear = (rear + 1) % maxSize;
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
            // ������Ҫ������ front �Ƕ����׸�Ԫ�أ����������һ����
            // 1��temp�����洢arr[front] ��ֵ�����ڽ�front�������Ӳ���
            int temp = arr[front];
            // 2��frontҲҪ������Ӻ�ȡģ���������Σ�
            front = (front + 1) % maxSize;
            // 3������ temp ����� arr[front] ��ֵ
            return temp;
        }
        // �׳��쳣����Ҫд return -1;���� throwֱ�Ӿͽ����ˣ����Բ�����д return ��
        throw new RuntimeException("����Ϊ�գ����ܳ��ӣ�����");
    }

    /**
     * չʾ������������
     */
    public void showQueue() {
        if (!isEmpty()) {
            //˼·: ��front��ʼ�������������ٸ�Ԫ��(Ҳ������Ч��Ԫ�ظ���)
            // ��ʵ��Ч�������� rear - front�ľ���ֵ�������maxSize��Ϊ�˵�������
            /** �Լ�д�� **/
           /* int n = (rear + maxSize - front) % maxSize;
            int count = 0;
            int i = front;
            while (count < n) {
                System.out.printf("arr[%d] = %d\t", i % maxSize , arr[i % maxSize]);
                i++;
                count++;
            }*/
            /** ����ʦд�� **/
            for (int i = front; i < front + getValidSize(); i++) {
                System.out.printf("arr[%d] = %d\t", i % maxSize, arr[i % maxSize]);
            }
            System.out.println();
            return;
        }
        System.out.println("����Ϊ�գ������ݿ�չʾ������");
        return;

    }

    /**
     * �����������Ч����
     */
    public int getValidSize() {
        // ��ʵ��Ч�������� rear - front�ľ���ֵ�������maxSize��Ϊ�˵�������
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * չʾ��ͷ
     */
    public int headQueue() {
        if (!isEmpty()) {
            return arr[front];
        }
        throw new RuntimeException("����Ϊ�գ��޶���Ԫ�أ�����");
    }

}
