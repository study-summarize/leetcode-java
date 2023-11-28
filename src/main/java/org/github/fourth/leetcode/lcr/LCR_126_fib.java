package org.github.fourth.leetcode.lcr;

/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 * <br/>
 * 答案需要取模 1e9+7(1000000007) ，如计算初始结果为：1000000008，请返回 1。
 */
public class LCR_126_fib {
    /**
     * todo:时间复杂度：T(n) = 2T(n/n-1) + f(n)
     * 空间复杂度：
     */
    public int fib(int n) {
        return fibHelper(n);
    }

    private static int fibHelper(int n) {
        // 最小子问题；递归终止条件
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        // 递归公式
        return fibHelper(n - 1) + fibHelper(n - 2);
    }
}
