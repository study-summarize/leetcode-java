package leetcode;

public class Test_746_minCostClimbingStairs {

    /**
     * 滚动数组优化、动态规划
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        // state: dp[n]:到达第n级台阶，所需要的最小花费
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 0;

        // function： dp[n] = min( dp[n-1] + cost[n-1] , dp[n-2] + cost[n-2] )
        for (int i = 2; i <= cost.length; i++) {
            dp[i % 2] = Math.min(
                    dp[(i - 1) % 2] + cost[i - 1],
                    dp[(i - 2) % 2] + cost[i - 2]
            );
        }

        // solution
        return dp[cost.length % 2];
    }
}
