package org.github.fourth.leetcode;

import org.github.fourth.Top100;
import org.github.fourth.leetcode.common.ListNode;

/**
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 */
@Top100
public class LeetCode_141_hasCycle {
    /**
     * 快慢指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public boolean hasCycle01(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode dummyNode = new ListNode();
        dummyNode.next = head;

        // 快慢指针
        ListNode fast = dummyNode;
        ListNode slow = dummyNode;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
