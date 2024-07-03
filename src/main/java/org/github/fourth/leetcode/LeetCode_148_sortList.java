package org.github.fourth.leetcode;


import org.github.fourth.Top100;
import org.github.fourth.leetcode.common.ListNode;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
@Top100
public class LeetCode_148_sortList {

    /**
     * 利用快速排序实现
     * 时间复杂度：
     * 空间复杂度：
     */
    public ListNode sortList(ListNode head) {
        // 注意：head.next 也不能为空
        if (head == null || head.next == null) {
            return head;
        }

        int pivotValue = head.val;
        // value <= pivotValue
        ListNode lowNodeDummy = new ListNode(-1);
        ListNode lowNode = lowNodeDummy;
        // value > pivotValue
        ListNode highNodeDummy = new ListNode(-1);
        ListNode highNode = highNodeDummy;

        ListNode node = head.next;
        while (node != null) {
            // 相等时，要放在高区间上
            if (node.val < pivotValue) {
                lowNode.next = node;
                lowNode = lowNode.next;
            } else {
                highNode.next = node;
                highNode = highNode.next;
            }
            node = node.next;
        }

        // 三个部分连接：lowNode、highNode、pivot
        lowNode.next = head;
        head.next = null;
        highNode.next = null;

        lowNode = sortList(lowNodeDummy.next);
        highNode = sortList(highNodeDummy.next);

        // 排完序后，再进行连接
        head.next = highNode;
        return lowNode;
    }

    /**
     * 利用归并排序实现
     */
    public ListNode sortList2(ListNode head) {
        // 注意：head.next 也不能为空
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddleOfList(head);

        ListNode right = sortList2(middle.next);
        // note: 要截断
        middle.next = null;
        ListNode left = sortList2(head);

        return merge(left, right);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode();
        ListNode node = dummyNode;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }

        if (l1 != null) {
            node.next = l1;
        }
        if (l2 != null) {
            node.next = l2;
        }

        return dummyNode.next;
    }

    private ListNode findMiddleOfList(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


}
