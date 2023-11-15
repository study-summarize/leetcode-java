package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 * 给你一个数组`nums`。数组「动态和」的计算公式为：`runningSum[i] = sum(nums[0]…nums[i])`。
 * 请返回`nums`的动态和。
 */
public class LeetCode_1480_runningSum {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * note: 一维数组动态和
     */
    public int[] runningSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        // 一维数组动态和的模板
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        // 转换成答案
        return Arrays.copyOfRange(prefixSum, 1, prefixSum.length);
    }

    public int[] runningSumExample(int[] nums) {
        return runningSum(nums);
    }
}
