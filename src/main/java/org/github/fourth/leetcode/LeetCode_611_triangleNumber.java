package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 */
public class LeetCode_611_triangleNumber {

    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);
        int count = 0;
        // 第三边：从后往前取
        for (int i = nums.length - 1; i >= 2; i--) {
            int start = 0;
            int end = i - 1;
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum > nums[i]) {
                    count += (end - start);
                    end--;
                } else {
                    start++;
                }
            }
        }
        return count;
    }
}
