package leetcode;

import java.util.Arrays;

public class Test_256_minCost {

    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0
                || costs[0] == null || costs[0].length == 0) {
            return 0;
        }

        int n = costs.length;
        // state：dp[i][k]：代表用颜色k粉刷第i个房子的最小花费
        int[][] dp = new int[2][3];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        Arrays.fill(dp[1], Integer.MAX_VALUE);

        // condition
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        // function: dp[i][k] = min(dp[i][k], dp[i-1][j](j != k) + costs[i][k])
        for (int i = 1; i < n; i++) {
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < 3; j++) {
                    if (j != k) {
                        dp[i % 2][k] = Math.min(dp[i % 2][k], dp[(i - 1) % 2][j] + costs[i][k]);
                    }
                }
            }
        }

        // solution: min(dp[n-1][0], dp[n-1][1], dp[n-1][2])
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }

}
