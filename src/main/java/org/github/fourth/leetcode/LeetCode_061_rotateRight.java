package org.github.fourth.leetcode;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.github.fourth.leetcode.common.ListNode;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
@SuppressFBWarnings({"NP_NULL_ON_SOME_PATH", "SA_FIELD_SELF_ASSIGNMENT"})
public class LeetCode_061_rotateRight {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        // 求实际旋转次数
        int length = getLength(head);
        k = k % length;

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        // 倒数第k+1个节点
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = dummyNode.next;
        dummyNode.next = slow.next;
        slow.next = null;

        return dummyNode.next;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
}
