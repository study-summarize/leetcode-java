package org.github.fourth.leetcode;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 测试用例的答案是一个 32-位 整数。
 * 子数组 是数组的连续子序列。
 */
public class LeetCode_152_maxProduct {

    /**
     * 动态规划
     * 时间复杂度：
     * 空间复杂度：
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // state 考虑附属的情况，一个负数乘以一个负数为正数，负数越小，相乘结果越大
        // maxDp[i]：以nums[i]结尾的子数组最大乘积
        // minDp[i]：以nums[i]结尾的子数组最大乘积
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];

        // condition:
        // maxDp[0] = nums[0], minDp[0] = nums[0]
        maxDp[0] = nums[0];
        minDp[0] = nums[0];

        // function
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 先假设当前值是最优值，省的后面去比较
            maxDp[i] = minDp[i] = nums[i];

            if (nums[i] > 0) {
                maxDp[i] = Math.max(maxDp[i], maxDp[i - 1] * nums[i]);
                minDp[i] = Math.min(minDp[i], minDp[i - 1] * nums[i]);
            } else if (nums[i] < 0) {
                maxDp[i] = Math.max(maxDp[i], minDp[i - 1] * nums[i]);
                minDp[i] = Math.min(minDp[i], maxDp[i - 1] * nums[i]);
            }
            result = Math.max(maxDp[i], result);
        }

        return result;
    }
}
