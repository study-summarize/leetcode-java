package org.github.fourth.leetcode;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 */
public class LeetCode_064_minPathSum {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int minPathSum01(int[][] grid) {
        if (grid == null || grid.length == 0
                || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        // dp[i][j]：从0,0 -> i,j的数字总和最小值
        int[][] dp = new int[m][n];
        // dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                dp[i][0] = grid[0][0];
            } else {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
        }
        for (int j = 0; j < n; j++) {
            if (j == 0) {
                dp[0][j] = grid[0][0];
            } else {
                dp[0][j] = dp[0][j - 1] + grid[0][j];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
