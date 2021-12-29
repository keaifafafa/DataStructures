package com.fafa.queue;

import java.util.Scanner;

/**
 * 使用数组模拟实现队列
 *
 * @author Sire
 * @version 1.0
 * @date 2021-12-29 16:17
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        // 创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        // 用户选择键
        char key = ' ';
        // 循环判断
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        menu();
        while(loop){
            key = sc.next().charAt(0);

            switch (key){
                // 入队
                case 'a':
                    System.out.println("请输入队元素");
                    int a = sc.nextInt();
                    arrayQueue.addQueue(a);
                    break;
                // 出队
                case 'g':
                    try {
                        int g = arrayQueue.getQueue();
                        System.out.println("出队元素为" + g);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                // 显示全部
                case 's':
                    arrayQueue.showQueue();
                    break;
                // 显示头部
                case 'h':
                    try {
                        int h = arrayQueue.headQueue();
                        System.out.println("队首元素为：" + h);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                // 退出程序
                case 'e':
                    sc.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }

    public static void menu(){
        System.out.println("a:入队");
        System.out.println("g:出队");
        System.out.println("s:显示全部");
        System.out.println("h:显示队首");
        System.out.println("e:退出程序");
    }

}

/**
 * 使用数组模拟队列-编写一个ArrayQueue类
 */
class ArrayQueue {
    /**
     * 表示数组的最大容量
     */
    private int maxSize;
    /**
     * 队列头
     */
    private int front;
    /**
     * 队列尾
     */
    private int rear;
    /**
     * 模拟队列
     */
    private int[] arr;

    /**
     * 创建队列的构造器
     */
    public ArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        arr = new int[maxSize];
        // 指向队列头部，指向队列头的前一个位置
        front = -1;
        // 指向队列尾部，指向队列尾的位置（具体位置，包含队列尾部）
        rear = -1;
    }

    /**
     * 判断队列是否是满的
     */
    public boolean isFull() {
        // 自己写的判断逻辑
       /* if(rear == (maxSize - 1)){
            return true;
        }
        return false;*/
        // 韩老师写的判断逻辑
        return rear == (maxSize - 1);
    }

    /**
     * 判断队列是否为空
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 添加数据到队列（入队）
     * 1、先判断队列是否已经满了
     * 2、然后在确定是否进行添加
     */
    public void addQueue(int o) {
        // 先判断是否已经满了
        if (!isFull()) {
            ++rear;
            arr[rear] = o;
            System.out.println("成功加入！");
            return;
        }
        System.out.println("队列已经满，无法添加");
    }

    /**
     * 获取队列数据(出队)
     * 1、先判断队列是否为空
     * 2、然后在确定是否进行出队
     */
    public int getQueue() {
        if (!isEmpty()) {
            // 头部后移
            ++front;
            return arr[front];
        }
        // 抛出异常，不要写 return -1;这种 throw直接就结束了，所以不用再写 return 了
        throw new RuntimeException("队列为空，不能出队！！！");
    }

    /**
     * 展示队列所有数据
     */
    public void showQueue() {
        if (!isEmpty()) {
           for (int i = front + 1; i <= rear; i++){
               System.out.printf("arr[%d] = %d\t",i + 1,arr[i]);
           }
           return;
        }
        System.out.println("队列为空，无数据可展示！！！");
        return;

    }

    /**
     * 展示队头
     */
    public int headQueue(){
        if(!isEmpty()){
            return arr[front + 1];
        }
        throw new RuntimeException("队列为空，无队首元素！！！");
    }

}
