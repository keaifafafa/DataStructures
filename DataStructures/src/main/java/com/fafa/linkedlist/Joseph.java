package com.fafa.linkedlist;

/**
 * Լɪ������
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-04 18:26
 */
public class Joseph {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();
        // ���
        list.addNodeToCircle(5);
        // ����
//        list.getAllNode();

        // ����Լɪ������
        list.countBoy(1,2,5);
    }
}

/**
 * ��������������
 */
class CircleSingleLinkedList {
    /**
     * ����ͷ���
     */
    private Boy first = null;

    /**
     * ��ʼ��
     */
    public CircleSingleLinkedList() {
    }

    /**
     * ���ڵ���ӵ����ε���������
     *
     * @param nums ��Ҫ��ӵ�����
     */
    public void addNodeToCircle(int nums) {
        // ���ȼ�������Ƿ�Ϸ�
        if (nums < 1) {
            System.out.println("numsӦ�ô��ڵ���1");
            return;
        }
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            // �����ڵ�
            Boy boy = new Boy(i);
            // ��������1
            if (i == 1) {
                // ��ͷ�����boy������boy��nextָ��first��
                first = boy;
                boy.setNext(first);
                // ������һ���ڵ�����
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                // �൱�ں���
                curBoy = boy;
            }
        }
    }

    /**
     * �������нڵ�
     */
    public void getAllNode() {
        // �ж��Ƿ�Ϊ��
        if(first == null){
            System.out.println("����Ϊ�գ�");
            return;
        }
        // �����ڵ�
        Boy temp = first;
        while (true) {
            if (temp.getNext() == first) {
                System.out.println(temp.toString());
                break;
            }
            System.out.println(temp.toString());
            // ����
            temp = temp.getNext();
        }
    }

    /**
     * С���ѳ�Ȧ
     * @param startNo ��ʼ��λ��
     * @param countNum ��Ȧ������
     * @param nums С���ѵ�����
     */
    public void countBoy(int startNo,int countNum,int nums){
        // �ȶԴ������ֽ���У��
        if(startNo < 1 || countNum > nums || nums < 1){
            System.out.println("����������Ϸ���");
            return;
        }
        // �Ȱ� cur �ŵ�firstλ��
        Boy cur = first;
        Boy helper = first;
        // helper �ŵ� first��ǰһ��λ��
        while(helper.getNext() != first){
            // ����
            helper = helper.getNext();
        }
        // �� cur �� helper �ƶ��� �涨λ�ã�startNo������Ϊ�������λ��1������ֻ��Ҫ�ƶ�startNo - 1��
        for (int i = 0; i < startNo - 1; i++){
            cur = cur.getNext();
            helper = helper.getNext();
        }
        // ��ʼ�ú��ӳ�Ȧ
        while(true){
            // ��Ϸ���������˶�������δ��Ȧ�ĺ��ӣ�
            if (cur == helper){
                break;
            }
            // �ƶ�countNum - 1�Σ��൱������
            for (int i = 0; i < countNum - 1; i++){
                // ����
                cur = cur.getNext();
                helper = helper.getNext();
            }
            // ��Ȧ
            System.out.printf("��%d��С���ѳ�Ȧ\n",cur.getNo());
            cur = cur.getNext();
            helper.setNext(cur);
        }
        System.out.printf("���˶��ǵ�%d��С����\n",cur.getNo());
    }
}

/**
 * Boy��
 */
class Boy {
    /**
     * ���
     */
    private int no;
    /**
     * ָ����
     */
    private Boy next;

    /**
     * ���췽��
     *
     * @param no
     */
    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
