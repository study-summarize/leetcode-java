package org.github.fourth.leetcode;

/**
 * 泰波那契序列 Tn 定义如下：
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 */
public class LeetCode_1137_tribonacci {

    /**
     * 滚动数组、动态规划
     * 时间复杂度：
     * 空间复杂度：
     */
    public int tribonacci(int n) {
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
