package org.github.fourth.leetcode;

public class LeetCode_209_minSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0 || target <= 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        int j = 0;

        for (i = 0; i < nums.length; i++) {
            while (j < nums.length) {
                if (sum < target) {
                    sum += nums[j];
                    j++;
                } else {
                    break;
                }
            }
            // 窗口收缩
            if (sum >= target) {
                result = Math.min(result, j - i);
            }
            sum -= nums[i];
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
