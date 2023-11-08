package org.github.fourth.leetcode;

public class LeetCode_188_maxProfit {
    public int maxProfit(int k, int[] prices) {
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
