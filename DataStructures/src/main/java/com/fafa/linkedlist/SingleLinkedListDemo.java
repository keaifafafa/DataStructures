package com.fafa.linkedlist;

import sun.font.StrikeCache;

import java.util.Stack;

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
        HeroNode node5 = new HeroNode(5, "�ֳ�5", "����ͷ5");
        HeroNode node6 = new HeroNode(6, "�ֳ�6", "����ͷ6");
        HeroNode node7 = new HeroNode(7, "�ֳ�7", "����ͷ7");
        HeroNode node8 = new HeroNode(8, "�ֳ�8", "����ͷ8");
        // ��ʼ������
        SingleLinkedList linkedList = new SingleLinkedList();
        SingleLinkedList linkedList1 = new SingleLinkedList();

        // ���Ӣ��
        /*linkedList.addByOrder(node1);
        linkedList.addByOrder(node4);
        linkedList.addByOrder(node4);
        linkedList.addByOrder(node3);
        linkedList.addByOrder(node3);
        linkedList.addByOrder(node2);*/

       /* linkedList.addLink(node1);
        linkedList.addLink(node4);
        linkedList.addLink(node2);
        linkedList.addLink(node3);*/
//        System.out.println("====����ǰ====");
//        linkedList.findAllLink();
       /* // ����
        HeroNode node5 = new HeroNode(1, "¬����", "������");
        linkedList.updateLink(node5);
        // ����
        System.out.println("====���º�====");
        linkedList.findAllLink();*/

        // ɾ��
       /* int no = 1;
        linkedList.deleteLink(no);
        linkedList.findAllLink();*/

        // ͳ�ƽڵ���Ч����
