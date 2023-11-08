package org.github.fourth.leetcode;

/**
 * @author jwang55
 */
public class LeetCode_011_maxArea {

    public int maxArea(int[] height) {
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
