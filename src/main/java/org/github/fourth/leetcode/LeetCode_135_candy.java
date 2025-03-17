package org.github.fourth.leetcode;

public class LeetCode_135_candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int n = ratings.length;

        // left[i]：ratings[i]满足比左边大所需要的最少糖果
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                // 只要不比左边大，就给他设置一个最小值
                left[i] = 1;
            }
        }

        // right[i]: ratings[i]满足比右边大所需要的最少糖果
        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }

        int result = 0;
        // 最后求职就是max(left[i], right[i])
        for (int i = 0; i < n; i++) {
            result += Math.max(left[i], right[i]);
        }
        return result;
    }
}
