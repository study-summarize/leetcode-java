package org.github.fourth.leetcode;


/**
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 */
public class LeetCode_069_mySqrt {
    /**
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     */
    public int mySqrt(int x) {
        if (x < 0) {
            return -1;
        }
        if (x == 0 || x == 1) {
            return x;
        }

        int start = 1;
        int end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // note: 要用除法，防止溢出
            if (x / mid > mid) {
                start = mid;
            } else if (x / mid < mid) {
                end = mid;
            } else {
                return mid;
            }
        }

        // 为了防止溢出
        if (start <= x / start) {
            return start;
        }
        if (end <= x / end) {
            return end;
        }
        return - 1;
    }
}
