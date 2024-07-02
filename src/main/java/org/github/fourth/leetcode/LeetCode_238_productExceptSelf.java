package org.github.fourth.leetcode;


import org.github.fourth.Top100;

/**
 * 给你一个整数数组`nums`，返回数组`answer`，其中`answer[i]`等于`nums`中除`nums[i]`之外其余各元素的乘积。
 * 题目数据保证数组`nums`之中任意元素的全部前缀元素和后缀的乘积都在32位整数范围内。
 * 请不要使用除法，且在`O(n)`时间复杂度内完成此题。
 */
@Top100
public class LeetCode_238_productExceptSelf {

    /**
     * 前缀积模板
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] answer = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            answer[i] = left[i] * right[i];
        }
        return answer;
    }

    /**
     * 优化空间复杂度，因为left、right数组其实只用了一次
     */
    public int[] productExceptSelfExample(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] answer = new int[nums.length];

        // 先用这个数组求前缀积
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // 后缀积可以直接用factor来表示
        int factor = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * factor;
            factor = factor * nums[i];
        }

        return answer;
    }
}
