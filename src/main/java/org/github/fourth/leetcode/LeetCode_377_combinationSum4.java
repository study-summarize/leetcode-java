package org.github.fourth.leetcode;

/**
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 题目数据保证答案符合 32 位整数范围。
 */
public class LeetCode_377_combinationSum4 {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int combinationSum401(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < 0) {
            return 0;
        }

        // dp[j]：总和为j的元素组合个数
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // 顺序不同的序列视作不同的组合 => 先遍历金额
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
