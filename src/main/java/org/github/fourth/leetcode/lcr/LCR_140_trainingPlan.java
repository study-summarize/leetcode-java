package org.github.fourth.leetcode.lcr;


import org.github.fourth.leetcode.common.ListNode;

/**
 * 给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，请查找并返回倒数第 cnt 个训练项目编号。
 */
public class LCR_140_trainingPlan {

    /**
     * 快慢指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public ListNode trainingPlan02(ListNode head, int cnt) {
        if (head == null || cnt <= 0) {
            return null;
        }

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        while (fast.next != null) {
            // 记得带入特殊值
            if (cnt == 1) {
                slow = slow.next;
            } else {
                --cnt;
            }
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 暴力方法：先求链表长度，找到倒数第 cnt 个节点
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public ListNode trainingPlan01(ListNode head, int cnt) {
        if (head == null || cnt <= 0) {
            return null;
        }

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        // 先求长度
        int length = 0;
        while (dummyNode.next != null) {
            length++;
            dummyNode = dummyNode.next;
        }
        if (cnt > length) {
            return null;
        }

        // 求节点的位置
        int pos = length + 1 - cnt;
        dummyNode = new ListNode();
        dummyNode.next = head;
        while (pos != 0) {
            dummyNode = dummyNode.next;
            --pos;
        }
        return dummyNode;
    }
}
