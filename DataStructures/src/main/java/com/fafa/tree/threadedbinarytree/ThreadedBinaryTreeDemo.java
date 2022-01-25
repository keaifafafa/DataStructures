package com.fafa.tree.threadedbinarytree;

import lombok.Data;

/**
 * ������������
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-23 21:34
 */
public class ThreadedBinaryTreeDemo {

    public static void main(String[] args) {
        HeroNode root = new HeroNode(1);
        HeroNode node2 = new HeroNode(3);
        HeroNode node3 = new HeroNode(6);
        HeroNode node4 = new HeroNode(8);
        HeroNode node5 = new HeroNode(10);
        HeroNode node6 = new HeroNode(14);
        // �������������ֶ���
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        // ��������������
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree(root);
        threadedBinaryTree.threadedBinaryTree(root);
        // ���Խڵ�
        HeroNode test = node5;
        System.out.println("��ǰ�ڵ�Ϊ��" + test);
        System.out.println("ǰ���ڵ�Ϊ��" + test.getLeft());
        System.out.println("��̽ڵ�Ϊ��" + test.getRight());
        // ���Ա��������������������
        threadedBinaryTree.infixThreaded();

    }
}

/**
 * ����������������
 */
class ThreadedBinaryTree {

    HeroNode root = null;

    /**
     * ǰ�����
     */
    HeroNode pre = null;

    public ThreadedBinaryTree(HeroNode root) {
        this.root = root;
    }

    /**
     * ���������������������������
     */
    public void infixThreaded() {
        HeroNode node = root;
        // ��ʵ��һ���ߣ�����
        while (node != null) {
            // ����Ѱ��ͷ����Ԫ��
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            // leftType == 1
            System.out.println(node);
            // ���������ָ����Ǻ�̽ڵ㣬��ֱ���������
            while (node.getRightType() == 1) {
                // ����һ�ڵ㣨��̣�������ӡ
                node = node.getRight();
                System.out.println(node);
            }
            // �����Ҫ����������һ����̽ڵ�
            node = node.getRight();
        }
    }

    /**
     * ����������������������
     * ˼·:
     * 1���ȴ�����������ǰ�����󣩣��ڴ����̣��ң�
     *
     * @param node
     */
    public void threadedBinaryTree(HeroNode node) {
        // �ݹ�ͷ
        if (node == null) {
            return;
        }
        // ��һ���ȴ���������(������)
        threadedBinaryTree(node.getLeft());
        // ����������ǰ�ڵ��ǰ���ڵ�
        // �Խڵ�8Ϊ���ӣ� 8 ��left�ڵ� = null, 8 �� leftType = 1
        if (node.getLeft() == null) {
            // �õ�ǰָ�����ָ��ָ��ǰ�����
            node.setLeft(pre);
            // �޸ĵ�ǰ�ڵ����ָ������ͣ�ָ��ǰ�����
            node.setLeftType(1);
        }
        // �����̽ڵ㣬���ڶ������ǵ���ģ�������Ҫ����ǰ���ڵ㣬����ָ�� node������Ľڵ㣩
        // pre != null ��Ŀ����Ϊ�˱�֤��һ��Ԫ�ص�ǰ���ڵ�Ϊnull Ҳ���ǵ�ǰ��Ԫ�� 8
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        // ��pre��ֵ����Ϊ��һ���ݹ飨δ��������ǰ���ڵ㣨����ģ�
        pre = node;
        // ���������������������������
        threadedBinaryTree(node.getRight());
    }

}

/**
 * Ӣ�۽ڵ�
 */
@Data
class HeroNode {
    private int id;

    private HeroNode left;
    private HeroNode right;
    /**
     * ˵��
     * 1�����leftType == 0 ��ʾָ������������������ 1 ��ʾָ�����ǰ���ڵ�
     * 2�����rightType == 0 ��ʾָ������������������ 1 ��ʾָ����Ǻ�̽ڵ�
     */
    private int leftType;
    private int rightType;


    /**
     * ���췽����Ĭ�������ҽڵ�Ϊ��
     *
     * @param id
     */
    public HeroNode(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", leftType=" + leftType +
                ", rightType=" + rightType +
                '}';
    }

