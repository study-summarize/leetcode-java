package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums 和整数 k ，返回最大和 sum ，满足存在 i < j 使得 nums[i] + nums[j] = sum 且 sum < k 。如果没有满足此等式的 i,j 存在，则返回 -1 。
 */
public class LeetCode_1099_twoSumLessThanK {
    /**
     * 相遇型双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int twoSumLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int result = Integer.MIN_VALUE;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum >= k) {
                end--;
            } else {
                result = Math.max(sum, result);
                start++;
            }
        }
        return result == Integer.MIN_VALUE ? -1 : result;
    }
}
