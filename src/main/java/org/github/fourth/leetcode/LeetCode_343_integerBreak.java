package org.github.fourth.leetcode;

/**
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 *
 * 返回 你可以获得的最大乘积 。
 */
public class LeetCode_343_integerBreak {
    public int integerBreak(int n) {
        if(n <= 1) {
            return -1;
        }

        // dp[i]: i 所能组成的最大乘积
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        /**
         * dp[i] => j, i - j
         * 1、i - j不再拆分多个正整数，j * (i - j)
         * 2、i - j能再拆分多个正整数，j * dp[i - j]
         *
         * dp[i] = max(1<=j<i) {max(j * (i - j), j * dp[i - j])}
         */
        for (int i = 3; i <= n; ++i) {
            int item = 0;
            for (int j = 1; j <= i; j++) {
                item = Math.max(item, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = item;
        }
        return dp[n];
    }
}
