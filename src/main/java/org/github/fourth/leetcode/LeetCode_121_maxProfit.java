package org.github.fourth.leetcode;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class LeetCode_121_maxProfit {

    /**
     *
     */
    public int maxProfit01(int[] prices) {
        return 0;
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
