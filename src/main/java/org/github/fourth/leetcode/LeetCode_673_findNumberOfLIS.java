package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 * 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
 * 注意 这个数列必须是 严格 递增的。
 * 4步设计动态规划：
 * （1）定义状态：dp[n]，nums[n]下的最长递增子序列个数
 * （2）状态转移：dp[n] = nums[n] > nums[n - 1] ? dp[n - 1] : dp[n - 1] + 1
 * （3）初始状态：dp[0] = 1
 * （4）求最优解
 */
public class LeetCode_673_findNumberOfLIS {

    /**
     * 方法一：自顶向下的动态规划
     */
    public int findNumberOfLIS01(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return findNumberOfLIS01Helper(nums, dp, nums.length - 1);
    }

    private int findNumberOfLIS01Helper(int[] nums, int[] dp, int i) {
        if (dp[i] != -1) {
            return dp[i];
        }
        dp[i] = nums[i] > nums[i - 1] ? findNumberOfLIS01Helper(nums, dp, i - 1)
                : findNumberOfLIS01Helper(nums, dp, i - 1) + 1;
        return dp[i];
    }

    /**
     * 方法二：自底向上的动态规划
     */
    public int findNumberOfLIS02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] > nums[i - 1] ? dp[i - 1] : dp[i - 1] + 1;
        }
        return dp[nums.length - 1];
    }

    /**
     * 方法三：自底向上的动态规划 + 滚动数组
     */
    public int findNumberOfLIS03(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int dp = 1;
        for (int i = 1; i < nums.length; i++) {
            dp = nums[i] > nums[i - 1] ? dp : dp + 1;
        }
        return dp;
    }

    /**
     * 动态规划、制表法找function
     * 时间复杂度：
     * 空间复杂度：
     */
    @SuppressWarnings("EmptyBlock")
    public int findNumberOfLISExample(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // state：dp[i] ：以nums[i]结尾的最长严格递增子序列的长度
        // 由于最终要遍历dp数组取最长严格递增子序列的长度，所以无法状态压缩，不能用滚动数组
        int[] dp = new int[nums.length];
        // condition：每个以nums[i]结尾的最长严格递增子序列的最小长度至少为1
        Arrays.fill(dp, 1);

        // count[i]：以nums[i]结尾的最长严格递增子序列的个数
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);

        // function：制表法得到递归函数表达式
        for (int i = 0; i < nums.length; i++) {
            // 遍历找之前结尾比nums[i]小的递增子序列，然后找到其中最长的
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // 判断dp[i], dp[j] + 1大小关系
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        // 这种情况相当于找到新的LIS
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        // 又一次遇到了该长度的LIS
                        count[i] += count[j];
                    } else {
                        // 不符合LIS：dp[i] > dp[j] + 1，说明没有新的LIS

                    }
                }
            }
        }

        // solution：遍历dp数组计算结果
        int max = 0;
        for (int value : dp) {
            max = Math.max(max, value);
        }

        // 将所有等于最长严格递增子序列的长度count[i]相加
        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max) {
                result += count[i];
            }
        }
        return result;
    }
}
