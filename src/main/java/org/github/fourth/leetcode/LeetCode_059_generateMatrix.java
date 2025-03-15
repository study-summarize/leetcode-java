package org.github.fourth.leetcode;

public class LeetCode_059_generateMatrix {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }

        int count = n * n;

        int[][] result = new int[n][n];
        int[][] go = new int[4][2];
        go[0] = new int[]{0, 1};
        go[1] = new int[]{1, 0};
        go[2] = new int[]{0, -1};
        go[3] = new int[]{-1, 0};

        int xIndex = 0;
        int yIndex = -1;
        int currentValue = 0;
        for (int i = 0; i < 4; i = (i + 1) % 4) {
            int[] direction = go[i];
            // 判断按照direction不会越界
            while (notCross(xIndex, yIndex, direction, n, result)) {
                xIndex = xIndex + direction[0];
                yIndex = yIndex + direction[1];
                count--;
                result[xIndex][yIndex] = currentValue + (direction[1] + direction[0] * n);
                currentValue = result[xIndex][yIndex];
            }
            if (count == 0) {
                break;
            }
        }
        return result;
    }

    private static boolean notCross(int xIndex, int yIndex, int[] direction, int n, int[][] result) {
        int newXIndex = xIndex + direction[0];
        int newYIndex = yIndex + direction[1];
        return newXIndex >= 0 && newXIndex < n
                && newYIndex >= 0 && newYIndex < n
                && result[newXIndex][newYIndex] == 0;
    }
}
