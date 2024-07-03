package org.github.fourth.leetcode;

import org.github.fourth.Top100;
import org.github.fourth.leetcode.common.ListNode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
@Top100
public class LeetCode_002_addTwoNumbers {

    /**
     * 想清楚各种情况就行，感觉没啥考察点
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode dummyNode = new ListNode();
        ListNode cur = dummyNode;
        boolean needAddOne = false;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if (needAddOne) {
                sum = sum + 1;
            }
            needAddOne = sum >= 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        // l1还有剩余的
        while (l1 != null) {
            int sum = l1.val;
            if (needAddOne) {
                sum = sum + 1;
            }
            needAddOne = sum >= 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1.next;
        }

        // l2还有剩余的
        while (l2 != null) {
            int sum = l2.val;
            if (needAddOne) {
                sum = sum + 1;
            }
            needAddOne = sum >= 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l2 = l2.next;
        }

        // 可能还会再进一
        if (needAddOne) {
            cur.next = new ListNode(1);
        }
        return dummyNode.next;
    }
}
