package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 */
public class LeetCode_1099_twoSumLessThanK {
    /**
     * 时间复杂度：
     * 空间复杂度：
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
