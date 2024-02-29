package org.github.fourth.leetcode;

/**
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class LeetCode_188_maxProfit {

    /**
     *
     */
    public int maxProfit01(int k, int[] prices) {
        return 0;
    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int maxProfitExample(int k, int[] prices) {
        if (k <= 0 || prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // dp[i][j][m]：第i天、j次交易后，手上持股m状态下的最大收益；m==0，手中无股票、m==1，手中有股票
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] - prices[i]);
        }

        // function
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][1]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] - prices[i]);
            }
        }

        return dp[n - 1][k][0];
    }
}
