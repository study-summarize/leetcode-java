package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.ListNode;

/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
public class LeetCode_082_deleteDuplicates {
    /**
     * 太多点要注意了。。。。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * note：
     * dummyNode技巧
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        // 用于记录重复元素的前一个
        ListNode preNode = dummyNode;
        while (head.next != null) {
            // 如果值相同的话，就找到最后一个相同的元素
            if (head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                if (head.next == null) {
                    preNode.next = null;
                } else {
                    preNode.next = head.next;
                    head = head.next;
                }
            } else {
                head = head.next;
                preNode = preNode.next;
            }
        }
        return dummyNode.next;
    }


}

