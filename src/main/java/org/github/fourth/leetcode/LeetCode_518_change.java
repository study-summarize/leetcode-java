package org.github.fourth.leetcode;

/**
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 * 题目数据保证结果符合 32 位带符号整数。
 */
public class LeetCode_518_change {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int change01(int amount, int[] coins) {
        if (amount < 0 || coins == null || coins.length == 0) {
            return 0;
        }

        // dp[i]：总金额达到i，一共有多少种方式
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        // 防止硬币重复
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }
        return dp[amount];
    }
}
