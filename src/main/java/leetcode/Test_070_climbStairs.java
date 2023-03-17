package leetcode;

public class Test_070_climbStairs {

    /**
     * 滚动数组优化、动态规划
     */
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }

        // dp[n]：表示有多少种方法能爬到第n阶
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 1;

        // solution: dp[n]
        for (int i = 2; i <= n; i++) {
            // 状态转移方程：dp[n] = 最后一步爬1个台阶方案总数 + 最后一个爬2个台阶方案总数
            // 为什么能想到这个等式？dp[n]可以把总方案数分成：最后一步爬一个台阶 + 最后一步爬俩个台阶
            dp[i % 2] = dp[(i - 1) % 2] + dp[(i - 2) % 2];
        }
        return dp[n % 2];
    }

}
