package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * 分析：
 * 题目不能取num[i] - 1和nums[i] + 1的元素，其实跟抢劫不能偷邻居的一致，所以需要转换一下。
 * 找到最大元素max，重新计算value[max + 1]数组, 其中value[nums[i]] = nums[i] * count
 * 4步设计动态规划：
 * （1）定义状态：
 * （2）状态转移：
 * （3）初始条件：
 * （4）求最优解：
 */
public class LeetCode_740_deleteAndEarn {


    /**
     * 方法一：从顶到底的动态规划
     */
    public int deleteAndEarn01(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 找出最大元素
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        // 重新计算values数组
        int[] values = new int[max + 1];
        for (int num : nums) {
            values[num] += num;
        }

        // 转换成从values数组取值，如果取了values[i]，就不能取values[i - 1]、values[i + 1]
        int[] dp = new int[values.length + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = values[0];

        return deleteAndEarn01Helper(dp, values, values.length);
    }

    private int deleteAndEarn01Helper(int[] dp, int[] values, int n) {
        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = Math.max(deleteAndEarn01Helper(dp, values, n - 1), deleteAndEarn01Helper(dp, values, n - 2) + values[n - 1]);
        return dp[n];
    }


    /**
     * 方法二：从底向上的动态规划
     */
    public int deleteAndEarn02(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 计算最大值max
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        // 重新计算value数组
        int[] values = new int[max + 1];
        for (int num : nums) {
            values[num] += num;
        }
        // 转换成动态规划
        int[] dp = new int[values.length + 1];
        dp[0] = 0;
        dp[1] = values[0];
        for (int i = 2; i <= values.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + values[i - 1]);
        }
        return dp[values.length];
    }


    /**
     * 方法三：从底向上的动态规划 + 滚动数组
     */
    public int deleteAndEarn03(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 计算最大值max
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        // 重新计算value数组
        int[] values = new int[max + 1];
        for (int num : nums) {
            values[num] += num;
        }
        // 转换成动态规划
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = values[0];
        for (int i = 2; i <= values.length; i++) {
            dp[i % 2] = Math.max(dp[(i - 1) % 2], dp[(i - 2) % 2] + values[i - 1]);
        }
        return dp[values.length % 2];
    }

    /**
     * 打家劫舍、滚动数组、动态规划
     * 时间复杂度：
     * 空间复杂度：
     */
    public int deleteAndEarnExample(int[] nums) {
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
