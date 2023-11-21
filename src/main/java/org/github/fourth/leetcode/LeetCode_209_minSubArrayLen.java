package org.github.fourth.leetcode;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class LeetCode_209_minSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0 || target <= 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        int j = 0;

        for (i = 0; i < nums.length; i++) {
            while (j < nums.length) {
                if (sum < target) {
                    sum += nums[j];
                    j++;
                } else {
                    break;
                }
            }
            // 窗口收缩
            if (sum >= target) {
                result = Math.min(result, j - i);
            }
            sum -= nums[i];
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
