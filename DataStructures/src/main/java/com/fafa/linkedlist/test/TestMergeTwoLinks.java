package com.fafa.linkedlist.test;

/**
 * �ϲ��������������
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-02 11:31
 */
public class TestMergeTwoLinks {
    public static void main(String[] args) {
        NodeUtils list1 = new NodeUtils();
        NodeUtils list2 = new NodeUtils();
        // ���
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        list1.add(node1);
        list1.add(node2);
        list1.getAll();
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        list2.add(node3);
        list2.add(node4);
        list2.add(node5);
        list2.getAll();
        System.out.println();
        // ���úϲ�����
        Solution solution = new Solution();
        ListNode listNode = solution.mergeTwoLists(list1.getHead(), list2.getHead());
        printNode(listNode);
    }

    public static void printNode(ListNode head){
        if(head == null){
            return;
        }
        // ��ʱ����
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + "\t");
            temp = temp.next;
        }
        return;
    }
}

/**
 * �ڵ㹤�ߣ�crud��
 */
class NodeUtils{

    private ListNode head = new ListNode(1);

    public ListNode getHead() {
        return head;
    }

    /**
     * ��ӽڵ�
     * @param target
     */
    public void add(ListNode target){
        // ��ʱ����
        ListNode temp = head;
        while(true) {
            if (temp.next == null) {
                target.next = null;
                temp.next = target;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * ����ȫ���ڵ�
     */
    public void getAll(){
        if(head == null){
            return;
        }
        // ��ʱ����
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + "\t");
            temp = temp.next;
        }
        return;
    }
}

/**
 * �ڵ����
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // �ƽڵ�
        ListNode dummpy = new ListNode(-1);
        ListNode temp = dummpy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            // ����
            temp = temp.next;
        }
        // ��ʱ�� list1 �� list2 �� ��໹��һ��Ԫ��δ�ϲ�
        if (list1 == null) {
            temp.next = list2;
        } else {
            temp.next = list1;
        }
        return dummpy.next;
    }
}
