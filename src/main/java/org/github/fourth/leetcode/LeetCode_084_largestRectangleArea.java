package org.github.fourth.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class LeetCode_084_largestRectangleArea {


    /**
     * 俩次最小栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int largestRectangleArea02(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        // 右边比当前元素小
        int[] right = new int[heights.length];
        // 左边比当前元素小
        int[] left = new int[heights.length];

        // 为了防止没有比当前元素小的，方便计算长度
        Arrays.fill(right, heights.length); // 为什么这里用length而不是length-1。因为我们存的下标都是减了一位的
        Arrays.fill(left, -1); // 为什么不用0，而用-1。因为会存在下一个比当前元素小的下标正好是0

        Deque<Integer> stack = new LinkedList<>();
        // 从左到右，递增栈
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                Integer index = stack.pop();
                right[index] = i;
            }
            stack.push(i);
        }
        stack.clear();
        // 从右到左，递增栈
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                Integer index = stack.pop();
                left[index] = i;
            }
            stack.push(i);
        }

        // 最固定高度下的最大面积
        int result = -1;
        for (int i = 0; i < heights.length; i++) {
            result = Math.max(result, (right[i] - left[i] - 1) * heights[i]);
        }

        return result;
    }

    /**
     * 一次最小栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int largestRectangleArea03(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        // 右边比当前元素小
        int[] right = new int[heights.length];
        // 左边比当前元素小
        int[] left = new int[heights.length];

        // 为了防止没有比当前元素小的，方便计算长度
        Arrays.fill(right, heights.length); // 为什么这里用length而不是length-1。因为我们存的下标都是减了一位的
        Arrays.fill(left, -1); // 为什么不用0，而用-1。因为会存在下一个比当前元素小的下标正好是0

        Deque<Integer> stack = new LinkedList<>();
        // 从左到右，递增栈
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                Integer index = stack.pop();
                right[index] = i;
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // 最固定高度下的最大面积
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            result = Math.max(result, (right[i] - left[i] - 1) * heights[i]);
        }

        return result;
    }


    /**
     * 暴力解法：俩层for循环
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public int largestRectangleArea01(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int result = -1;
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            result = Math.max(result, min);
            // 不需要考虑之前左边的元素；因为之前已经算过了
            for (int j = i + 1; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                result = Math.max(result, min * (j - i + 1));
            }
        }
        return result;
    }
}
