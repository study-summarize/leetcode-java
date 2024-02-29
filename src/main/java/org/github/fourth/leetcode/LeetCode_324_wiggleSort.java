package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 */
public class LeetCode_324_wiggleSort {
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public void wiggleSort01(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        Arrays.sort(nums);

        int pos = nums.length % 2 == 0 ? nums.length / 2 : nums.length / 2 + 1;
        int[] smallerNums = new int[pos];
        int[] higherNums = new int[nums.length - pos];
        for (int i = 0; i < nums.length; i++) {
            if (i < pos) {
                smallerNums[i] = nums[i];
            } else {
                higherNums[i - pos] = nums[i];
            }
        }

        int smallerPos = pos - 1;
        int higherPos = higherNums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                // 奇数位置
                nums[i] = smallerNums[smallerPos];
                smallerPos--;
            } else {
                nums[i] = higherNums[higherPos];
                higherPos--;
            }
        }
    }
}
