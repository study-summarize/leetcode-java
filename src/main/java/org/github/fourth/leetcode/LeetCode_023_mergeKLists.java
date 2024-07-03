package org.github.fourth.leetcode;


import org.github.fourth.Top100;
import org.github.fourth.leetcode.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
@Top100
public class LeetCode_023_mergeKLists {

    /**
     *
     */
    public ListNode mergeKLists01(ListNode[] lists) {
        return null;
    }
    /**
     * 方法：使用堆方法
     * 时间复杂度：
     * 空间复杂度：
     */
    public ListNode mergeKListsExample(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // k个元素最小堆
        Queue<ListNode> heap = new PriorityQueue<>(lists.length, Comparator.comparingInt(node -> node.val));
        for (ListNode list : lists) {
            if (list != null) {
                heap.offer(list);
            }
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode node = dummyNode;
        while (!heap.isEmpty()) {
            // 取出堆的最小元素
            ListNode minNode = heap.poll();
            // 后续如何还有结点，就将其入堆
            if (minNode.next != null) {
                heap.offer(minNode.next);
            }

            node.next = minNode;
            node = minNode;
        }
        return dummyNode.next;
    }
}
