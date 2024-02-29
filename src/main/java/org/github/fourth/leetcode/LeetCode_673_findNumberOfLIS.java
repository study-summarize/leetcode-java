package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 * 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
 * 注意 这个数列必须是 严格 递增的。
 */
public class LeetCode_673_findNumberOfLIS {

    /**
     *
     */
    public int findNumberOfLIS01(int[] nums) {
        return 0;
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
