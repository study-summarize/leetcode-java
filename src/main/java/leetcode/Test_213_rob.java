package leetcode;

public class Test_213_rob {

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
