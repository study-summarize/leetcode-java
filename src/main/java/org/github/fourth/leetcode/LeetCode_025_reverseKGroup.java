package org.github.fourth.leetcode;

import org.github.fourth.Top100;
import org.github.fourth.leetcode.common.ListNode;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
@Top100
public class LeetCode_025_reverseKGroup {
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * note: 头插法、dummyNode技巧
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode node = dummyNode;
        while (node.next != null) {
            ListNode check = node;
            // 判断够不够k个
            for (int i = 0; i < k; i++) {
                if (check.next == null) {
                    return dummyNode.next;
                }
                check = check.next;
            }

            // 反转k-1次
            ListNode preNode = node;
            ListNode currentNode = preNode.next;
            for (int i = 0; i < k - 1; i++) {
                ListNode temp = currentNode.next;
                currentNode.next = temp.next;
                temp.next = preNode.next;
                preNode.next = temp;
            }
            // node 需要移动到 currentNode
            node = currentNode;
        }
        return dummyNode.next;
    }
}
