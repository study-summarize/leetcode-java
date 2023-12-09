package org.github.fourth.struct.linkedlist;

public interface LinkedList {
    // 增：

    /**
     * 在指定位置新增一个值为value的结点
     *
     * @param index 位置下标
     * @param value 具体值
     */
    void add(int index, int value);

    void addWithDummyNode(int index, int value);

    /**
     * 在链表尾部加一个结点
     */
    void append(int value);

    // 删：

    void removeByIndex(int index);

    void removeByIndexWithDummyNode(int index);

    void removeByValue(int value);

    // 改：
    void set(int index, int value);

    /**
     * 翻转链表，适用头插法
     */
    default ListNode reverseList() {
        return null;
    }

    // 查：
    int get(int index);

    ListNode getNode(int index);

    int getLength();

    int getLengthByTraverse();

    /**
     * 判断链表是否有环
     */
    default boolean hasCycle() {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取链表中倒数第K个的结点
     * note:
     * 1. 要注意俩个临界情况。n可能超过链表的长度，以及n正好是链表的长度
     */
    default ListNode getKthFromEnd(int n) {
        ListNode head = getHead();
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        ListNode fast = dummyNode;
        ListNode slow = dummyNode;

        // 先让快指针走n+1步
        while (n != -1 && fast != null) {
            fast = fast.next;
            n--;
        }
        // 如果快指针没走到n步就结束了，说明参数有问题
        if (n > 0 && fast == null) {
            return null;
        }

        // 快慢指针一起走，让慢指针在倒数第n个位置停下
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }

    /**
     * 根据双指针的方法找到链表的中间结点
     * note：如果链表长度为偶数，则返回中间最大的结点
     * DummyNode结点技巧
     */
    ListNode findMiddleNode();


    default ListNode getHead() {
        return null;
    }
}
