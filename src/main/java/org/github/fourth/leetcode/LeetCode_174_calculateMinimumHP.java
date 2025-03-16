package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 * 恶魔们抓住了公主并将她关在了地下城 dungeon 的 右下角 。地下城是由 m x n 个房间组成的二维网格。我们英勇的骑士最初被安置在 左上角 的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * 为了尽快解救公主，骑士决定每次只 向右 或 向下 移动一步。
 * 返回确保骑士能够拯救到公主所需的最低初始健康点数。
 * 注意：任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 */
public class LeetCode_174_calculateMinimumHP {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int calculateMinimumHP01(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0
                || dungeon[0] == null || dungeon[0].length == 0) {
            return 0;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;

        // dp[i,j] :（i，j）到终点所需要的最小hp；这样就可以避免对路径和的记录，因为这样是保证路径和是正数
        int[][] dp = new int[m + 1][n + 1];
        // 因为新增的一列一行都是无效的
        for (int[] array : dp) {
            Arrays.fill(array, Integer.MAX_VALUE);
        }
        dp[m - 1][n] = 1;
        dp[m][n - 1] = 1;


        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 骑士血量要大于0
                int hp = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = Math.max(hp, 1);
            }
        }
        return dp[0][0];
    }
}
