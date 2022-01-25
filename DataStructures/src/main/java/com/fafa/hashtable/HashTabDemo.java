package com.fafa.hashtable;

import java.util.Scanner;

/**
 * @author Sire
 * @version 1.0
 * @date 2022-01-20 21:35
 */
public class HashTabDemo {
    public static void main(String[] args) {
        // 创建hash表
        HashTab hashTab = new HashTab(7);
        // 写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1: 添加雇员");
            System.out.println("2: 显示雇员");
            System.out.println("3: 查找雇员");
            System.out.println("4: 删除雇员");
            System.out.println("0: 退出系统");

            key = scanner.next();
            switch (key) {
                case "1":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建 雇员
                    Employee emp = new Employee(id, name);
                    hashTab.addEmp(emp);
                    break;
                case "2":
                    hashTab.show();
                    break;
                case "3":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findById(id);
                    break;
                case "4":
                    System.out.println("请输入需要删除的id");
                    id = scanner.nextInt();
                    hashTab.delEmpById(id);
                    break;
                case "0":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }

        }
    }
}

/**
 * 创建哈希表，管理多个链表
 */
class HashTab {
    private EmpLinkedList[] empLinkedLists;

    /**
     * 有多少条链表
     */
    private int size;

    /**
     * 初始化
     *
     * @param size
     */
    public HashTab(int size) {
        this.size = size;
        this.empLinkedLists = new EmpLinkedList[size];
        // 这里注意，现在虽然有size个空间，但是他们都是空的
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    /**
     * 添加雇员
     *
     * @param employee
     */
    public void addEmp(Employee employee) {
        // 生成hashcode，用来决定自己去那个数组，这里使用的是取模法
        int hashIndex = getCode(employee.id);
        empLinkedLists[hashIndex].add(employee);
    }

    /**
     * 遍历
     */
    public void show() {
        for (int i = 0; i < empLinkedLists.length; i++) {
            empLinkedLists[i].show(i);
        }
    }

    /**
     * 通过id查找雇员信息
     *
     * @param id
     */
    public void findById(int id) {
        int hashIndex = getCode(id);
        Employee employee = empLinkedLists[hashIndex].findById(id);
        if (employee != null) {
            System.out.println(" 用户信息为：" + employee.toString());
        } else {
            System.out.println("该用户不存在~");
        }

    }

    /**
     * 通过 id 删除雇员信息
     *
     * @param id
     */
    public void delEmpById(int id) {
        int hashIndex = getCode(id);
        boolean res = empLinkedLists[hashIndex].delEmpById(id);
        if (res) {
            System.out.println("编号为：" + id + "已被成功删除~");
        } else {
            System.out.println("删除失败~");
        }
    }

    /**
     * 生成hashcode，用来决定自己去那个数组
     *
     * @param id
     */
    public int getCode(int id) {
        return id % size;
    }


}

/**
 * 雇员类
 */
class Employee {
    public int id;
    public String name;
    /**
     * next 默认为空
     */
    public Employee next;

    public Employee() {
    }

    public Employee(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

/**
 * 创建链表
 */
class EmpLinkedList {
    /**
     * 哑结点
     */
    public Employee head = new Employee(-1, "dummy");

    /**
     * 添加雇员
     *
     * @param employee
     */
    public void add(Employee employee) {
        // 如果链表为空
        if (isEmpty(head)) {
            head.next = employee;
            return;
        }
        // 遍历节点
        Employee cur = head;
        // 如果不为空
        while (cur.next != null) {
            // 如果存在重复id的雇员
            if (employee.id == cur.next.id) {
                System.out.println("添加失败，已存在重复的雇员 id = " + employee.id);
                return;
            }
            // 按顺序添加（从小到大）
            if (employee.id < cur.next.id) {
                break;
            }
            // 后移
            cur = cur.next;
        }
        // 添加操作
        employee.next = cur.next;
        cur.next = employee;
        System.out.println("添加成功~");
    }

    /**
     * 打印链表内元素
     */
    public void show(int no) {
        if (isEmpty(head)) {
            System.out.println("第" + (no + 1) + "条链表为空~");
            return;
        }
        Employee temp = head.next;
        while (temp != null) {
            System.out.print("第" + (no + 1) + "条链表信息为：" + temp.toString() + "\t");
            temp = temp.next;
        }
        // 换行
        System.out.println();
    }

    /**
     * 通过id查找雇员
     *
     * @param id
     */
    public Employee findById(int id) {
        // 链表为空
        if (isEmpty(head)) {
            return null;
        }
        // 遍历节点
        Employee temp = head.next;
        while (temp != null) {
            if (temp.id == id) {
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 通过 id 删除雇员信息
     *
     * @param id
     * @return
     */
    public boolean delEmpById(int id) {
        // 如果链表为空
        if (isEmpty(head)) {
            System.out.println("链表为空~");
            return false;
        }
        // 标志位
        boolean flag = false;
        Employee temp = head.next;
        while (temp != null) {
            // 要想后看一位，也就是要保留到被删除位置的前一位地址
            if (temp.next.id == id) {
                // 删除操作
                temp.next = temp.next.next;
                flag = true;
                break;
            }
            temp = temp.next;
        }
        return flag;
    }

    /**
     * 判断链表是否为空
     *
     * @param head
     * @return
     */
    public boolean isEmpty(Employee head) {
        return head.next == null;
    }


}
