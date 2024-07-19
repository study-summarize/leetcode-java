package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 关键提取：
 * 一段连续数组，有限制：不能取相邻的，最大组合值是多少
 * 思考过程：
 * 偷到n获取的最大值 = 偷到n-1的最大值、偷到n-2的最大值 + n
 * 四步设计：
 * （1）定义状态：dp[i]：偷到第i个房子所能得到的最大值
 * （2）状态转移：dp[i] = Math.max(dp[i - 1] + nums[i + 1], dp[i - 2] + nums[i])
 * （3）初始条件：dp[0] = nums[0] dp[1] = Math.max(nums[0], nums[1])
 * （3）求最优解：dp[n]
 */

/**
 * 4步设计：
 * （1）定义状态：dp[n]：最后偷第n个房子，能偷窃到最高金额
 * （2）状态转移：dp[n] = Math.max(dp[n - 1], dp[n - 2] + nums[n])
 * （3）初始条件：dp[0] = nums[0]； dp[1] = Math.max(nums[0], nums[1])
 * （4）求最优解：dp[n]
 */
public class LeetCode_198_rob {

    public int test(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 特殊条件
        if (nums.length == 1) {
            return nums[0];
        }

        // 定义状态
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        // 初始条件
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = testHelper(i, dp, nums);
        }
        return dp[nums.length - 1];
    }

    private int testHelper(int pos, int[] dp, int[] nums) {
        if (dp[pos] != -1) {
            return dp[pos];
        }

        dp[pos] = Math.max(
                dp[pos - 2] + nums[pos],
                dp[pos - 1]
        );
        return dp[pos];
    }

    /**
     * 方法一：自顶向下的动态规划
     */
    public int rob01(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 存储各个状态数组
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);

        return rob01Helper(nums, dp, nums.length);
    }

    private int rob01Helper(int[] nums, int[] dp, int i) {
        if (dp[i] != -1) {
            return dp[i];
        }

        dp[i] = Math.max(rob01Helper(nums, dp, i - 1), rob01Helper(nums, dp, i - 2) + nums[i - 1]);
        return dp[i];
    }

    /**
     * 方法二：自底向上的动态规划
     */
    public int rob02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 状态记录
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }

    /**
     * 方法三：自底向上的动态规划 + 滚动数组
     */
    public int rob03(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 状态记录
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= nums.length; i++) {
            dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + nums[i - 1]);
        }
        return dp[nums.length % 2];
    }

    /**
     * 滚动数组优化、动态规划
     * 时间复杂度：
     * 空间复杂度：
     */
    public int robExample(int[] nums) {
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
