package org.github.fourth.leetcode;

import org.github.fourth.Top100;
import org.github.fourth.leetcode.common.ListNode;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
@Top100
public class LeetCode_024_swapPairs {

    public ListNode test(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummyNode = new ListNode();

        return dummyNode.next;
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * note: 头插法、dummyNode技巧
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode node = dummyNode;

        while (node != null && node.next != null) {
            // 判断够不够2
            if (node.next.next == null) {
                return dummyNode.next;
            }

            ListNode prev = node;
            ListNode curr = prev.next;
            // 反转一次
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
            // node移动到 curr
            node = curr;
        }
        return dummyNode.next;
    }
}
