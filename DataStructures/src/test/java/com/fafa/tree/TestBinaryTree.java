package com.fafa.tree;

import org.junit.Test;

/**
 * 二叉树测试类
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-22 17:51
 */
public class TestBinaryTree {
    // 创建节点
    HeroNode root = new HeroNode(1, "宋江");
    HeroNode node2 = new HeroNode(2, "吴用");
    HeroNode node3 = new HeroNode(3, "卢俊义");
    HeroNode node4 = new HeroNode(4, "林冲");
    HeroNode node5 = new HeroNode(5, "吴胜");

    /**
     * 测试遍历
     */
    @Test
    public void test01() {
        // 先手动生成二叉树（后面会用递归来生成，暂时先手动）
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        // 创建二叉树
        BinaryTree tree = new BinaryTree(root);
        // 测试前序遍历
        System.out.println("前序遍历");
        tree.preOrder();
        // 测试中序遍历
        System.out.println("中序遍历");
        tree.infixOrder();
        // 测试后序遍历
        System.out.println("后序遍历");
        tree.postOrder();
    }

    /**
     * 测试查找
     */
    @Test
    public void test02() {
        // 先手动生成二叉树（后面会用递归来生成，暂时先手动）
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        // 创建二叉树
        BinaryTree tree = new BinaryTree(root);
        int no = 15;
        // 测试前序查找
        System.out.println("前序查找");
        HeroNode resNode = tree.preOrderSearch(no);
        if (resNode != null) {
            System.out.println("结果为：" + resNode);
        }
        // 测试中序查找
        System.out.println("中序查找");
        resNode = tree.infixOrderSearch(no);
        if (resNode != null) {
            System.out.println("结果为：" + resNode);
        }
        // 测试后序查找
        System.out.println("后序查找");
        resNode = tree.postOrderSearch(no);
        if (resNode != null) {
            System.out.println("结果为：" + resNode);
        }
    }

    /**
     * 测试删除
     */
    @Test
    public void test03() {
        // 先手动生成二叉树（后面会用递归来生成，暂时先手动）
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        // 创建二叉树
        BinaryTree tree = new BinaryTree(root);
        int no = 3;
        tree.delNode(no);
        System.out.println("删除后的结果");
        tree.preOrder();
    }


}
