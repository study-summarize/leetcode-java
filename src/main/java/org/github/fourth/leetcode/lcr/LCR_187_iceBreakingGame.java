package org.github.fourth.leetcode.lcr;

import java.util.Arrays;

/**
 * 社团共有 num 位成员参与破冰游戏，编号为 0 ~ num-1。成员们按照编号顺序围绕圆桌而坐。社长抽取一个数字 target，从 0 号成员起开始计数，排在第 target 位的成员离开圆桌，且成员离开后从下一个成员开始计数。请返回游戏结束时最后一位成员的编号。
 * 动态规划四步骤：
 * 1、定义状态
 * 2、状态转移
 * 3、定义初始化值
 * 4、求最优解
 */
public class LCR_187_iceBreakingGame {

    /**
     * 自底向上求解
     */
    public int iceBreakingGame01(int num, int target) {
        if (num < 1 || target < 1) {
            return -1;
        }
        // dp[i] : 有i个人，每target抽取离开，最后一个成员的编号
        int[] dp = new int[num + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 0;

        return dpHelper(dp, target, num);
    }


    private static int dpHelper(int[] dp, int target, int position) {
        // 看有没有计算过
        if (dp[position] != -1) {
            return dp[position];
        }

        int result = (dpHelper(dp, target, position - 1) + target) % position;
        dp[position] = result;
        return result;
    }

    /**
     * 自顶向下 + 滚动数组
     */
    public int iceBreakingGame02(int num, int target) {
        if (num < 1 || target < 1) {
            return -1;
        }
        // dp[i]: 第i个人，每target抽离一个人，最后一人的初始编号
        int[] dp = new int[2];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 0;

        // 求解
        for (int i = 2; i <= num; i++) {
            dp[i % 2] = (dp[(i - 1) % 2] + target) % i;
        }
        return dp[num % 2];
    }
}
