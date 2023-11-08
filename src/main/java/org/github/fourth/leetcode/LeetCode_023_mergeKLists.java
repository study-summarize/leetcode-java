package org.github.fourth.leetcode;

import org.github.fourth.struct.linkedlist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeetCode_023_mergeKLists {

    /**
     * 方法：使用堆方法
     */
    public ListNode mergeKLists(ListNode[] lists) {
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
