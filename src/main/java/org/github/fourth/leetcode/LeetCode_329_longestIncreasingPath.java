package org.github.fourth.leetcode;

/**
 * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
 */
public class LeetCode_329_longestIncreasingPath {

    /**
     *
     */
    public int longestIncreasingPath01(int[][] matrix) {
        return 0;
    }

    int[] dxExample = {1, 0, -1, 0};
    int[] dyExample = {0, 1, 0, -1};
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int longestIncreasingPathExample(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        // 记忆化搜索：memo[i][j]：以i,j开始最大递增路径长度
        int[][] memo = new int[m][n];

        int longestPath = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    longestPath = Math.max(dfsExample(matrix, visited, memo, i, j), longestPath);
                }
            }
        }
        return longestPath;
    }

    private int dfsExample(int[][] matrix, boolean[][] visited, int[][] memo, int curX, int curY) {
        // 记忆化搜索
        if (visited[curX][curY]) {
            return memo[curX][curY];
        }

        int result = 1;
        visited[curX][curY] = true;
        for (int i = 0; i < 4; i++) {
            int newX = curX + dxExample[i];
            int newY = curY + dyExample[i];
            /*
             * 减枝：
             * (1)新节点要在范围内
             * (2)新节点要大于当前节点
             * (3)新节点未被访问过
             */
            if (checkRangeExample(matrix, newX, newY)
                    && matrix[newX][newY] > matrix[curX][curY]) {
                result = Math.max(result, dfsExample(matrix, visited, memo, newX, newY) + 1);
            }
        }
        memo[curX][curY] = result;
        return result;
    }

    private boolean checkRangeExample(int[][] matrix, int x, int y) {
        return x >= 0
                && x < matrix.length
                && y >= 0
                && y < matrix[0].length;

    }
}
