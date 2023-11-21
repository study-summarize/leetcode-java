package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * - F(0) = 0，F(1) = 1
 * - F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 */
public class LeetCode_509_fib {


    /**
     * 方法一：递归法
     */
    public int fib1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * 方法二：动态规划-记忆化搜索-自顶向下
     */
    public int fib2(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return fib2Helper(n, memo);
    }

    /**
     * 方法三：动态规划-记忆化搜索-自底向上
     */
    public int fib3(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    /**
     * 方法四：动态规划-记忆化搜索-自底向上-滚动数组
     */
    public int fib4(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] memo = new int[2];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            memo[i % 2] = memo[(i - 1) % 2] + memo[(i - 2) % 2];
        }
        return memo[n % 2];
    }

    private int fib2Helper(int n, int[] memo) {
        if (memo[n] != -1) {
            return memo[n];
        }

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int result = fib2Helper(n - 1, memo) + fib2Helper(n - 2, memo);
        memo[n] = result;
        return result;
    }
}
