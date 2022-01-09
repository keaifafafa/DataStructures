package com.fafa.linkedlist;

import sun.font.StrikeCache;

import java.util.Stack;

/**
 * 单链表
 *
 * @author Sire
 * @version 1.0
 * @date 2021-12-30 14:55
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "李逵", "黑旋风");
        HeroNode node2 = new HeroNode(2, "宋江", "及时雨");
        HeroNode node3 = new HeroNode(3, "吴用", "智多星");
        HeroNode node4 = new HeroNode(4, "林冲", "豹子头");
        HeroNode node5 = new HeroNode(5, "林冲5", "豹子头5");
        HeroNode node6 = new HeroNode(6, "林冲6", "豹子头6");
        HeroNode node7 = new HeroNode(7, "林冲7", "豹子头7");
        HeroNode node8 = new HeroNode(8, "林冲8", "豹子头8");
        // 初始化链表
        SingleLinkedList linkedList = new SingleLinkedList();
        SingleLinkedList linkedList1 = new SingleLinkedList();

        // 添加英雄
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
//        System.out.println("====更新前====");
//        linkedList.findAllLink();
       /* // 更新
        HeroNode node5 = new HeroNode(1, "卢俊义", "玉麒麟");
        linkedList.updateLink(node5);
        // 遍历
        System.out.println("====更新后====");
        linkedList.findAllLink();*/

        // 删除
       /* int no = 1;
        linkedList.deleteLink(no);
        linkedList.findAllLink();*/

        // 统计节点有效个数
