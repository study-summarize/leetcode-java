package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.ListNode;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */
public class LeetCode_234_isPalindrome {
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        // 求中点
        ListNode middleNode = getMiddleOfListNode(head);
        // 将后半部分链表翻转
        ListNode tail = reverseListNode(middleNode.next);
        middleNode.next = null;
        // 判断回文
        while (head != null && tail != null) {
            int num1 = head.val;
            int num2 = tail.val;
            if (num1 != num2) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

    public ListNode reverseListNode(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    public ListNode getMiddleOfListNode(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
