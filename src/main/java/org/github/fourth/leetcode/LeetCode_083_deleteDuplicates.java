package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.ListNode;

/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 */
public class LeetCode_083_deleteDuplicates {
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * note:
     * 1. dummyNode技巧
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        while (head != null) {
            if (head.next == null) {
                break;
            }
            if (head.val == head.next.val) {
                head.next = head.next.next;
            }
            head = head.next;
        }

        return dummyNode.next;
    }
}
