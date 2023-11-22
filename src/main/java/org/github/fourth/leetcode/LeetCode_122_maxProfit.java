package org.github.fourth.leetcode;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 */
public class LeetCode_122_maxProfit {
    /**
     * 贪心法
     */
    public int maxProfit01(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 贪心
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += (prices[i] - prices[i - 1]);
            }
        }

        return maxProfit;
    }

    /**
     * 动态规划
     */
    public int maxProfit02(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // dp[i][k]：在第i天交易完、在持股状态k下，能获取的最大利润是；k=0，手中无股；k=1，手中无股
        int[][] dp = new int[2][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1] + prices[i]);
            dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], dp[(i - 1) % 2][0] - prices[i]);
        }

        return dp[(n - 1) % 2][0];
    }
}
