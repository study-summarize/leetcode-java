package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 4步设计动态规划：
 * （1）定义状态：dp[n]：最长子序列结尾是nums[n]的长度
 * （2）状态转移：dp[n] = (nums[n] > nums[n - 1]) ? dp[n - 1] + 1 : dp[n - 1]
 * （3）初始状态：dp[0] = 1;
 * （4）求最优解：dp[n]
 */
public class LeetCode_300_lengthOfLIS {

    /**
     * 方法一：自顶向下的动态规划
     */
    public int lengthOfLIS01(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return lengthOfLIS01Helper(nums, dp, nums.length - 1);
    }

    private int lengthOfLIS01Helper(int[] nums, int[] dp, int i) {
        if (dp[i] != -1) {
            return dp[i];
        }
        if (nums[i] > nums[i - 1]) {
            dp[i] = lengthOfLIS01Helper(nums, dp, i - 1) + 1;
        } else {
            dp[i] = lengthOfLIS01Helper(nums, dp, i - 1);
        }
        return dp[i];
    }

    /**
     * 方法二：自底向上的动态规划
     */
    public int lengthOfLIS02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] > nums[i - 1] ? dp[i - 1] + 1 : dp[i - 1];
        }
        return dp[nums.length - 1];
    }

    /**
     * 方法三：自底向上的动态规划 + 滚动数组
     */
    public int lengthOfLIS03(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int dp = 1;
        for (int i = 1; i < nums.length; i++) {
            dp = nums[i] > nums[i - 1] ? dp + 1 : dp;
        }
        return dp;
    }

    /**
     * 动态规划、制表法找function
     * 时间复杂度：
     * 空间复杂度：
     */
    public int lengthOfLISExample(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // state：dp[i] ：以nums[i]结尾的最长严格递增子序列的长度
        // 由于最终要遍历dp数组取最长严格递增子序列的长度，所以无法状态压缩，不能用滚动数组
        int[] dp = new int[nums.length];

        // condition：每个以nums[i]结尾的最长严格递增子序列的最小长度至少为1
        Arrays.fill(dp, 1);

        // function：制表法得到递归函数表达式
        for (int i = 0; i < nums.length; i++) {
            // 遍历找之前结尾比nums[i]小的递增子序列，然后找到其中最长的
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // solution：遍历dp数组计算结果
        int result = 0;
        for (int value : dp) {
            result = Math.max(result, value);
        }
        return result;
    }
}
