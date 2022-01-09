package com.fafa.linkedlist;

/**
 * 双向链表
 * @author Sire
 * @version 1.0
 * @date 2022-01-04 15:53
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        DoubleHeroNode node1 = new DoubleHeroNode(1, "李逵", "黑旋风");
        DoubleHeroNode node2 = new DoubleHeroNode(2, "宋江", "及时雨");;
        DoubleHeroNode node3 = new DoubleHeroNode(3, "吴用", "智多星");
        DoubleHeroNode node4 = new DoubleHeroNode(4, "林冲", "豹子头");

       /* doubleLinkedList.addNode(node1);
        doubleLinkedList.addNode(node2);
        doubleLinkedList.addNode(node3);
        doubleLinkedList.addNode(node4);
        System.out.println("添加后的结果：");
        doubleLinkedList.findAllNode();*/

        doubleLinkedList.addByOrder(node1);
        doubleLinkedList.addByOrder(node4);
        doubleLinkedList.addByOrder(node3);
        doubleLinkedList.addByOrder(node3);
        doubleLinkedList.addByOrder(node2);
        System.out.println("优化后的添加结果：");
        doubleLinkedList.findAllNode();

        DoubleHeroNode newNode = new DoubleHeroNode(4, "小冲", "林教头");
        System.out.println("修改后的结果：");
        doubleLinkedList.updateNode(newNode);
        doubleLinkedList.findAllNode();

        System.out.println("删除后的结果：");
        doubleLinkedList.deleteNode(3);
        doubleLinkedList.findAllNode();

    }
}

/**
 * 构建一个双向链表类
 */
class DoubleLinkedList{
    /**
     * 初始化一个头节点
     */
    private DoubleHeroNode head = new DoubleHeroNode(0,"","");

    /**
     * 返回头结点
     * @return
     */
    public DoubleHeroNode getHead() {
        return head;
    }

    /**
     * 插入元素
     */
    public void addNode(DoubleHeroNode heroNode) {
        // 临时变量，用来寻找尾节点
        DoubleHeroNode temp = head;
        /*未优化的*/
        while (true) {
            // 如果当前为尾结点
            if (temp.next == null) {
                heroNode.next = null;
                // 双向绑定
                temp.next = heroNode;
                heroNode.pre = temp;
                break;
            } else {
                // 后移搜索
                temp = temp.next;
            }
        }
    }

    /**
     * 优化后的添加方法
     */
    public void addByOrder(DoubleHeroNode heroNode) {
        // 因为头结点不能动，所以需要辅助变量temp来找到添加位置
        // 因为是单链表，所以我们找的 temp 是位于 添加位置的前一个节点，否则添加不了
        DoubleHeroNode temp = head;
        // 用于判断是否有重复排名英雄
        boolean flag = false;
        /*优化后的*/
        // 1、要按排名进行添加，不分先来后到
        // 2、排名不得重复
        // 3、while循环里只有查找遍历，并无添加操作
        while (true) {
            // 防止空指针,说明temp已经在链表最后了
            if (temp.next == null) {
                break;
            }
            // 和 当前位置的后一个比大小，如果小于后面的那个英雄的编号，那么就在此处添加即可
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                // 排名重复
                flag = true;
                break;
            }
            // 指针后移
            temp = temp.next;
        }

        if (flag) {
            System.out.println("排名已经重复，无法再次添加编号：" + heroNode.no);
            return;
        } else {
            // 添加操作
            heroNode.next = temp.next;
            heroNode.pre = temp;
            temp.next = heroNode;
            System.out.println("添加成功！");
            return;
        }
    }

    /**
     * 修改节点信息
     * 1、编号(no)不能更改
     */
    public void updateNode(DoubleHeroNode heroNode) {
        if (isEmpty()) {
            System.out.println("链表为空,没有可以更改的元素！");
            return;
        }
        DoubleHeroNode temp = head;
        // 作为一个哨兵，判断是否找到要修改的目标
        boolean flag = false;
        while (true) {
            // 到了链表的最后了，也就是都遍历完毕了
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            // 后移
            temp = temp.next;
        }

        if (flag) {
            temp.name = heroNode.name;
            temp.nickname = heroNode.nickname;
            return;
        } else {
            System.out.println("不好意思，没有定位到该元素，编号：" + heroNode.no);
            return;
        }
    }

    /**
     * 删除节点
     */
    public void deleteNode(int no) {
        if (isEmpty()) {
            System.out.println("对不起，链表为空，无可删除对象！！！");
            return;
        }
        DoubleHeroNode temp = head;
        // 是否找到待删除节点
        boolean flag = false;
        while (true) {
            // 已经到链表的最后
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
            // 删除·节点操作
            // 防止空指针异常
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }
            temp.pre.next = temp.next;
            System.out.println("删除成功，编号：" + temp.no);
            return;
        } else {
            System.out.println("不好意思，没有找到编号：" + no + "的节点");
        }
    }



    /**
     * 遍历全部元素
     */
    public void findAllNode() {
        DoubleHeroNode temp = head.next;
        int i = 1;
        if (isEmpty()) {
            System.out.println("当前链表为空，无数据可以打印！");
            return;
        }
        while (temp != null) {
            System.out.println("第" + i + "个英雄信息如下:" + temp.toString());
            // 后移
            temp = temp.next;
            i++;
        }
    }

    /**
     * 判断链表是否为空
     */
    public boolean isEmpty() {
        return head.next == null;
    }

}

/**
 * 定义DoubleHeroNode，每一个 DoubleHeroNode 对象就是一个节点
 */
class DoubleHeroNode {
    /**
     * 编号
     */
    public int no;
    /**
     * 英雄名字
     */
    public String name;
    /**
     * 英雄昵称
     */
    public String nickname;
    /**
     * 指针域，指向前一个节点
     */
    public DoubleHeroNode pre;
    /**
     * 指针域，指向下一个节点
     */
    public DoubleHeroNode next;

    /**
     * 构造器
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


