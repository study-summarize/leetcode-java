package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 * 泰波那契序列 Tn 定义如下：
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 * 四步骤：
 * （1）：定义状态：dp[n] = T[n]
 * （2）：状态转移：dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
 * （3）：初始条件：dp[0] = 0; dp[1] = 1; dp[2] = 1
 * （4）：求最优解：dp[n]
 */
public class LeetCode_1137_tribonacci {
    /**
     * 方法一：自顶向下的动态规划
     */
    public int tribonacci01(int n) {
        if (n < 0) {
            return -1;
        }
        // 记忆数组记录状态
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        return tribonacci01Helper(dp, n);
    }

    private int tribonacci01Helper(int[] dp, int n) {
        if (dp[n] != -1) {
            return dp[n];
        }

        int result = tribonacci01Helper(dp, n - 1) + tribonacci01Helper(dp, n - 2) + tribonacci01Helper(dp, n - 3);
        dp[n] = result;
        return result;
    }

    /**
     * 方法二：自底向上的动态规划
     */
    public int tribonacci02(int n) {
        if (n < 0) {
            return -1;
        }
        // 状态数组的初始值
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    /**
     * 方法三：自底向上的动态规划 + 滚动数组
     */
    public int tribonacci03(int n) {
        if (n < 0) {
            return -1;
        }
        // 记录数组的基本状态
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i % 3] = dp[(i - 1) % 3] + dp[(i - 2) % 3] + dp[(i - 3) % 3];
        }
        return dp[n % 3];
    }

    /**
     * 滚动数组、动态规划
     * 时间复杂度：
     * 空间复杂度：
     */
    public int tribonacciExample(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int[] f = new int[3];
        f[0] = 0;
        f[1] = 1;
        f[2] = 1;

        for (int i = 3; i <= n; i++) {
            f[i % 3] = f[(i - 1) % 3] + f[(i - 2) % 3] + f[(i - 3) % 3];
        }

        return f[n % 3];
    }
}
