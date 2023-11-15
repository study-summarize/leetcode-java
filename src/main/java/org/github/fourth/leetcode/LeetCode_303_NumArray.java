package org.github.fourth.leetcode;

/**
 * 给定一个整数数组 nums，处理以下类型的多个查询:
 * 1. 计算索引`left`和`right`（包含`left`和`right`）之间的`nums`元素的和，其中`left <= right`
 * 实现`NumArray`类：
 * - `NumArray(int[] nums)`使用数组`nums`初始化对象
 * - `int sumRange(int i, int j)`返回数组`nums`中索引`left`和`right`之间的元素的总和，包含`left`和`right`两点（也就是`nums[left] + nums[left + 1] + ... + nums[right]`)
 */
public class LeetCode_303_NumArray {

    private final int[] prefixSum;
    public LeetCode_303_NumArray(int[] nums) {
        prefixSum = new int[nums.length + 1];
        // 前缀和数组第0项不使用
        prefixSum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        // 脑中想象一下前缀和数组的下标
        return prefixSum[right + 1] - prefixSum[left];
    }

    public int sumRangeExample(int left, int right) {
        return sumRange(left, right);
    }
}
