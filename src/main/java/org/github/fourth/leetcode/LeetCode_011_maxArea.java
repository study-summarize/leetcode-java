package org.github.fourth.leetcode;

import org.github.fourth.Top100;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 */
@Top100
public class LeetCode_011_maxArea {
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            int currentResult = (end - start) * Math.min(height[start], height[end]);
            result = Math.max(result, currentResult);
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }

    public int maxAreaExample(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int start = 0;
        int end = height.length - 1;
        int maxArea = 0;
        while (start < end) {
            int area = Math.min(height[start], height[end]) * (end - start);
            maxArea = Math.max(area, maxArea);
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }
}
