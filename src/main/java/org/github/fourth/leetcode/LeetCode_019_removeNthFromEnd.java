package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class LeetCode_019_removeNthFromEnd {
    /**
     * 前后指针
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        // 找到倒数第n + 1个
        ListNode fast = dummyNode;
        ListNode last = dummyNode;
        int moveCount = 0;
        while (fast.next != null) {
            if (++moveCount >= (n + 1)) {
                // 找到第n + 1个节点
                last = last.next;
            }
            fast = fast.next;
        }

        // 如果没找到n+1个节点
        if (last == dummyNode) {
            return null;
        }

        if (last.next != null) {
            last.next = last.next.next;
        }
        return dummyNode.next;
    }
}
