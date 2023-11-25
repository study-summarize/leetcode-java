package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 * 给定一个长度为 n 的整数数组和一个目标值 target ，寻找能够使条件 nums[i] + nums[j] + nums[k] < target 成立的三元组  i, j, k 个数（0 <= i < j < k < n）。
 */
public class LeetCode_259_threeSumSmaller {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        if (nums == null || nums.length == 0) {
            return count;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum < target) {
                    count += (end - start);
                    start++;
                } else {
                    end--;
                }
            }
        }
        return count;
    }
}
