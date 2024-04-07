package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 测试用例的答案是一个 32-位 整数。
 * 子数组 是数组的连续子序列。
 * 分析：
 * 需要转换成俩个dp；一个最大，一个最小
 * 4步设计动态规划：
 * （1）定义状态：maxDp[n]，以nums[n]结尾的连续子数组的最大值；minDp[n]，以nums[n]结尾的连续子数组的最小值
 * （2）状态转移：
 * - nums[n] >= 0, maxDp[n] = Math.max(nums[n], maxDp[n - 1] * nums[n])，minDp[n] = Math.min(nums[n], minDp[n - 1] * nums[n])
 * - nums[n] <= 0, maxDp[n] = Math.max(nums[n], minDp[n - 1] * nums[n]), minDp[n] = Math.min(nums[n], maxDp[n - 1] * nums[n])
 * （3）初始状态：maxDp[0] = nums[0]; minDp[0] = nums[0]
 * （4）求最优解：
 */
public class LeetCode_152_maxProduct {

    /**
     * 方法一：自底向上的动态规划
     */
    public int maxProduct01(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] maxDp = new int[nums.length];
        Arrays.fill(maxDp, -1);
        maxDp[0] = nums[0];

        int[] minDp = new int[nums.length];
        Arrays.fill(minDp, -1);
        minDp[0] = nums[0];

        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                maxDp[i] = Math.max(nums[i], maxDp[i - 1] * nums[i]);
                minDp[i] = Math.min(nums[i], minDp[i - 1] * nums[i]);
            } else {
                maxDp[i] = Math.max(nums[i], minDp[i - 1] * nums[i]);
                minDp[i] = Math.min(nums[i], maxDp[i - 1] * nums[i]);
            }
            result = Math.max(maxDp[i], result);
        }
        return result;
    }


    /**
     * 动态规划
     * 时间复杂度：
     * 空间复杂度：
     */
    public int maxProductExample(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // state 考虑附属的情况，一个负数乘以一个负数为正数，负数越小，相乘结果越大
        // maxDp[i]：以nums[i]结尾的子数组最大乘积
        // minDp[i]：以nums[i]结尾的子数组最小乘积
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
