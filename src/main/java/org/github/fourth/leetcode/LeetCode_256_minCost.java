package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 costs 来表示的。
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
 * 请计算出粉刷完所有房子最少的花费成本。
 */
public class LeetCode_256_minCost {
    /**
     *
     */
    public int minCost01(int[][] costs) {
        return 0;
    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int minCostExample(int[][] costs) {
        if (costs == null || costs.length == 0
                || costs[0] == null || costs[0].length == 0) {
            return 0;
        }

        int n = costs.length;
        // state：dp[i][k]：代表用颜色k粉刷第i个房子的最小花费
        int[][] dp = new int[2][3];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        Arrays.fill(dp[1], Integer.MAX_VALUE);

        // condition
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        // function: dp[i][k] = min(dp[i][k], dp[i-1][j](j != k) + costs[i][k])
        for (int i = 1; i < n; i++) {
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < 3; j++) {
                    if (j != k) {
                        dp[i % 2][k] = Math.min(dp[i % 2][k], dp[(i - 1) % 2][j] + costs[i][k]);
                    }
                }
            }
        }

        // solution: min(dp[n-1][0], dp[n-1][1], dp[n-1][2])
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }

}
