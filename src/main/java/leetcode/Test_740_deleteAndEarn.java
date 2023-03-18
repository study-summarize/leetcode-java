package leetcode;

public class Test_740_deleteAndEarn {

    /**
     * 打家劫舍、滚动数组、动态规划
     */
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 找nums中的最大值，确定values数组的长度
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // 计算values数组：num作为index，点数价值作为value。点数价值 = num * num在nums中出现的次数
        int[] values = new int[max + 1];
        for (int num : nums) {
            values[num] += num;
        }

        // 打家劫舍问题
        // state：dp[i] 表示前i个获取的最大价值
        int[] dp = new int[2];
        dp[0] = values[0]; // 0
        dp[1] = Math.max(values[0], values[1]);
        // function：dp[i] = max(dp[i - 1], dp[i - 2] + values[i])
        for (int i = 2; i < values.length; i++) {
            dp[i % 2] = Math.max(
                    dp[(i - 1) % 2],
                    dp[(i - 2) % 2] + values[i]);
        }
        return dp[(values.length - 1) % 2];
    }
}
