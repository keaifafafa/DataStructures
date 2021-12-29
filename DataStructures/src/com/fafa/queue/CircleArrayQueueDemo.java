package com.fafa.queue;

import java.util.Scanner;

/**
 * 环形数组队列
 *
 * @author Sire
 * @version 1.0
 * @date 2021-12-29 19:56
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        // 测试环形数组
        // 创建一个队列 这里实际可用参数只有 4 个，因为最后一个空间要作为约定
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(5);
        // 用户选择键
        char key = ' ';
        // 循环判断
        boolean loop = true;
        Scanner sc = new Scanner(System.in);
        menu();
        while (loop) {
            key = sc.next().charAt(0);

            switch (key) {
                // 入队
                case 'a':
                    System.out.println("请输入队元素");
                    int a = sc.nextInt();
                    circleArrayQueue.addQueue(a);
                    break;
                // 出队
                case 'g':
                    try {
                        int g = circleArrayQueue.getQueue();
                        System.out.println("出队元素为" + g);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                // 显示全部
                case 's':
                    circleArrayQueue.showQueue();
                    break;
                // 显示头部
                case 'h':
                    try {
                        int h = circleArrayQueue.headQueue();
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

    /**
     * 菜单方法
     */
    public static void menu() {
        System.out.println("a:入队");
        System.out.println("g:出队");
        System.out.println("s:显示全部");
        System.out.println("h:显示队首");
        System.out.println("e:退出程序");
    }
}

/**
 * 使用数组模拟环形队列-CircleArrayQueue类
 */
class CircleArrayQueue {
    /**
     * 表示数组的最大容量
     */
    private int maxSize;
    /**
     * front 队列的第一个元素
     */
    private int front;
    /**
     * rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
     */
    private int rear;
    /**
     * 模拟队列
     */
    private int[] arr;

    /**
     * 创建队列的构造器
     */
    public CircleArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        arr = new int[maxSize];
        // front 队列的第一个元素
        front = 0;
        // rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
        rear = 0;
    }

    /**
     * 判断队列是否是满的
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
            arr[rear] = o;
            // 将 rear 后移，这里必须要考虑取模（防止数组下标越界）
            rear = (rear + 1) % maxSize;
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
            // 这里需要分析出 front 是队列首个元素（并非数组第一个）
            // 1、temp用来存储arr[front] 的值，便于将front进行增加操作
            int temp = arr[front];
            // 2、front也要进行相加和取模操作（环形）
            front = (front + 1) % maxSize;
            // 3、返回 temp 保存的 arr[front] 的值
            return temp;
        }
        // 抛出异常，不要写 return -1;这种 throw直接就结束了，所以不用再写 return 了
        throw new RuntimeException("队列为空，不能出队！！！");
    }

    /**
     * 展示队列所有数据
     */
    public void showQueue() {
        if (!isEmpty()) {
            //思路: 从front开始遍历，遍历多少个元素(也就是有效的元素个数)
            // 其实有效个数就是 rear - front的绝对值，这里加maxSize是为了抵消负数
            /** 自己写的 **/
           /* int n = (rear + maxSize - front) % maxSize;
            int count = 0;
            int i = front;
            while (count < n) {
                System.out.printf("arr[%d] = %d\t", i % maxSize , arr[i % maxSize]);
                i++;
                count++;
            }*/
            /** 韩老师写的 **/
            for (int i = front; i < front + getValidSize(); i++) {
                System.out.printf("arr[%d] = %d\t", i % maxSize, arr[i % maxSize]);
            }
            System.out.println();
            return;
        }
        System.out.println("队列为空，无数据可展示！！！");
        return;

    }

    /**
     * 计算数组的有效个数
     */
    public int getValidSize() {
        // 其实有效个数就是 rear - front的绝对值，这里加maxSize是为了抵消负数
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 展示队头
     */
    public int headQueue() {
        if (!isEmpty()) {
            return arr[front];
        }
        throw new RuntimeException("队列为空，无队首元素！！！");
    }

}
