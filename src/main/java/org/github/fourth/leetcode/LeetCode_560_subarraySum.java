package org.github.fourth.leetcode;

/**
 * 给你一个整数数组`nums`和一个整数`k`，请你统计并返回该数组中和为`k`的子数组的个数。
 * 子数组是数组中元素的连续非空序列。
 */
public class LeetCode_560_subarraySum {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 一维数组前缀和模板
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int result = 0;
        // 遍历nums的所有子数组
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                result++;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (prefixSum[j + 1] - prefixSum[i] == k) {
                    result++;
                }
            }
        }
        return result;
    }
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int subarraySumExample(int[] nums, int k) {
        return subarraySum(nums, k);
    }

}
