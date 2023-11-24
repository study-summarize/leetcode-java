package org.github.fourth.leetcode;

/**
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 */
public class LeetCode_746_minCostClimbingStairs {

    /**
     * 滚动数组优化、动态规划
     * 时间复杂度：
     * 空间复杂度：
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
