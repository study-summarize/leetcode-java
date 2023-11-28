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
            if (mid * mid > x) {
                end = mid;
            } else if (mid * mid < x) {
                start = mid;
            } else {
                return mid;
            }
        }
        int lastEnd = end * end;
        int lastStart = start * start;
        // 无论如何，start 永远小于 end
        if (lastEnd < x) {
            return end;
        }
        if (lastStart < x) {
            return start;
        }
        return start - 1;
    }
}
