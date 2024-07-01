
# 动态规划的四步骤
1、定义状态
2、状态转移
3、初始条件
4、求最优解

```java
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        // 1、定义状态
        int[] dp = new int[n + 1]; // 为什么需要+1？
        // 2、初始条件
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;

        // 3、求最优解
        int result = dpHelper(nums, n, dp); // ...
    }

    // 4、递归状态转移
    private static int dpHelper(int nums, int position, int[] dp) {
        // 初始条件
        if (dp[position] != -1) {
            return dp[position];
        }
        // 状态转移
        int result = dpHelper(nums, position - 1, dp);
        dp[position - 1] = result;
    }
}
```

# 排序
