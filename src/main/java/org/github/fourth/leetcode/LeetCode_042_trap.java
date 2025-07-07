package org.github.fourth.leetcode;


import org.github.fourth.Top100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
@Top100
public class LeetCode_042_trap {

    /**
     * 三次遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int trap1(int[] height) {
        int result = 0;
        if (height == null || height.length == 0) {
            return result;
        }

        // 从左到右，记录i的左边界
        int[] left = new int[height.length];
        int maxLeft = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            maxLeft = Math.max(height[i], maxLeft);
            left[i] = maxLeft;
        }

        // 从右到左，记录i的右边界
        int[] right = new int[height.length];
        int maxRight = Integer.MIN_VALUE;
        for (int i = height.length - 1; i >= 0; i--) {
            maxRight = Math.max(height[i], maxRight);
            right[i] = maxRight;
        }

        // 计算总灌水量
        for (int i = 0; i < height.length; i++) {
            int minHeight = Math.min(left[i], right[i]);
            // 只有左右边界都存在，且比最小边界大时；才能接雨水。但这里其实不需要
            if (minHeight > height[i]) {
                result += (minHeight - height[i]);
            }
        }
        return result;
    }

    /**
     * 方法一优化版本：减少一次遍历
     * 时间复杂度：
     * 空间复杂度：
     */
    public int trap1Refine(int[] height) {
        int result = 0;
        if (height == null || height.length == 0) {
            return result;
        }

        // 记录i的边界高度
        int[] h = new int[height.length];

        // 从左往右记录左边界
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(height[i], max);
            h[i] = max;
        }

        // 从右到左，计算真正的边界高度以及接雨水量
        max = Integer.MIN_VALUE;
        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(height[i], max);
            int right = max;
            int left = h[i];
            if (Math.min(right, left) > height[i]) {
                result += (Math.min(right, left) - height[i]);
            }
        }
        return result;
    }


    /**
     * 方法二：双指针一次遍历
     * 时间复杂度：
     * 空间复杂度：
     * note：有点难理解，易错
     */
    public int trap2(int[] height) {
        int result = 0;
        if (height == null || height.length == 0) {
            return result;
        }

        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];

        while (left <= right) {
            if (leftMax < rightMax) {
                // 短板往前走
                leftMax = Math.max(leftMax, height[left]);
                result += (leftMax - height[left]);
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                result += (rightMax - height[right]);
                right--;
            }
        }
        return result;
    }


    /**
     * 单调栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int trap3(int[] height) {
        int area = 0;
        if (height == null || height.length == 0) {
            return area;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        // 从左到右，递减栈。弹栈时，就是比栈中元素大的时候
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // 比index元素大的值出现了。此时求index元素左右边界的值
                int index = stack.pop();
                // 弹出后，此时栈元素可能为空
                if (!stack.isEmpty()) {
                    // 左边界都是放在栈上的
                    int left = stack.peek();
                    int right = i;
                    // 求出左右边界的最小值。
                    int minHigh = Math.min(height[left], height[right]);
                    area = area + (minHigh - height[index]) * (right - left - 1);
                }
            }
            stack.push(i);
        }
        return area;
    }
}