    /**
     * ǰ�����
     * ˼·��
     * 1���ٴ�ӡ���ڵ�
     * 2��Ȼ���ж��������Ƿ�Ϊ�գ���Ϊ�յĻ����ݹ��ӡ
     * 3���ж��������Ƿ�Ϊ�գ���Ϊ�յĻ����ݹ��ӡ
     */
    public void preOrder() {
        // Ϊʲô����ֱ�Ӵ�ӡ�������жϸ��ڵ��أ���Ϊ�������Ŀ϶���һ����Ч�Ľڵ㣬���Բ����жϣ�����һ���ò��Ѿ������ж��ˣ�
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * �������
     * ˼·��
     * 1�����ж��������Ƿ�Ϊ�գ���Ϊ�յĻ����ݹ��ӡ
     * 2���ٴ�ӡ���ڵ�
     * 3���ж��������Ƿ�Ϊ�գ���Ϊ�յĻ����ݹ��ӡ
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    /**
     * �������
     * ˼·��
     * 1�����ж��������Ƿ�Ϊ�գ���Ϊ�յĻ����ݹ��ӡ
     * 2���ж��������Ƿ�Ϊ�գ���Ϊ�յĻ����ݹ��ӡ
     * 3���ٴ�ӡ���ڵ�
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * ǰ���������
     *
     * @param no ���
     * @return
     */
    public HeroNode preOrderSearch(int no) {
        System.out.println("get into preSearch~");
        // �Ƚϵ�ǰ�ڵ��ǲ���
        if (this.getId() == no) {
            return this;
        }
        // ����ڵ�
        HeroNode resNode = null;
        // �Ƚ����ӽڵ�
        // �ͱ�����˼·��ͬС��
        // 1���жϵ�ǰ�����Լ�����Ƿ�Ϊ�գ��粻Ϊ��������������ң��ݹ飩
        // 2�������ӽڵ��ҵ��������ֱ�ӷ���
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        // �����Ϊ�գ�˵�����������ҵ���
        if (resNode != null) {
            return resNode;
        }
        // ͬ�ϣ�ֻ�������ֱ�ӷ���resNode���ɣ���Ϊ�����ҵ�û������resNode
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    /**
     * �����������
     *
     * @param no ���
     * @return
     */
    public HeroNode infixOrderSearch(int no) {
        // ����ڵ�
        HeroNode resNode = null;
        // �Ƚ����ӽڵ�
        // �ͱ�����˼·��ͬС��
        // 1���жϵ�ǰ�����Լ�����Ƿ�Ϊ�գ��粻Ϊ��������������ң��ݹ飩
        // 2�������ӽڵ��ҵ��������ֱ�ӷ���
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        // �����Ϊ�գ�˵�����������ҵ���
        if (resNode != null) {
            return resNode;
        }
        // Ҫ���ڱȽ����ǰ�棬���ܵ�����д����ǰ�棨��Ϊͳ�Ƶ��ǱȽϴ�����
        System.out.println("get into infixSearch~");
        // �Ƚϵ�ǰ�ڵ��ǲ���
        if (this.getId() == no) {
            return this;
        }
        // ͬ�ϣ�ֻ�������ֱ�ӷ���resNode���ɣ���Ϊ�����ҵ�û������resNode
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    /**
     * �����������
     *
     * @param no ���
     * @return
     */
    public HeroNode postOrderSearch(int no) {

        // ����ڵ�
        HeroNode resNode = null;
        // �Ƚ����ӽڵ�
        // �ͱ�����˼·��ͬС��
        // 1���жϵ�ǰ�����Լ�����Ƿ�Ϊ�գ��粻Ϊ��������������ң��ݹ飩
        // 2�������ӽڵ��ҵ��������ֱ�ӷ���
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        // �����Ϊ�գ�˵�����������ҵ���
        if (resNode != null) {
            return resNode;
        }
        // ͬ�ϣ�ֻ�������ֱ�ӷ���resNode���ɣ���Ϊ�����ҵ�û������resNode
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        // Ҫ���ڱȽ����ǰ�棬���ܵ�����д����ǰ�棨��Ϊͳ�Ƶ��ǱȽϴ�����
        System.out.println("get into postSearch~");
        // �������������û�ҵ�
        if (this.getId() == no) {
            return this;
        }
        return null;
    }

    /**
     * �ݹ�ɾ���ڵ�
     * 1�������Ҫɾ���Ľڵ���Ҷ�ӽ��Ļ�����ֱ��ɾ���ýڵ㼴��
     * 2�����ɾ���Ľڵ��Ƿ�Ҷ�ӽڵ㣬��ɾ��������
     */
    public void delNode(int no) {
        //˼·
		/*
		 * 	1. ��Ϊ���ǵĶ������ǵ���ģ������������жϵ�ǰ�����ӽ���Ƿ���Ҫɾ����㣬������ȥ�жϵ�ǰ�������ǲ�����Ҫɾ�����.
			2. �����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.left = null; ���Ҿͷ���(�����ݹ�ɾ��)
			3. �����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�� ����Ҫɾ����㣬�ͽ�this.right= null ;���Ҿͷ���(�����ݹ�ɾ��)
			4. �����2�͵�3��û��ɾ����㣬��ô���Ǿ���Ҫ�����������еݹ�ɾ��
			5.  �����4��Ҳû��ɾ����㣬��Ӧ�������������еݹ�ɾ��.

		 */
        if (this.left != null && this.left.getId() == no) {
            // ��Ϊ��
            this.setLeft(null);
            return;
        }
        if (this.right != null && this.right.getId() == no) {
            this.setRight(null);
            return;
        }
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
    }

}


