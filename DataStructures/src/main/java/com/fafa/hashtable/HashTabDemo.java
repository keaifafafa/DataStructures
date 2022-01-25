package com.fafa.hashtable;

import java.util.Scanner;

/**
 * @author Sire
 * @version 1.0
 * @date 2022-01-20 21:35
 */
public class HashTabDemo {
    public static void main(String[] args) {
        // ����hash��
        HashTab hashTab = new HashTab(7);
        // дһ���򵥵Ĳ˵�
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1: ��ӹ�Ա");
            System.out.println("2: ��ʾ��Ա");
            System.out.println("3: ���ҹ�Ա");
            System.out.println("4: ɾ����Ա");
            System.out.println("0: �˳�ϵͳ");

            key = scanner.next();
            switch (key) {
                case "1":
                    System.out.println("����id");
                    int id = scanner.nextInt();
                    System.out.println("��������");
                    String name = scanner.next();
                    //���� ��Ա
                    Employee emp = new Employee(id, name);
                    hashTab.addEmp(emp);
                    break;
                case "2":
                    hashTab.show();
                    break;
                case "3":
                    System.out.println("������Ҫ���ҵ�id");
                    id = scanner.nextInt();
                    hashTab.findById(id);
                    break;
                case "4":
                    System.out.println("��������Ҫɾ����id");
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
 * ������ϣ������������
 */
class HashTab {
    private EmpLinkedList[] empLinkedLists;

    /**
     * �ж���������
     */
    private int size;

    /**
     * ��ʼ��
     *
     * @param size
     */
    public HashTab(int size) {
        this.size = size;
        this.empLinkedLists = new EmpLinkedList[size];
        // ����ע�⣬������Ȼ��size���ռ䣬�������Ƕ��ǿյ�
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    /**
     * ��ӹ�Ա
     *
     * @param employee
     */
    public void addEmp(Employee employee) {
        // ����hashcode�����������Լ�ȥ�Ǹ����飬����ʹ�õ���ȡģ��
        int hashIndex = getCode(employee.id);
        empLinkedLists[hashIndex].add(employee);
    }

    /**
     * ����
     */
    public void show() {
        for (int i = 0; i < empLinkedLists.length; i++) {
            empLinkedLists[i].show(i);
        }
    }

    /**
     * ͨ��id���ҹ�Ա��Ϣ
     *
     * @param id
     */
    public void findById(int id) {
        int hashIndex = getCode(id);
        Employee employee = empLinkedLists[hashIndex].findById(id);
        if (employee != null) {
            System.out.println(" �û���ϢΪ��" + employee.toString());
        } else {
            System.out.println("���û�������~");
        }

    }

    /**
     * ͨ�� id ɾ����Ա��Ϣ
     *
     * @param id
     */
    public void delEmpById(int id) {
        int hashIndex = getCode(id);
        boolean res = empLinkedLists[hashIndex].delEmpById(id);
        if (res) {
            System.out.println("���Ϊ��" + id + "�ѱ��ɹ�ɾ��~");
        } else {
            System.out.println("ɾ��ʧ��~");
        }
    }

    /**
     * ����hashcode�����������Լ�ȥ�Ǹ�����
     *
     * @param id
     */
    public int getCode(int id) {
        return id % size;
    }


}

/**
 * ��Ա��
 */
class Employee {
    public int id;
    public String name;
    /**
     * next Ĭ��Ϊ��
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
 * ��������
 */
class EmpLinkedList {
    /**
     * �ƽ��
     */
    public Employee head = new Employee(-1, "dummy");

    /**
     * ��ӹ�Ա
     *
     * @param employee
     */
    public void add(Employee employee) {
        // �������Ϊ��
        if (isEmpty(head)) {
            head.next = employee;
            return;
        }
        // �����ڵ�
        Employee cur = head;
        // �����Ϊ��
        while (cur.next != null) {
            // ��������ظ�id�Ĺ�Ա
            if (employee.id == cur.next.id) {
                System.out.println("���ʧ�ܣ��Ѵ����ظ��Ĺ�Ա id = " + employee.id);
                return;
            }
            // ��˳����ӣ���С����
            if (employee.id < cur.next.id) {
                break;
            }
            // ����
            cur = cur.next;
        }
        // ��Ӳ���
        employee.next = cur.next;
        cur.next = employee;
        System.out.println("��ӳɹ�~");
    }

    /**
     * ��ӡ������Ԫ��
     */
    public void show(int no) {
        if (isEmpty(head)) {
            System.out.println("��" + (no + 1) + "������Ϊ��~");
            return;
        }
        Employee temp = head.next;
        while (temp != null) {
            System.out.print("��" + (no + 1) + "��������ϢΪ��" + temp.toString() + "\t");
            temp = temp.next;
        }
        // ����
        System.out.println();
    }

    /**
     * ͨ��id���ҹ�Ա
     *
     * @param id
     */
    public Employee findById(int id) {
        // ����Ϊ��
        if (isEmpty(head)) {
            return null;
        }
        // �����ڵ�
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
     * ͨ�� id ɾ����Ա��Ϣ
     *
     * @param id
     * @return
     */
    public boolean delEmpById(int id) {
        // �������Ϊ��
        if (isEmpty(head)) {
            System.out.println("����Ϊ��~");
            return false;
        }
        // ��־λ
        boolean flag = false;
        Employee temp = head.next;
        while (temp != null) {
            // Ҫ���һλ��Ҳ����Ҫ��������ɾ��λ�õ�ǰһλ��ַ
            if (temp.next.id == id) {
                // ɾ������
                temp.next = temp.next.next;
                flag = true;
                break;
            }
            temp = temp.next;
        }
        return flag;
    }

    /**
     * �ж������Ƿ�Ϊ��
     *
     * @param head
     * @return
     */
    public boolean isEmpty(Employee head) {
        return head.next == null;
    }


}
