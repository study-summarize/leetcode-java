package org.github.fourth.leetcode;

import org.github.fourth.Top100;
import org.github.fourth.leetcode.common.ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */
@Top100
public class LeetCode_206_reverseList {
    /**
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * note：dummyNode技巧
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode();
        dummyNode.next = null;
        while (head != null) {
            // 保存当前节点
            ListNode cur = head;

            // 删除节点之前链接
            head = head.next;
            cur.next = dummyNode.next;
            dummyNode.next = cur;
        }

        return dummyNode.next;
    }
}
