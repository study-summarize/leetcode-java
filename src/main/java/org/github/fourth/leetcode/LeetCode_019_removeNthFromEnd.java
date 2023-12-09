package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class LeetCode_019_removeNthFromEnd {
    /**
     * 前后指针
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public ListNode removeNthFromEnd01(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        ListNode fast = dummyNode;
        ListNode slow = dummyNode;

        // 先让快指针走n + 1步 (加的1是因为从虚拟节点出发的)
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
     * 前后指针，前指针不走dummyNode结点
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public ListNode removeNthFromEnd02(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        ListNode fast = head;
        ListNode slow = dummyNode;

        // 先让快指针走n步
        while (n != 0 && fast != null) {
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
}
