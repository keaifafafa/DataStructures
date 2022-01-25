package com.fafa.tree;

/**
 * ˳��洢������(����ת�ɶ�����)
 *
 * @author Sire
 * @version 1.0
 * @date 2022-01-23 20:37
 */
public class ArrBinaryTreeDemo {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        // ����ǰ�����
        System.out.println("ǰ����������");
        arrBinaryTree.preOrder();
        // �����������
        System.out.println("������������");
        arrBinaryTree.infixOrder();
        // ���Ժ������
        System.out.println("������������");
        arrBinaryTree.postOrder();
    }

}

/**
 * ˳��洢������
 */
class ArrBinaryTree{
    /**
     * ����������
     */
    int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * ǰ��������ط���
     */
    public void preOrder(){
        if (arr != null && arr.length != 0){
            preOrder(0);
        }else{
            System.out.println("���鲻���ڻ���Ϊ�գ��޷�������");
        }
    }

    /**
     * ǰ�����
     * ʵ��˼·��
     * 1����N��Ԫ�ص����ӽڵ�Ϊ ��2 * n + 1��
     * 2����N��Ԫ�ص����ӽڵ�Ϊ ��2 * n + 2��
     * 3����N��Ԫ�صĸ��ڵ�Ϊ    (n - 1) / 2
     * @param index
     */
    public void preOrder(int index){
        System.out.println(arr[index]);
        // ����ݹ����(����Ҫ��֤�±겻Խ��������)
        if ((index * 2 + 1) < arr.length){
            preOrder(2 * index + 1);
        }
        if ((index * 2 + 2) < arr.length){
            preOrder(2 * index + 2);
        }
    }

    /**
     * ����������ط���
     */
    public void infixOrder(){
        if (arr != null && arr.length != 0){
            infixOrder(0);
        }else{
            System.out.println("���鲻���ڻ���Ϊ�գ��޷�������");
        }
    }

    /**
     * �������
     * ʵ��˼·��
     * 1����������
     * 2���ڸ��ڵ�
     * 3�������������
     * @param index
     */
    public void infixOrder(int index){
        // ����ݹ����(����Ҫ��֤�±겻Խ��������)
        if ((index * 2 + 1) < arr.length){
            infixOrder(2 * index + 1);
        }
        System.out.println(arr[index]);
        if ((index * 2 + 2) < arr.length){
            infixOrder(2 * index + 2);
        }
    }

    /**
     * ����������ط���
     */
    public void postOrder(){
        if (arr != null && arr.length != 0){
            postOrder(0);
        }else{
            System.out.println("���鲻���ڻ���Ϊ�գ��޷�������");
        }
    }

    /**
     * �������
     * ʵ��˼·��
     * 1����������
     * 2����������
     * 3������Ǹ��ڵ�
     * @param index
     */
    public void postOrder(int index){
        // ����ݹ����(����Ҫ��֤�±겻Խ��������)
        if ((index * 2 + 1) < arr.length){
            postOrder(2 * index + 1);
        }
        if ((index * 2 + 2) < arr.length){
            postOrder(2 * index + 2);
        }
        System.out.println(arr[index]);
    }
}
