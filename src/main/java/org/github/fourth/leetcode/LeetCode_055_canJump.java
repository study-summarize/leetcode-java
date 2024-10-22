package org.github.fourth.leetcode;

import org.github.fourth.Top100;

@Top100
public class LeetCode_055_canJump {
    public boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }

        // dp：nums[i]能否到达最后一个下标
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (dp[j] && nums[i] >= j - i) {
                    dp[i] = true;
                }
            }
        }
        return dp[0];
    }
}
