package org.github.fourth.leetcode;

public class LeetCode_121_maxProfit {

    /**
     * 贪心法
     */
    public int maxProfit(int[] prices) {
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
