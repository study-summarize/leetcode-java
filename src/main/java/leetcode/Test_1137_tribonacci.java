package leetcode;

public class Test_1137_tribonacci {

    /**
     * 滚动数组、动态规划
     */
    public int tribonacci(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int[] f = new int[3];
        f[0] = 0;
        f[1] = 1;
        f[2] = 1;

        for (int i = 3; i <= n; i++) {
            f[i % 3] = f[(i - 1) % 3] + f[(i - 2) % 3] + f[(i - 3) % 3];
        }

        return f[n % 3];
    }
}
