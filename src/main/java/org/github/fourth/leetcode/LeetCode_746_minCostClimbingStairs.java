package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 * 4步设计：
 * （1）定义状态：dp[n]：到达第n个台阶所需要的最低花费
 * （2）状态转移：dp[n] = min(dp[n - 1] + cost[n - 1], dp[n - 2] + cost[n - 2])
 * （3）初始状态：dp[0] = 0; dp[1] = 0
 * （4）求最优解：dp[n]
 */
public class LeetCode_746_minCostClimbingStairs {
    /**
     * 方法一：自顶向下的动态规划
     */
    public int minCostClimbingStairs01(int[] cost) {
        if (cost == null || cost.length == 0) {
            return -1;
        }
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 0;

        return minCostClimbingStairs01Helper(dp, cost, cost.length);
    }

    private int minCostClimbingStairs01Helper(int[] dp, int[] cost, int i) {
        if (dp[i] != -1) {
            return dp[i];
        }

        dp[i] = Math.min(
                minCostClimbingStairs01Helper(dp, cost, i - 1) + cost[i - 1],
                minCostClimbingStairs01Helper(dp, cost, i - 2) + cost[i - 2]);
        return dp[i];
    }

    /**
     * 方法二：自底向上的动态规划
     */
    public int minCostClimbingStairs02(int[] cost) {
        if (cost == null || cost.length == 0) {
            return -1;
        }
        // 记录初始状态
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0; // 因为前俩个台阶可以直接跨上去

        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }

    /**
     * 方法三：自底向上的动态规划 + 滚动数组
     */
    public int minCostClimbingStairs03(int[] cost) {
        if (cost == null || cost.length == 0) {
            return -1;
        }
        // 记录初始状态
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 0; // 因为前俩个台阶可以直接跨上去

        for (int i = 2; i <= cost.length; i++) {
            dp[i % 2] = Math.min(dp[(i - 1) % 2] + cost[i - 1], dp[(i - 2) % 2] + cost[i - 2]);
        }
        return dp[cost.length % 2];
    }

    /**
     * 滚动数组优化、动态规划
     * 时间复杂度：
     * 空间复杂度：
     */
    public int minCostClimbingStairsExample(int[] cost) {
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
