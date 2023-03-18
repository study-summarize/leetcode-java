package leetcode;

public class Test_198_rob {

    /**
     * 滚动数组优化、动态规划
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // dp[i]：在第i个房子时，获得的最大金额
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = nums[0];

        // function: dp[i]
        for (int i = 2; i <= nums.length; i++) {
            dp[i % 2] = Math.max(
                    dp[(i - 1) % 2],
                    dp[(i - 2) % 2] + nums[i - 1] // nums[i-1]表示第n-2个房子
            );
        }

        // solution
        return dp[nums.length % 2];
    }
}
