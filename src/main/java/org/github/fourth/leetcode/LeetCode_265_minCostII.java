package org.github.fourth.leetcode;

/**
 * 假如有一排房子共有 n 幢，每个房子可以被粉刷成 k 种颜色中的一种。房子粉刷成不同颜色的花费成本也是不同的。你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * 每个房子粉刷成不同颜色的花费以一个 n x k 的矩阵表示。
 * 例如，costs[0][0] 表示第 0 幢房子粉刷成 0 号颜色的成本；costs[1][2] 表示第 1 幢房子粉刷成 2 号颜色的成本，以此类推。
 * 返回 粉刷完所有房子的最低成本 。
 */
public class LeetCode_265_minCostII {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    @SuppressWarnings("LocalVariableName")
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0
                || costs[0] == null || costs[0].length == 0) {
            return 0;
        }

        int n = costs.length;
        int K = costs[0].length;
        // state：dp[i][k]：代表用颜色k粉刷第i个房子的最小花费
        int[][] dp = new int[2][K];

        // condition
        for (int i = 0; i < K; i++) {
            dp[0][i] = costs[0][i];
        }

        // function: dp[i][k] = min(dp[i][k], dp[i-1][j](j != k) + costs[i][k])
        for (int i = 1; i < n; i++) {
            for (int k = 0; k < K; k++) {
                for (int j = 0; j < K; j++) {
                    if (j != k) {
                        dp[i % 2][k] = Math.min(dp[i % 2][k], dp[(i - 1) % 2][j] + costs[i][k]);
                    }
                }
            }
        }

        // solution: min(dp[n-1][0], dp[n-1][1], dp[n-1][2])
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < K; i++) {
            result = Math.min(result, dp[(n - 1) % 2][i]);
        }
        return result;
    }

    @SuppressWarnings("LocalVariableName")
    public int minCostIIRefine(int[][] costs) {
        if (costs == null || costs.length == 0
                || costs[0] == null || costs[0].length == 0) {
            return 0;
        }

        int n = costs.length;
        int K = costs[0].length;
        // state：dp[i][k]：代表用颜色k粉刷第i个房子的最小花费
        int[][] dp = new int[2][K];

        // condition
        for (int i = 0; i < K; i++) {
            dp[0][i] = costs[0][i];
        }

        // function: dp[i][k] = min(dp[i][k], dp[i-1][j](j != k) + costs[i][k])
        int minCost = Integer.MAX_VALUE;
        int secondMinCost = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minCost = Integer.MAX_VALUE;
            secondMinCost = Integer.MAX_VALUE;
            // 计算第i个房子的最小成本、第二小成本
            for (int k = 0; k < K; k++) {
                // 数组初始化赋值
                dp[i % 2][k] = Integer.MAX_VALUE;
                if (dp[(i - 1) % 2][k] <= minCost) {
                    secondMinCost = minCost;
                    minCost = dp[(i - 1) % 2][k];
                } else if (dp[(i - 1) % 2][k] < secondMinCost) {
                    secondMinCost = dp[(i - 1) % 2][k];
                }
            }

            for (int k = 0; k < K; k++) {
                if (dp[(i - 1) % 2][k] == minCost) {
                    // 当前第i个房子刷颜色k，与minCost刷的一样
                    dp[i % 2][k] = secondMinCost + costs[i][k];
                } else {
                    dp[i % 2][k] = minCost + costs[i][k];
                }
            }
        }

        // solution: min(dp[n-1][0], dp[n-1][1], dp[n-1][2])
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < K; i++) {
            result = Math.min(result, dp[(n - 1) % 2][i]);
        }
        return result;
    }
}
