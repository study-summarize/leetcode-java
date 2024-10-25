package org.github.fourth.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 思路：
 * 这道题目其实就是求数组完全升序后，左右俩边区域的最值。其实可以通过排序和单调栈来计算，但都要计算俩边
 * 解法：
 */
public class LeetCode_581_findUnsortedSubarray {

    public int findUnsortedSubarray01(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] sortNums = new int[nums.length];
        System.arraycopy(nums, 0, sortNums, 0, nums.length);
        Arrays.sort(sortNums);

        // 查最左边的最大值
        int left = -1;
        for (int i = 0; i < nums.length; i++) {
            if (sortNums[i] == nums[i]) {
                left = i;
            } else {
                // 防止后续数组排序又突然符合
                break;
            }
        }
        // 查最右边的最小值
        int right = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (sortNums[i] == nums[i]) {
                right = i;
            } else {
                // 防止后续数组排序又突然符合
                break;
            }
        }
        return right - left - 1 > 0 ? right - left - 1 : 0;
    }

    /**
     * 单调栈解法：
     * 有点复杂
     */
    public int findUnsortedSubarray02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = nums.length;
        int right = 0;

        // 求最左边的区间最大值
        Deque<Integer> maxStack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!maxStack.isEmpty() && nums[i] < nums[maxStack.peek()]) {
                left = Math.min(maxStack.pop(), left);
            }
            maxStack.push(i);
        }

        // 求最右边的区间最小值
        Deque<Integer> minStack = new ArrayDeque<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!minStack.isEmpty() && nums[i] > nums[minStack.peek()]) {
                right = Math.max(minStack.pop(), right);
            }
            minStack.push(i);
        }
        return right - left + 1 > 0 ? right - left + 1 : 0;
    }

}
