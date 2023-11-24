package org.github.fourth.leetcode;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 */
public class LeetCode_198_rob {

    /**
     * 滚动数组优化、动态规划
     * 时间复杂度：
     * 空间复杂度：
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // dp[i]：在第i个房子时，获得的最大金额
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = nums[0];

        // function: dp[i]
        for (int i = 2; i <= nums.length; i++) {
            dp[i % 2] = Math.max(
                    dp[(i - 1) % 2],
                    dp[(i - 2) % 2] + nums[i - 1] // nums[i-1]表示第n-2个房子
            );
        }

        // solution
        return dp[nums.length % 2];
    }
}
