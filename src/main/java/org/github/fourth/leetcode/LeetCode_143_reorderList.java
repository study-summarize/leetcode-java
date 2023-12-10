package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.ListNode;

/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class LeetCode_143_reorderList {
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        // 找到中间结点
        ListNode middleNode = getMiddleOfList(head);
        // 将链表后半部分翻转
        ListNode tailNode = reverseList(middleNode.next);
        // 将前半部分和后半部分进行拼接
        middleNode.next = null;
        mergeList(head, tailNode);
    }

    public ListNode getMiddleOfList(ListNode head) {
        // 这里为啥既可以写成head也可以写成head.next
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // note: 为啥这样可以？？？
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    public void mergeList(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode();
        ListNode node = dummyNode;
        int index = 0;
        while (head1 != null && head2 != null) {
            if (index % 2 == 0) {
                node.next = head1;
                head1 = head1.next;
            } else {
                node.next = head2;
                head2 = head2.next;
            }

            index++;
            node = node.next;
        }

        if (head1 != null) {
            node.next = head1;
        }
        if (head2 != null) {
            node.next = head2;
        }
    }
}
