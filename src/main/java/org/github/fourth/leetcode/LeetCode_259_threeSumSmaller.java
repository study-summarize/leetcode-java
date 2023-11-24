package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 */
public class LeetCode_259_threeSumSmaller {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        if (nums == null || nums.length == 0) {
            return count;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum < target) {
                    count += (end - start);
                    start++;
                } else {
                    end--;
                }
            }
        }
        return count;
    }
}