//        System.out.println("有效的英雄节点数为：" + getValidNode(linkedList.getHead()));

        // 查找单链表中的 倒数 第k个结点
        /*int k = 4;
        System.out.println("英雄信息为：" + findInverseNode(linkedList.getHead(), k));*/

        // 反向链表
       /* System.out.println("反向链表");
        HeroNode reverseLink = reverseLink(linkedList.getHead());
        queryAll(reverseLink);*/

        // 反方向打印链表
       /* System.out.println("测试反向链表打印");
        Stack<HeroNode> nodeStack = reservePrintLink(linkedList.getHead());
        getAllStack(nodeStack);*/

        /*** =========== 面试题5测试 ==============  ***/
        // 首先生成两个不同的链表
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
     * 常见面试题1：获取单链表的有效元素个数
     * 思路:直接遍历（但是要排除头结点）
     */
    public static int getValidNode(HeroNode head) {
        int num = 0;
        if (head.next == null) {
            return num;
        }
        // 排除头结点
        HeroNode temp = head.next;
        while (temp != null) {
            // 有效节点数+1
            num++;
            // 后移
            temp = temp.next;
        }
        return num;
    }

    /**
     * 常见面试题2：查找单链表中的 倒数 第k个结点 【新浪面试题】
     * 思路：
     * 1、首先获取有效的节点数，并将 倒数 第几位转换成 正数 第几位
     * 2、利用循环遍历，设置一个哨兵来计数，然后和正数的进行比对，相等即为找到目标！
     */
    public static HeroNode findInverseNode(HeroNode head, int n) {
        if (head.next == null) {
            return null;
        }
        // 排除头结点
        HeroNode cur = head.next;
        int validNum = getValidNode(head);
        boolean flag = false;
        // 对于 请求参数的合法性校验
        if (n > validNum || n < 0) {
            return null;
        }
        // 转换成 正数 的
        n = validNum - n;
        // 计数用的哨兵
        int count = 0;
        // 当然这里也可以用for循环
        while (true) {
            if (cur == null) {
                break;
            }
            if (n == count) {
                // 找到目标
                flag = true;
                break;
            }
            count++;
            // 后移
            cur = cur.next;
        }
        if (flag) {
            return cur;
        }
        return null;
    }

    /**
     * 常见面试题3：单链表的反转【腾讯面试题，有点难度】
     * 思路：
     * 1、首先定义一个新的节点（cur）
     * 2、然后遍历原来的head节点，没遍历一个节点，就将其添加到cur中，只不过要用头插法！！！
     */
    public static HeroNode reverseLink(HeroNode head) {
        // 当只有一个节点，或者一个节点都没有时
        if (head.next == null || head.next.next == null) {
            System.out.println("无需反转");
            return head;
        }
        // 遍历正向链表的（原来的链表）
        HeroNode temp = head.next;
        // 存储临时的temp变量（注意事项是地址传递）
        HeroNode copy = null;
        // 存储反向链表的
        HeroNode reverseHead = new HeroNode(0, "", "");
        while (temp != null) {
            // 赋值 （注意这里是地址传递，并非值传递）
            copy = temp;
            // 后移
            temp = temp.next;
            // 头插法
            copy.next = reverseHead.next;
            reverseHead.next = copy;
        }
        return reverseHead;
    }

    /**
     * 查询全部节点
     *
     * @param head
     */
    public static void queryAll(HeroNode head) {
        HeroNode temp = head.next;
        int i = 1;
        if (head.next == null) {
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
     * 常见面试题4：从尾到头打印单链表 【百度，要求方式1：反向遍历 。 方式2：Stack栈】
     */
    public static Stack<HeroNode> reservePrintLink(HeroNode head) {
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head.next;
        if (head.next == null) {
            System.out.println("当前链表为空，无数据可以打印！");
            return null;
        }
        while (temp != null) {
            // 入栈
            stack.push(temp);
            // 后移
            temp = temp.next;
        }
        return stack;
    }

    /**
     * 循环遍历Stack
     */
    public static void getAllStack(Stack stack) {
        while (stack.size() > 0) {
            System.out.println(stack.pop() + "出栈");
        }
    }

    /**
     * 常见面试题5:合并两个有序的单链表，合并之后的链表依然有序【课后练习.】
     * 思路：
     * 1、 循环遍历两个链表，然后比较相应元素，元素较小的先加入，并且向后移动一位，大的链表不动，继续和移动完的元素进行比较
     * 2、
     */
    public static HeroNode mergeOrderLink(HeroNode head1, HeroNode head2) {
        // 循环遍历两个链表的临时节点
        HeroNode temp1 = head1.next;
        HeroNode temp2 = head2.next;
        // 合并节点
        HeroNode mergeNode = new HeroNode(0, "", "");
        HeroNode temp3 = mergeNode;
        // 当前节点（用于存储遍历节点的地址）
        HeroNode cur = null;
        while (true) {
            if (temp1 == null && temp2 == null){
                break;
            }
            if (temp1.no < temp2.no) {
                // 存储temp1的地址
                cur = temp1;
                // 后移
                temp1 = temp1.next;
                // 添加(尾插法)
                temp3.next = cur;
                cur.next = null;
                temp3 = temp3.next;
            }else if(temp1.no > temp2.no){
                // 存储temp2的地址
                cur = temp2;
                // 后移
                temp2 = temp2.next;
                // 添加(尾插法)
                temp3.next = cur;
                cur.next = null;
                temp3 = temp3.next;
            }
        }
        return mergeNode;
    }

}

/**
 * 创建链表
 */
class SingleLinkedList {
    private HeroNode head = null;

    /**
     * 获取头结点
     */
    public HeroNode getHead() {
        return head;
    }

    public SingleLinkedList() {
        // 头结点
        head = new HeroNode(0, "", "");
    }

    /**
     * 插入元素
     */
    public void addLink(HeroNode heroNode) {
        // 临时变量，用来寻找尾节点
        HeroNode temp = head;
        /*未优化的*/
        while (true) {
            // 如果当前为尾结点
            if (temp.next == null) {
                heroNode.next = null;
                temp.next = heroNode;
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
    public void addByOrder(HeroNode heroNode) {
        // 因为头结点不能动，所以需要辅助变量temp来找到添加位置
        // 因为是单链表，所以我们找的 temp 是位于 添加位置的前一个节点，否则添加不了
        HeroNode temp = head;
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
            temp.next = heroNode;
            System.out.println("添加成功！");
            return;
        }
    }

    /**
     * 修改节点信息
     * 1、编号(no)不能更改
     */
    public void updateLink(HeroNode heroNode) {
        if (isEmpty()) {
            System.out.println("链表为空,没有可以更改的元素！");
            return;
        }
        HeroNode temp = head;
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
    public void deleteLink(int no) {
        if (isEmpty()) {
            System.out.println("对不起，链表为空，无可删除对象！！！");
            return;
        }
        HeroNode temp = head;
        // 保留 temp 的值
        HeroNode front = temp;
        // 是否找到带删除节点的前一个节点
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
            front = temp;
            temp = temp.next;
        }

        if (flag) {
            front.next = temp.next;
            System.out.println("删除成功，编号：" + temp.no);
            return;
        } else {
            System.out.println("不好意思，没有找到编号：" + no + "的节点");
        }
    }

    /**
     * 遍历全部元素
     */
    public void findAllLink() {
        HeroNode temp = head.next;
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
 * 定义HeroNode，每一个 HeroNode 对象就是一个节点
 */
class HeroNode {
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
     * 指针域，指向下一个节点
     */
    public HeroNode next;

    /**
     * 构造器
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

