package org.github.fourth.leetcode;

import org.github.fourth.Top100;
import org.github.fourth.leetcode.common.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
@Top100
public class LeetCode_021_mergeTwoLists {

    public ListNode test(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode dummyNode = new ListNode();
        ListNode newNode = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                newNode.next = list1;
                list1 = list1.next;
            } else {
                newNode.next = list2;
                list2 = list2.next;
            }
            newNode = newNode.next;
        }

        // 当list1还有元素时
        while (list1 != null) {
            newNode.next = list1;
            list1 = list1.next;
            newNode = newNode.next;
        }
        // 当list2还有元素时
        while (list2 != null) {
            newNode.next = list2;
            list2 = list2.next;
            newNode = newNode.next;
        }
        return dummyNode.next;
    }
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * note
     * 1. dummyNode技巧
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode dummyNode = new ListNode();
        ListNode point = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                point.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                point.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            point = point.next;
        }
        // l1 还有数据时
        while (list1 != null) {
            point.next = list1;
            list1 = list1.next;
            point = point.next;
        }
        // l2 还有数据时
        while (list2 != null) {
            point.next = list2;
            list2 = list2.next;
            point = point.next;
        }
        return dummyNode.next;
    }
}
