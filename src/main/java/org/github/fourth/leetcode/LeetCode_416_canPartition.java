package org.github.fourth.leetcode;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class LeetCode_416_canPartition {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int m = nums.length;
        int target = sum / 2;
        // dp[i,j]：从前i个数字选择的数字之和为j是否存在
        boolean[][] dp = new boolean[m][target + 1];
        /*
         * condition
         * dp[0][0] = true
         * dp[i][0] = true
         * dp[0][j] = false
         */
        for (int i = 0; i < m; i++) {
            dp[i][0] = true;
        }
        /*
         * 1、选择第i个
         *      dp[i][j] = dp[i - 1][j - nums[i]]
         * 2、不选第i个
         *      dp[i][j] = dp[i - 1][j]
         */
        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= target; j++) {
                // 背包容量不够
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[m - 1][target];
    }
}
