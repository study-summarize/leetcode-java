package org.github.fourth.leetcode;

/**
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 */
public class LeetCode_695_maxAreaOfIsland {
    /**
     * 二维DFS
     */
    public int maxAreaOfIsland01(int[][] grid) {
        if (grid == null || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    result = Math.max(result, dfs(grid, visited, i, j, 1));
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid, boolean[][] visited, int currX, int currY, int area) {
        // 递归什么时候退出？
        // 减枝？
        if (!checkRangeExample(grid, currX, currY) || visited[currX][currY] || grid[currX][currY] == 0) {
            return area;
        }
        visited[currX][currY] = true;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int newX = currX + dx[i];
            int newY = currY + dy[i];
            if (!checkRangeExample(grid, newX, newY) || visited[newX][newY] || grid[newX][newY] == 0) {
                continue;
            }
            // note：为什么这里可以直接用area？因为这里不限制前后左右方向的来往，你可以先往前走，再往后走
            area = Math.max(area, dfs(grid, visited, newX, newY, area + 1));
        }
        return area;
    }

    int[] dxExample = {1, 0, -1, 0};
    int[] dyExample = {0, 1, 0, -1};

    /**
     * 二维DFS
     * 时间复杂度：
     * 空间复杂度：
     */
    public int maxAreaOfIslandExample(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 有陆地才进行计算
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(maxArea, dfsExample(grid, visited, i, j));
                }
            }
        }
        return maxArea;
    }

    private int dfsExample(int[][] grid, boolean[][] visited, int x, int y) {
        // 标记访问
        visited[x][y] = true;

        int area = 1;
        // 移动
        for (int i = 0; i < 4; i++) {
            int newX = x + dxExample[i];
            int newY = y + dyExample[i];
            /*
             * 剪枝：
             * 1、还在范围内
             * 2、必须是1
             * 3、未被访问过
             */
            if (checkRangeExample(grid, newX, newY)
                    && grid[newX][newY] == 1
                    && !visited[newX][newY]) {
                area = area + dfsExample(grid, visited, newX, newY);
            }
        }
        return area;
    }

    private boolean checkRangeExample(int[][] grid, int x, int y) {
        return x >= 0
                && x < grid.length
                && y >= 0
                && y < grid[0].length;
    }

}
