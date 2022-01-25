package com.fafa.tree;

/**
 * ������
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-22 16:51
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        // �������� test����
    }

}

/**
 * ����������
 */
class BinaryTree {

    HeroNode root = null;

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    /**
     * ǰ�����
     */
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("����һ�ſ���");
        }
    }

    /**
     * �������
     */
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("����һ�ſ���");
        }
    }

    /**
     * �������
     */
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("����һ�ſ���");
        }
    }

    /**
     * ǰ���������
     *
     * @param no
     * @return
     */
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    /**
     * �����������
     *
     * @param no
     * @return
     */
    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    /**
     * �����������
     *
     * @param no
     * @return
     */
    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    /**
     * ɾ���ڵ�
     *
     * @param no
     */
    public void delNode(int no) {
        if (root != null) {
            if (root.getId() == no) {
                root = null;
            } else {
                root.delNode(no);
            }
        } else {
            System.out.println("�������޷�ɾ��~");
        }
    }


}

/**
 * Ӣ�۽ڵ�
 */
class HeroNode {
    private int id;
    private String name;
    private HeroNode left;
    private HeroNode right;

    /**
     * ���췽����Ĭ�������ҽڵ�Ϊ��
     *
     * @param id
     * @param name
     */
    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
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
