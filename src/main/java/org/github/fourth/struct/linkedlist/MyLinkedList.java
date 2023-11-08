package org.github.fourth.struct.linkedlist;

/**
 * 单链表的实现
 * <p>
 * 1、相关技巧
 * (1)DummyNode
 * (2)头插法
 * (3)将俩个相邻节点旋转
 * <p>
 * 2、相关题目
 * （1）与计数或位置相关的问题
 * - 876-链表的中间结点：https://leetcode.cn/problems/middle-of-the-linked-list/
 * - 剑指Offer22-链表中倒数第k个节点：https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * - 141-环形链表：https://leetcode.cn/problems/linked-list-cycle/
 * - 142-环形链表II：https://leetcode.cn/problems/linked-list-cycle-ii/
 * （2）与链表结构变化相关的问题
 * - 021-合并两个有序链表：https://leetcode.cn/problems/merge-two-sorted-lists/
 * - 002-两数相加：https://leetcode.cn/problems/add-two-numbers/
 * - 019-删除链表的倒数第N个结点：https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * - 083-删除排序链表中的重复元素：https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 * - 082-删除排序链表中的重复元素II：https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
 * - 206-反转链表：https://leetcode.cn/problems/reverse-linked-list/
 * - 092-反转链表II：https://leetcode.cn/problems/reverse-linked-list-ii/
 * - 025-K个一组翻转链表：https://leetcode.cn/problems/reverse-nodes-in-k-group/
 * - 024-两两交换链表中的节点：https://leetcode.cn/problems/swap-nodes-in-pairs/
 * - 445-两数相加II：https://leetcode.cn/problems/add-two-numbers-ii/
 * - 143-重排链表：https://leetcode.cn/problems/reorder-list/
 * - 234-回文链表：https://leetcode.cn/problems/palindrome-linked-list/
 * - 061-旋转链表：https://leetcode.cn/problems/rotate-list/
 *
 * @author jwang55
 */
public class MyLinkedList {
    // field
    public ListNode head;
    public int length;

    // Constructor
    public MyLinkedList() {
    }

    public MyLinkedList(ListNode head) {
        this.head = head;
    }

    // Method
    public int get(int index) {
        return getNode(index).val;
    }

    public ListNode getNode(int index) {
        preCheck(index, this.length - 1);

        ListNode cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public void add(int index, int value) {
        preCheck(index, this.length);

        // Build new Node
        ListNode newNode = new ListNode(value);
        this.length++;
        if (index == 0) {
            head = newNode;
            return;
        }
        // Search
        ListNode preNode = getNode(index - 1);
        ListNode curNode = preNode.next;

        // change Linked list structure
        preNode.next = newNode;
        newNode.next = curNode;
    }

    public void addWithDummyNode(int index, int value) {
        preCheck(index, this.length);

        // Build new Node
        ListNode newNode = new ListNode(value);
        this.length++;

        // Build Dummy Node
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode preNode = dummyNode;
        while (index > 0) {
            preNode = preNode.next;
            index--;
        }
        // Search
        ListNode curNode = preNode.next;

        // change Linked list structure
        preNode.next = newNode;
        newNode.next = curNode;

        this.head = dummyNode.next;
    }

    private void preCheck(int index, int restriction) {
        if (index < 0 || index > restriction) {
            throw new RuntimeException(String.format("The index %s is out of index, the restriction for check %s", index, this.length));
        }
    }

    public void append(int value) {
        add(this.length, value);
    }

    public void set(int index, int value) {
        // Search
        ListNode node = getNode(index);
        node.val = value;
    }

    public void removeByIndex(int index) {
        preCheck(index, this.length - 1);
        if (index == 0) {
            this.length--;
            ListNode cur = head;
            head = cur.next;
            cur = null; // note: help GC
            return;
        }
        // Search
        ListNode preNode = getNode(index - 1);
        ListNode cur = preNode.next;
        // change Linked list structure
        preNode.next = cur.next;
        this.length--;
    }

    public void removeByIndexWithDummyNode(int index) {
        preCheck(index, this.length - 1);
        this.length--;

        // Build Dummy Node
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode preNode = dummyNode;
        while (index > 0) {
            preNode = preNode.next;
            index--;
        }

        // change Linked list structure
        ListNode nextNode = preNode.next.next;
        preNode.next = nextNode;

        this.head = dummyNode.next;
    }

    public void removeByValue(int value) {

    }

    public int getLength() {
        return this.length;
    }

    public int getLengthByTraverse() {
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
}
