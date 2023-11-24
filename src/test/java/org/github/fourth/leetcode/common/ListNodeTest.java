package org.github.fourth.leetcode.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.github.fourth.leetcode.common.ListNode.build;

@DisplayName("链表数据结构")
class ListNodeTest {

    @Test
    public void test() {
        // 无环链表
        int[] nums1 = {1, 2, 3};
        verifyListNode(ListNode.build(nums1), nums1);

        // 有环链表
        ListNode node2 = build(new int[]{1, 2}, 0);
        // todo: 如何验证有环
    }

    private static void verifyListNode(ListNode node, int[] nums) {
        int count = 0;
        while (node != null) {
            Assertions.assertEquals(nums[count++], node.val);
            node = node.next;
        }
        Assertions.assertEquals(nums.length, count);
    }

}