//        System.out.println("��Ч��Ӣ�۽ڵ���Ϊ��" + getValidNode(linkedList.getHead()));

        // ���ҵ������е� ���� ��k�����
        /*int k = 4;
        System.out.println("Ӣ����ϢΪ��" + findInverseNode(linkedList.getHead(), k));*/

        // ��������
       /* System.out.println("��������");
        HeroNode reverseLink = reverseLink(linkedList.getHead());
        queryAll(reverseLink);*/

        // �������ӡ����
       /* System.out.println("���Է��������ӡ");
        Stack<HeroNode> nodeStack = reservePrintLink(linkedList.getHead());
        getAllStack(nodeStack);*/

        /*** =========== ������5���� ==============  ***/
        // ��������������ͬ������
        linkedList.addLink(node2);
       /* linkedList.addLink(node3);
        linkedList.addLink(node7);*/
        linkedList.addLink(node3);

        linkedList1.addLink(node1);
       /* linkedList1.addLink(node4);
        linkedList1.addLink(node5);*/
        linkedList1.addLink(node6);

        HeroNode mergeOrderLink = mergeOrderLink(linkedList.getHead(), linkedList1.getHead());
        queryAll(mergeOrderLink);

    }

    /**
     * ����������1����ȡ���������ЧԪ�ظ���
     * ˼·:ֱ�ӱ���������Ҫ�ų�ͷ��㣩
     */
    public static int getValidNode(HeroNode head) {
        int num = 0;
        if (head.next == null) {
            return num;
        }
        // �ų�ͷ���
        HeroNode temp = head.next;
        while (temp != null) {
            // ��Ч�ڵ���+1
            num++;
            // ����
            temp = temp.next;
        }
        return num;
    }

    /**
     * ����������2�����ҵ������е� ���� ��k����� �����������⡿
     * ˼·��
     * 1�����Ȼ�ȡ��Ч�Ľڵ��������� ���� �ڼ�λת���� ���� �ڼ�λ
     * 2������ѭ������������һ���ڱ���������Ȼ��������Ľ��бȶԣ���ȼ�Ϊ�ҵ�Ŀ�꣡
     */
    public static HeroNode findInverseNode(HeroNode head, int n) {
        if (head.next == null) {
            return null;
        }
        // �ų�ͷ���
        HeroNode cur = head.next;
        int validNum = getValidNode(head);
        boolean flag = false;
        // ���� ��������ĺϷ���У��
        if (n > validNum || n < 0) {
            return null;
        }
        // ת���� ���� ��
        n = validNum - n;
        // �����õ��ڱ�
        int count = 0;
        // ��Ȼ����Ҳ������forѭ��
        while (true) {
            if (cur == null) {
                break;
            }
            if (n == count) {
                // �ҵ�Ŀ��
                flag = true;
                break;
            }
            count++;
            // ����
            cur = cur.next;
        }
        if (flag) {
            return cur;
        }
        return null;
    }

    /**
     * ����������3��������ķ�ת����Ѷ�����⣬�е��Ѷȡ�
     * ˼·��
     * 1�����ȶ���һ���µĽڵ㣨cur��
     * 2��Ȼ�����ԭ����head�ڵ㣬û����һ���ڵ㣬�ͽ�����ӵ�cur�У�ֻ����Ҫ��ͷ�巨������
     */
    public static HeroNode reverseLink(HeroNode head) {
        // ��ֻ��һ���ڵ㣬����һ���ڵ㶼û��ʱ
        if (head.next == null || head.next.next == null) {
            System.out.println("���跴ת");
            return head;
        }
        // ������������ģ�ԭ��������
        HeroNode temp = head.next;
        // �洢��ʱ��temp������ע�������ǵ�ַ���ݣ�
        HeroNode copy = null;
        // �洢���������
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (temp != null) {
            // ��ֵ ��ע�������ǵ�ַ���ݣ�����ֵ���ݣ�
            copy = temp;
            // ����
            temp = temp.next;
            // ͷ�巨
            copy.next = reverseHead.next;
            reverseHead.next = copy;
        }
        return reverseHead;
    }

    /**
     * ��ѯȫ���ڵ�
     *
     * @param head
     */
    public static void queryAll(HeroNode head) {
        HeroNode temp = head.next;
        int i = 1;
        if (head.next == null) {
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
     * ����������4����β��ͷ��ӡ������ ���ٶȣ�Ҫ��ʽ1��������� �� ��ʽ2��Stackջ��
     */
    public static Stack<HeroNode> reservePrintLink(HeroNode head) {
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head.next;
        if (head.next == null) {
            System.out.println("��ǰ����Ϊ�գ������ݿ��Դ�ӡ��");
            return null;
        }
        while (temp != null) {
            // ��ջ
            stack.push(temp);
            // ����
            temp = temp.next;
        }
        return stack;
    }

    /**
     * ѭ������Stack
     */
    public static void getAllStack(Stack stack) {
        while (stack.size() > 0) {
            System.out.println(stack.pop() + "��ջ");
        }
    }

    /**
     * ����������5:�ϲ���������ĵ������ϲ�֮���������Ȼ���򡾿κ���ϰ.��
     * ˼·��
     * 1�� ѭ��������������Ȼ��Ƚ���ӦԪ�أ�Ԫ�ؽ�С���ȼ��룬��������ƶ�һλ��������������������ƶ����Ԫ�ؽ��бȽ�
     * 2��
     */
    public static HeroNode mergeOrderLink(HeroNode head1, HeroNode head2) {
        // ѭ�����������������ʱ�ڵ�
        HeroNode temp1 = head1.next;
        HeroNode temp2 = head2.next;
        // �ϲ��ڵ�
        HeroNode mergeNode = new HeroNode(0, "", "");
        HeroNode temp3 = mergeNode;
        // ��ǰ�ڵ㣨���ڴ洢�����ڵ�ĵ�ַ��
        HeroNode cur = null;
        while (true) {
            if (temp1 == null && temp2 == null){
                break;
            }
            if (temp1.no < temp2.no) {
                // �洢temp1�ĵ�ַ
                cur = temp1;
                // ����
                temp1 = temp1.next;
                // ���(β�巨)
                temp3.next = cur;
                cur.next = null;
                temp3 = temp3.next;
            }else if(temp1.no > temp2.no){
                // �洢temp2�ĵ�ַ
                cur = temp2;
                // ����
                temp2 = temp2.next;
                // ���(β�巨)
                temp3.next = cur;
                cur.next = null;
                temp3 = temp3.next;
            }
        }
        return mergeNode;
    }

}

/**
 * ��������
 */
class SingleLinkedList {
    private HeroNode head = null;

    /**
     * ��ȡͷ���
     */
    public HeroNode getHead() {
        return head;
    }

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

