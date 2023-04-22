package leetcode;

public class Test_309_maxProfit {
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
    public int maxProfit_refine(int[] prices) {
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
