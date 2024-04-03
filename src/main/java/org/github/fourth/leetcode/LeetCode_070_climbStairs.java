package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 4步求解：
 * （1）定义状态：dp[n] 表示n阶楼梯有多少种不同方法可以爬到楼顶
 * （2）转移方程：dp[n] = dp[n-1] + dp[n-2]; 最后一步爬一个台阶，最后一步爬俩个台阶
 * （3）初始条件：dp[0] = 0; dp[1] = 1; dp[2] = 2; dp[3] = 3; dp[4] = 5
 * （4）最优求解：dp
 */
public class LeetCode_070_climbStairs {
    /**
     * 方法一：递归法
     */
    public int climbStairs01(int n) {
        if (n == 0 || n == 1 || n == 2 || n == 3) {
            return n;
        }

        return climbStairs01(n - 1) + climbStairs01(n - 2);
    }

    /**
     * 方法二：自顶向下的动态规划
     */
    public int climbStairs02(int n) {
        if (n <= 0) {
            return 0;
        }
        // 利用一个数组记录每个状态的值
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return climbStairs02Helper(memo, n);
    }

    private int climbStairs02Helper(int[] memo, int n) {
        if (memo[n] != -1) {
            return memo[n];
        }
        // 初始条件
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }

        int result = climbStairs02Helper(memo, n - 1) + climbStairs02Helper(memo, n - 2);
        memo[n] = result;
        return result;
    }

    /**
     * 方法三：自底向上的动态规划
     */
    public int climbStairs03(int n) {
        if (n < 0) {
            return -1;
        }
        // 记录初始状态数组
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;

        // 从底部开始计算
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    /**
     * 方法四：自底向上的动态规划 + 滚动数组
     */
    public int climbStairs04(int n) {
        if (n < 0) {
            return -1;
        }
        // 记录初始状态数组
        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        // 从底部开始计算
        for (int i = 3; i <= n; i++) {
            dp[i % 3] = dp[(i - 1) % 3] + dp[(i - 2) % 3];
        }
        return dp[n % 3];
    }

    /**
     * 滚动数组优化、动态规划
     * 时间复杂度：
     * 空间复杂度：
     */
    public int climbStairsExample(int n) {
        if (n == 0) {
            return 0;
        }

        // dp[n]：表示有多少种方法能爬到第n阶
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 1;

        // solution: dp[n]
        for (int i = 2; i <= n; i++) {
            // 状态转移方程：dp[n] = 最后一步爬1个台阶方案总数 + 最后一个爬2个台阶方案总数
            // 为什么能想到这个等式？dp[n]可以把总方案数分成：最后一步爬一个台阶 + 最后一步爬俩个台阶
            dp[i % 2] = dp[(i - 1) % 2] + dp[(i - 2) % 2];
        }
        return dp[n % 2];
    }

}
