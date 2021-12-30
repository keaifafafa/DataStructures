package com.fafa.linkedlist;

/**
 * ������
 *
 * @author Sire
 * @version 1.0
 * @date 2021-12-30 14:55
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "����", "������");
        HeroNode node2 = new HeroNode(2, "�ν�", "��ʱ��");
        HeroNode node3 = new HeroNode(3, "����", "�Ƕ���");
        HeroNode node4 = new HeroNode(4, "�ֳ�", "����ͷ");
        // ��ʼ������
        SingleLinkedList linkedList = new SingleLinkedList();
        // ���Ӣ��
        linkedList.addByOrder(node1);
        linkedList.addByOrder(node4);
        linkedList.addByOrder(node3);
        linkedList.addByOrder(node2);
//        System.out.println("====����ǰ====");
        linkedList.findAllLink();
       /* // ����
        HeroNode node5 = new HeroNode(1, "¬����", "������");
        linkedList.updateLink(node5);
        // ����
        System.out.println("====���º�====");
        linkedList.findAllLink();*/

        // ɾ��
        int no = 1;
        linkedList.deleteLink(no);
        linkedList.findAllLink();
    }
}

/**
 * ��������
 */
class SingleLinkedList {
    private HeroNode head = null;

    public SingleLinkedList() {
        // ͷ���
        head = new HeroNode(0, "", "");
    }

    /**
     * ����Ԫ��
     */
    public void addLink(HeroNode heroNode) {
        // ��ʱ����������Ѱ��β�ڵ�
        HeroNode temp = head;
        /*δ�Ż���*/
        while (true) {
            // �����ǰΪβ���
            if (temp.next == null) {
                heroNode.next = null;
                temp.next = heroNode;
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
    public void addByOrder(HeroNode heroNode) {
        // ��Ϊͷ��㲻�ܶ���������Ҫ��������temp���ҵ����λ��
        // ��Ϊ�ǵ��������������ҵ� temp ��λ�� ���λ�õ�ǰһ���ڵ㣬������Ӳ���
        HeroNode temp = head;
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
            temp.next = heroNode;
            System.out.println("��ӳɹ���");
            return;
        }
    }

    /**
     * �޸Ľڵ���Ϣ
     * 1�����(no)���ܸ���
     */
    public void updateLink(HeroNode heroNode) {
        if (isEmpty()) {
            System.out.println("����Ϊ��,û�п��Ը��ĵ�Ԫ�أ�");
            return;
        }
        HeroNode temp = head;
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
    public void deleteLink(int no) {
        if (isEmpty()) {
            System.out.println("�Բ�������Ϊ�գ��޿�ɾ�����󣡣���");
            return;
        }
        HeroNode temp = head;
        // ���� temp ��ֵ
        HeroNode front = temp;
        // �Ƿ��ҵ���ɾ���ڵ��ǰһ���ڵ�
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
            front = temp;
            temp = temp.next;
        }

        if (flag) {
            front.next = temp.next;
            System.out.println("ɾ���ɹ�����ţ�" + temp.no);
            return;
        } else {
            System.out.println("������˼��û���ҵ���ţ�" + no + "�Ľڵ�");
        }
    }

    /**
     * ����ȫ��Ԫ��
     */
    public void findAllLink() {
        HeroNode temp = head.next;
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
 * ����HeroNode��ÿһ�� HeroNode �������һ���ڵ�
 */
class HeroNode {
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
     * ָ����ָ����һ���ڵ�
     */
    public HeroNode next;

    /**
     * ������
     *
     * @param no
     * @param name
     * @param nickname
     */
    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;

    }

    public HeroNode() {

    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}

