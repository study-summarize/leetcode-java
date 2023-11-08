package org.github.fourth.leetcode;

public class LeetCode_053_maxSubArray {

    /**
     * 动态规划
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // state-dp[i]：以nums[i]结尾的子数组最大和
        int[] dp = new int[nums.length];
        // condition: dp[0] = nums[0]
        dp[0] = nums[0];
        // function: 制表法 => 1. 如果dp[i-1]为负，说明没有正收益，dp[i] = nums[i]；2. 如果dp[i-1]为正收益，dp[i] = dp[i-1] + nums[i]
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        // solution: 寻找最大值
        int result = Integer.MIN_VALUE;
        for (int value : dp) {
            result = Math.max(value, result);
        }
        return result;
    }

    /**
     * 动态规划、滚动数组优化
     */
    public int maxSubArrayRefine(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // state-dp[i]：以nums[i]结尾的子数组最大和
        // condition: dp[0] = nums[0]
        int dp = nums[0];

        int result = dp;
        // function: 制表法 => 1. 如果dp[i-1]为负，说明没有正收益，dp[i] = nums[i]；2. 如果dp[i-1]为正收益，dp[i] = dp[i-1] + nums[i]
        for (int i = 1; i < nums.length; i++) {
            if (dp > 0) {
                dp = dp + nums[i];
            } else {
                dp = nums[i];
            }
            result = Math.max(result, dp);
        }
        // solution: 寻找最大值
        return result;
    }
}
