package org.github.fourth.leetcode;

import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 */
public class LeetCode_120_minimumTotal {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int minimumTotal01(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0
                || triangle.get(0) == null || triangle.get(0).size() == 0) {
            return 0;
        }
        int m = triangle.size();
        int n = triangle.get(m - 1).size();

        int[][] dp = new int[m][n];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < triangle.get(i).size(); j++) {
                if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            result = Math.min(result, dp[m - 1][j]);
        }
        return result;
    }
}
