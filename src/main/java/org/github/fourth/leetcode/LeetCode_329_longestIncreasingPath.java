package org.github.fourth.leetcode;

/**
 * @author jwang55
 */
public class LeetCode_329_longestIncreasingPath {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int longestIncreasingPath(int[][] matrix) {
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
                    longestPath = Math.max(dfs(matrix, visited, memo, i, j), longestPath);
                }
            }
        }
        return longestPath;
    }

    private int dfs(int[][] matrix, boolean[][] visited, int[][] memo, int curX, int curY) {
        // 记忆化搜索
        if (visited[curX][curY]) {
            return memo[curX][curY];
        }

        int result = 1;
        visited[curX][curY] = true;
        for (int i = 0; i < 4; i++) {
            int newX = curX + dx[i];
            int newY = curY + dy[i];
            /*
             * 减枝：
             * (1)新节点要在范围内
             * (2)新节点要大于当前节点
             * (3)新节点未被访问过
             */
            if (checkRange(matrix, newX, newY)
                    && matrix[newX][newY] > matrix[curX][curY]) {
                result = Math.max(result, dfs(matrix, visited, memo, newX, newY) + 1);
            }
        }
        memo[curX][curY] = result;
        return result;
    }

    private boolean checkRange(int[][] matrix, int x, int y) {
        return x >= 0
                && x < matrix.length
                && y >= 0
                && y < matrix[0].length;

    }
}
