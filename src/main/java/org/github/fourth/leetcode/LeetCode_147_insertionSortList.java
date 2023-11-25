package org.github.fourth.leetcode;


import org.github.fourth.leetcode.common.ListNode;

/**
 * 给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。
 * 插入排序 算法的步骤:
 * - 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * - 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * - 重复直到所有输入数据插入完为止。
 * 下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表中。
 * 对链表进行插入排序。
 */
public class LeetCode_147_insertionSortList {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);

        while (head != null) {
            ListNode node = dummyNode;
            // 比较
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            // 拆入此时head的节点
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }

        return dummyNode.next;
    }
}
