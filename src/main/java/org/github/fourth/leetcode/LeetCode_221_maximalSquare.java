package org.github.fourth.leetcode;

/**
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class LeetCode_221_maximalSquare {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int maximalSquare01(char[][] matrix) {
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        // dp[i,j] ：以(i,j)为右下点的最大矩形大小
        int[][] dp = new int[m][n];
        // dp[i,i] = min(a, b, dp[i-1, j-1]) + 1；而a,b其实能跟dp[i-1][j]、dp[i][j-1]比较
        // 最大边长
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                result = Math.max(result, dp[i][0]);
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                result = Math.max(result, dp[0][j]);
            }
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result * result;
    }
}
