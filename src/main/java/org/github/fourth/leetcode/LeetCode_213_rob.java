package org.github.fourth.leetcode;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 */
public class LeetCode_213_rob {

    /**
     * 滚动数组优化、动态规划
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        /*
         * dp[i]代表前i个房子，最大的打劫价值
         *
         * 分成俩个打家劫舍问题1 ：
         * 【1】打劫第1个房子，不能打劫最后一个房子，跳过最后一个房子(通过i==n)
         * dp[0] = 0. dp[1] = nums[0]
         * 【2】跳过第1个房子，打劫第2个房子，可以打劫最后一个房子
         * dp[0] = 0,  dp[1] = 0
         */
        int[] dp1 = new int[2];
        dp1[0] = 0;
        dp1[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            if (i == nums.length) {
                dp1[i % 2] = dp1[(i - 1) % 2];
                continue;
            }
            dp1[i % 2] = Math.max(
                    dp1[(i - 1) % 2],
                    dp1[(i - 2) % 2] + nums[i - 1]);
        }

        int[] dp2 = new int[2];
        dp2[0] = 0;
        dp2[1] = 0;
        for (int i = 2; i <= nums.length; i++) {
            dp2[i % 2] = Math.max(
                    dp2[(i - 1) % 2],
                    dp2[(i - 2) % 2] + nums[i - 1]);
        }

        return Math.max(dp1[nums.length % 2], dp2[nums.length % 2]);
    }
}
