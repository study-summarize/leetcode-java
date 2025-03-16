package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 */
public class LeetCode_322_coinChange {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int coinChange01(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return 0;
        }
        int m = coins.length;

        // dp[i,j]：用前i个硬币组成的和达到j，所需要的最少硬币个数
        // 为什么要m + 1，因为
        int[][] dp = new int[m + 1][amount + 1];
        for (int[] array : dp) {
            Arrays.fill(array, 20000);
        }
        /**
         * 边界问题
         * dp[i][0] = 0;
         */
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }


        /**
         * dp[i][j] = min(dp[i - 1][j - k * coins[i - 1]] + k)
         */
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= amount; j++) {
                for (int k = 0; k <= j / coins[i - 1]; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * coins[i - 1]] + k);
                }
            }
        }
        return dp[m][amount] == 20000 ? -1 : dp[m][amount];
    }
}
