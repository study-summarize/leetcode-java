package org.github.fourth.leetcode;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.github.fourth.Top100;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 */
@Top100
public class LeetCode_239_maxSlidingWindow {


    /**
     * 暴力方法：双层for循环
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
    public int[] maxSlidingWindow01(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return null;
        }
        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;

        for (int i = 0; i < nums.length - k + 1; i++) {
            int currentMax = Integer.MIN_VALUE;
            for (int j = i; j - i < k; j++) {
                currentMax = Math.max(currentMax, nums[j]);
            }
            result[resultIndex++] = currentMax;
        }
        return result;
    }

    /**
     * todo: 同向型双指针-滑动窗口
     * 时间复杂度：
     * 空间复杂度：
     */
    @SuppressFBWarnings("UC_USELESS_OBJECT")
    public int[] maxSlidingWindow02(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return null;
        }
        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        int start = 0;
        int end = 0;
        int currentMax = Integer.MIN_VALUE;
        for (; start < nums.length; start++) {
            while (end < nums.length) {
                // 不符合条件时，右边界继续扩张
                if (end - start < k) {
                    currentMax = Math.max(currentMax, nums[end]);
                    end++;
                } else {
                    break;
                }
            }
            // 符合条件，开始收缩值
            result[resultIndex++] = currentMax;
//            currentMax =
        }

        return null;
    }
}
