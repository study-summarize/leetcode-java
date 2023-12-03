package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.ListNode;

/**
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */
public class LeetCode_876_middleNode {

    /**
     * 快慢指针
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * note：dummyNode
     */
    public ListNode middleNode02(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        // 快慢指针
        ListNode first = dummyNode;
        ListNode second = dummyNode;
        while (first.next != null && first.next.next != null) {
            first = first.next.next;
            second = second.next;
        }
        // 无论链表长度是奇数还是偶数；慢指针都需要进一步
        return second.next;
    }

    /**
     * 暴力解法：先求长度，再求中间结点位置
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * note：dummyNode
     */
    public ListNode middleNode01(ListNode head) {
        if (head == null) {
            return null;
        }
        // 求长度
        int length = 0;
        ListNode node = head;
        while (node != null) {
            ++length;
            node = node.next;
        }

        int pos = length / 2;
        node = head;
        while (pos != 0) {
            --pos;
            node = node.next;
        }
        return node;
    }


}
