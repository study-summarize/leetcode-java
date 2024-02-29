package org.github.fourth.leetcode;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.github.fourth.leetcode.common.ListNode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
@SuppressFBWarnings("NP_NULL_ON_SOME_PATH")
public class LeetCode_092_reverseBetween {
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * note: 头插法、找到第i个结点的写法
     */
    public ListNode reverseBetween01(ListNode head, int left, int right) {
        if (head == null || left > right || left <= 0) {
            return head;
        }

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        // 先找到left - 1的结点
        ListNode preLeftNode = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            preLeftNode = preLeftNode.next;
        }
        // 说明没到left - 1
        if (preLeftNode == null && left - 1 != 0) {
            return null;
        }

        // 对left～right进行反转
        ListNode currentNode = preLeftNode.next;
        for (int i = left; i < right; i++) {
            ListNode temp = currentNode.next;
            currentNode.next = temp.next;
            temp.next = preLeftNode.next;
            preLeftNode.next = temp;
        }
        return dummyNode.next;
    }
}
