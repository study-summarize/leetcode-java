package org.github.fourth.leetcode;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 */
public class LeetCode_062_uniquePaths {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int uniquePaths01(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        // dp[i][j]表示从左上角到(i,j)有多少种走法
        int[][] dp = new int[m][n];
        // 初使化
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
