package org.github.fourth.leetcode;

import org.github.fourth.struct.linkedlist.ListNode;

/**
 * @author jwang55
 */
public class LeetCode_147_insertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);

        while (head != null) {
            ListNode node = dummyNode;
            // 比较
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            // 拆入此时head的节点
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }

        return dummyNode.next;
    }
}
