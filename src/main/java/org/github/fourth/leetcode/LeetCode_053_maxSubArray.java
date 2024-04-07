package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * 4步设计动态规划：
 * （1）定义状态：dp[n]，以nums[n]结尾的最大和连续子数组的最大和
 * （2）状态转移：dp[n] = dp[n - 1] > 0 ? dp[n - 1] + nums[n] : nums[n]
 * （3）初始状态：dp[0] = nums[0] > 0 ? nums[0] : 0;
 * （4）求最优解：dp[n]
 */
public class LeetCode_053_maxSubArray {

    /**
     * 方法一：自顶向下的动态规划
     */
    public Integer maxSubArray01(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];
        maxSubArray01Helper(nums, dp, nums.length - 1);
        // solution: 寻找最大值
        int result = Integer.MIN_VALUE;
        for (int value : dp) {
            result = Math.max(value, result);
        }
        return result;
    }

    private Integer maxSubArray01Helper(int[] nums, int[] dp, int i) {
        if (dp[i] != -1) {
            return dp[i];
        }
        dp[i] = maxSubArray01Helper(nums, dp, i - 1) > 0 ? maxSubArray01Helper(nums, dp, i - 1) + nums[i] : nums[i];
        return dp[i];
    }

    /**
     * 方法二：自底向上的动态规划
     */
    public Integer maxSubArray02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
        }
        int result = Integer.MIN_VALUE;
        for (int i : dp) {
            result = Math.max(result, i);
        }
        return result;
    }

    /**
     * 方法三：自底向上的动态规划 + 滚动数组
     */
    public Integer maxSubArray03(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int dp = nums[0];
        int result = dp;
        for (int i = 1; i < nums.length; i++) {
            dp = dp > 0 ? dp + nums[i] : nums[i];
            result = Math.max(result, dp);
        }
        return result;
    }


    /**
     * 动态规划
     * 时间复杂度：
     * 空间复杂度：
     */
    public int maxSubArrayExample(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // state-dp[i]：以nums[i]结尾的子数组最大和
        int[] dp = new int[nums.length];
        // condition: dp[0] = nums[0]
        dp[0] = nums[0];
        // function: 制表法 => 1. 如果dp[i-1]为负，说明没有正收益，dp[i] = nums[i]；2. 如果dp[i-1]为正收益，dp[i] = dp[i-1] + nums[i]
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        // solution: 寻找最大值
        int result = Integer.MIN_VALUE;
        for (int value : dp) {
            result = Math.max(value, result);
        }
        return result;
    }

    /**
     * 动态规划、滚动数组优化
     * 时间复杂度：
     * 空间复杂度：
     */
    public int maxSubArrayExampleRefine(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // state-dp[i]：以nums[i]结尾的子数组最大和
        // condition: dp[0] = nums[0]
        int dp = nums[0];

        int result = dp;
        // function: 制表法 => 1. 如果dp[i-1]为负，说明没有正收益，dp[i] = nums[i]；2. 如果dp[i-1]为正收益，dp[i] = dp[i-1] + nums[i]
        for (int i = 1; i < nums.length; i++) {
            if (dp > 0) {
                dp = dp + nums[i];
            } else {
                dp = nums[i];
            }
            result = Math.max(result, dp);
        }
        // solution: 寻找最大值
        return result;
    }
}
