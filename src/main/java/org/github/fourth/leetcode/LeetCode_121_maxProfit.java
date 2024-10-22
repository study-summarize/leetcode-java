package org.github.fourth.leetcode;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class LeetCode_121_maxProfit {

    /**
     * 可以从动态规划上慢慢猜，主要是递推公式
     */
    public int maxProfit01(int[] prices) {
        if (prices == null || prices.length == 0) {
            return -1;
        }

        int result = 0;

        // dp：第i天卖的时候获取的最大利润
        int[] dp = new int[prices.length];
        dp[0] = 0;

        int currentMinValueIndex = 0;
        for (int i = 1; i < prices.length; i++) {
            // 1、price[i] < currentMinValueIndex，变更currentMinValueIndex，dp[i] = 0
            // 2、price[i] >= currentMinValueIndex，
            //          dp[i] = Math.max(dp[i-1], price[i] - price[currentMinValueIndex])
            if (prices[i] < prices[currentMinValueIndex]) {
                currentMinValueIndex = i;
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.max(dp[i - 1], prices[i] - prices[currentMinValueIndex]);
                result = Math.max(result, dp[i]);
            }
        }
        return result;
    }

    /**
     * 贪心法
     * 时间复杂度：
     * 空间复杂度：
     */
    public int maxProfitExample(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        // 贪心
        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            maxProfit = Math.max((price - minPrice), maxProfit);
        }

        return maxProfit;
    }
}
