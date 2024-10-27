package org.github.fourth.leetcode;

public class LeetCode_096_numTrees {
    public int numTrees(int n) {
        // dp[i] 表示i+1个节点一共能组成多少种二叉搜索树
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
