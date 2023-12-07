package org.github.fourth.leetcode.common;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings("URF_UNREAD_FIELD")
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode() {
    }

    public static ListNode build(int[] nums) {
        return build(nums, -1);
    }
    public static ListNode build(Integer... nums) {
        if (nums.length == 0) {
            return null;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
        }
        return build(result, -1);
    }

    /**
     * @param lastToIndex -1表示无cycle
     */
    public static ListNode build(int[] nums, int lastToIndex) {
        ListNode result = new ListNode(nums[0]);
        ListNode temp = result;

        ListNode cycleNode = (lastToIndex == 0) ? result : null;
        for (int i = 1; i < nums.length; i++) {
            temp.next = new ListNode(nums[i]);
            temp = temp.next;
            if (i == lastToIndex) {
                cycleNode = temp;
            }
            if (lastToIndex >= 0 && i == nums.length - 1) {
                temp.next = cycleNode;
            }
        }
        return result;
    }
}
