package com.fafa.linkedlist;

/**
 * ˫������
 * @author Sire
 * @version 1.0
 * @date 2022-01-04 15:53
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        DoubleHeroNode node1 = new DoubleHeroNode(1, "����", "������");
        DoubleHeroNode node2 = new DoubleHeroNode(2, "�ν�", "��ʱ��");;
        DoubleHeroNode node3 = new DoubleHeroNode(3, "����", "�Ƕ���");
        DoubleHeroNode node4 = new DoubleHeroNode(4, "�ֳ�", "����ͷ");

       /* doubleLinkedList.addNode(node1);
        doubleLinkedList.addNode(node2);
        doubleLinkedList.addNode(node3);
        doubleLinkedList.addNode(node4);
        System.out.println("��Ӻ�Ľ����");
        doubleLinkedList.findAllNode();*/

        doubleLinkedList.addByOrder(node1);
        doubleLinkedList.addByOrder(node4);
        doubleLinkedList.addByOrder(node3);
        doubleLinkedList.addByOrder(node3);
        doubleLinkedList.addByOrder(node2);
        System.out.println("�Ż������ӽ����");
        doubleLinkedList.findAllNode();

        DoubleHeroNode newNode = new DoubleHeroNode(4, "С��", "�ֽ�ͷ");
        System.out.println("�޸ĺ�Ľ����");
        doubleLinkedList.updateNode(newNode);
        doubleLinkedList.findAllNode();

        System.out.println("ɾ����Ľ����");
        doubleLinkedList.deleteNode(3);
        doubleLinkedList.findAllNode();

    }
}

/**
 * ����һ��˫��������
 */
class DoubleLinkedList{
    /**
     * ��ʼ��һ��ͷ�ڵ�
     */
    private DoubleHeroNode head = new DoubleHeroNode(0,"","");

    /**
     * ����ͷ���
     * @return
     */
    public DoubleHeroNode getHead() {
        return head;
    }

    /**
     * ����Ԫ��
     */
    public void addNode(DoubleHeroNode heroNode) {
        // ��ʱ����������Ѱ��β�ڵ�
        DoubleHeroNode temp = head;
        /*δ�Ż���*/
        while (true) {
            // �����ǰΪβ���
            if (temp.next == null) {
                heroNode.next = null;
                // ˫���
                temp.next = heroNode;
                heroNode.pre = temp;
                break;
            } else {
                // ��������
                temp = temp.next;
            }
        }
    }

    /**
     * �Ż������ӷ���
     */
    public void addByOrder(DoubleHeroNode heroNode) {
        // ��Ϊͷ��㲻�ܶ���������Ҫ��������temp���ҵ����λ��
        // ��Ϊ�ǵ��������������ҵ� temp ��λ�� ���λ�õ�ǰһ���ڵ㣬������Ӳ���
        DoubleHeroNode temp = head;
        // �����ж��Ƿ����ظ�����Ӣ��
        boolean flag = false;
        /*�Ż����*/
        // 1��Ҫ������������ӣ�����������
        // 2�����������ظ�
        // 3��whileѭ����ֻ�в��ұ�����������Ӳ���
        while (true) {
            // ��ֹ��ָ��,˵��temp�Ѿ������������
            if (temp.next == null) {
                break;
            }
            // �� ��ǰλ�õĺ�һ���ȴ�С�����С�ں�����Ǹ�Ӣ�۵ı�ţ���ô���ڴ˴���Ӽ���
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                // �����ظ�
                flag = true;
                break;
            }
            // ָ�����
            temp = temp.next;
        }

        if (flag) {
            System.out.println("�����Ѿ��ظ����޷��ٴ���ӱ�ţ�" + heroNode.no);
            return;
        } else {
            // ��Ӳ���
            heroNode.next = temp.next;
            heroNode.pre = temp;
            temp.next = heroNode;
            System.out.println("��ӳɹ���");
            return;
        }
    }

    /**
     * �޸Ľڵ���Ϣ
     * 1�����(no)���ܸ���
     */
    public void updateNode(DoubleHeroNode heroNode) {
        if (isEmpty()) {
            System.out.println("����Ϊ��,û�п��Ը��ĵ�Ԫ�أ�");
            return;
        }
        DoubleHeroNode temp = head;
        // ��Ϊһ���ڱ����ж��Ƿ��ҵ�Ҫ�޸ĵ�Ŀ��
        boolean flag = false;
        while (true) {
            // �������������ˣ�Ҳ���Ƕ����������
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            // ����
            temp = temp.next;
        }

        if (flag) {
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
            return;
        } else {
            System.out.println("������˼��û�ж�λ����Ԫ�أ���ţ�" + heroNode.no);
            return;
        }
    }

    /**
     * ɾ���ڵ�
     */
    public void deleteNode(int no) {
        if (isEmpty()) {
            System.out.println("�Բ�������Ϊ�գ��޿�ɾ�����󣡣���");
            return;
        }
        DoubleHeroNode temp = head;
        // �Ƿ��ҵ���ɾ���ڵ�
        boolean flag = false;
        while (true) {
            // �Ѿ�����������
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            // ɾ�����ڵ����
            // ��ֹ��ָ���쳣
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }
            temp.pre.next = temp.next;
            System.out.println("ɾ���ɹ�����ţ�" + temp.no);
            return;
        } else {
            System.out.println("������˼��û���ҵ���ţ�" + no + "�Ľڵ�");
        }
    }



    /**
     * ����ȫ��Ԫ��
     */
    public void findAllNode() {
        DoubleHeroNode temp = head.next;
        int i = 1;
        if (isEmpty()) {
            System.out.println("��ǰ����Ϊ�գ������ݿ��Դ�ӡ��");
            return;
        }
        while (temp != null) {
            System.out.println("��" + i + "��Ӣ����Ϣ����:" + temp.toString());
            // ����
            temp = temp.next;
            i++;
        }
    }

    /**
     * �ж������Ƿ�Ϊ��
     */
    public boolean isEmpty() {
        return head.next == null;
    }

}

/**
 * ����DoubleHeroNode��ÿһ�� DoubleHeroNode �������һ���ڵ�
 */
class DoubleHeroNode {
    /**
     * ���
     */
    public int no;
    /**
     * Ӣ������
     */
    public String name;
    /**
     * Ӣ���ǳ�
     */
    public String nickname;
    /**
     * ָ����ָ��ǰһ���ڵ�
     */
    public DoubleHeroNode pre;
    /**
     * ָ����ָ����һ���ڵ�
     */
    public DoubleHeroNode next;

    /**
     * ������
     *
     * @param no
     * @param name
     * @param nickname
     */
    public DoubleHeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;

    }

    public DoubleHeroNode() {

    }

    @Override
    public String toString() {
        return "DoubleHeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}


