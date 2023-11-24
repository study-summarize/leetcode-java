package org.github.fourth.leetcode;

/**
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * - 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class LeetCode_309_maxProfit {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // dp[i][k]：在第i天交易完、在持股状态k下，能获取的最大利润是；k=0，手中无股；k=1，手中无股
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], ((i - 2) < 0 ? 0 : dp[i - 2][0]) - prices[i]); // 今天买入一定是前天没有股票
        }

        return dp[n - 1][0];
    }

    /**
     * 滚动数组优化
     */
    public int maxProfitRefine(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // dp[i][k]：在第i天交易完、在持股状态k下，能获取的最大利润是；k=0，手中无股；k=1，手中无股
        int[][] dp = new int[3][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i % 3][0] = Math.max(dp[(i - 1) % 3][0], dp[(i - 1) % 3][1] + prices[i]);
            dp[i % 3][1] = Math.max(dp[(i - 1) % 3][1], ((i - 2) < 0 ? 0 : dp[(i - 2) % 3][0]) - prices[i]); // 今天买入一定是前天没有股票
        }

        return dp[(n - 1) % 3][0];
    }
}
