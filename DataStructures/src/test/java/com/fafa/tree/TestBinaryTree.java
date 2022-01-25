package com.fafa.tree;

import org.junit.Test;

/**
 * ������������
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-22 17:51
 */
public class TestBinaryTree {
    // �����ڵ�
    HeroNode root = new HeroNode(1, "�ν�");
    HeroNode node2 = new HeroNode(2, "����");
    HeroNode node3 = new HeroNode(3, "¬����");
    HeroNode node4 = new HeroNode(4, "�ֳ�");
    HeroNode node5 = new HeroNode(5, "��ʤ");

    /**
     * ���Ա���
     */
    @Test
    public void test01() {
        // ���ֶ����ɶ�������������õݹ������ɣ���ʱ���ֶ���
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        // ����������
        BinaryTree tree = new BinaryTree(root);
        // ����ǰ�����
        System.out.println("ǰ�����");
        tree.preOrder();
        // �����������
        System.out.println("�������");
        tree.infixOrder();
        // ���Ժ������
        System.out.println("�������");
        tree.postOrder();
    }

    /**
     * ���Բ���
     */
    @Test
    public void test02() {
        // ���ֶ����ɶ�������������õݹ������ɣ���ʱ���ֶ���
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        // ����������
        BinaryTree tree = new BinaryTree(root);
        int no = 15;
        // ����ǰ�����
        System.out.println("ǰ�����");
        HeroNode resNode = tree.preOrderSearch(no);
        if (resNode != null) {
            System.out.println("���Ϊ��" + resNode);
        }
        // �����������
        System.out.println("�������");
        resNode = tree.infixOrderSearch(no);
        if (resNode != null) {
            System.out.println("���Ϊ��" + resNode);
        }
        // ���Ժ������
        System.out.println("�������");
        resNode = tree.postOrderSearch(no);
        if (resNode != null) {
            System.out.println("���Ϊ��" + resNode);
        }
    }

    /**
     * ����ɾ��
     */
    @Test
    public void test03() {
        // ���ֶ����ɶ�������������õݹ������ɣ���ʱ���ֶ���
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        // ����������
        BinaryTree tree = new BinaryTree(root);
        int no = 3;
        tree.delNode(no);
        System.out.println("ɾ����Ľ��");
        tree.preOrder();
    }


}
