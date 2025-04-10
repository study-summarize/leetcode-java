package org.github.fourth.leetcode;

import org.github.fourth.Top100;
import org.github.fourth.leetcode.common.ListNode;

/**
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 * https://leetcode.cn/problems/linked-list-cycle-ii/
 */
@Top100
public class LeetCode_142_detectCycle {
    /**
     * 只能根据公式计算得出规律
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode secondSlow = head;
        ListNode fast = head;
        ListNode slow = head;

        // 先让快慢指针第一次相遇
        // 快慢指针的经典判断
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (slow != secondSlow) {
                    slow = slow.next;
                    secondSlow = secondSlow.next;
                }
                // 得写在外面，因为有些完成环是直接slow == secondSlow
                return secondSlow;
            }
        }
        return null;
    }
}
