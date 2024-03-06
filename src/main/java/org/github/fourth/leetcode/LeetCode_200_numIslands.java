package org.github.fourth.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class LeetCode_200_numIslands {

    /**
     * 二维DFS
     */
    public int numIslands01(char[][] grid) {
        if (grid == null || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int result = 0;
        // 整体访问标记数组
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        // 遍历整个二维数组
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, visited, i, j);
                    ++result;
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, boolean[][] visited, int currX, int currY) {
        // 递归什么时候退出？ 在水里，超过数组范围
        // 减枝
        if (!checkRangeExample(grid, currX, currY) || grid[currX][currY] != '1') {
            return;
        }
        // 将节点置为已访问
        visited[currX][currY] = true;
        // 构建节点执行方向数组
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, -1, 0, 1};
        // 按照方向开始递归遍历所有可能
        for (int i = 0; i < 4; i++) {
            int newX = currX + dx[i];
            int newY = currY + dy[i];
            if (!checkRangeExample(grid, newX, newY) || grid[newX][newY] == '0' || visited[newX][newY]) {
                continue;
            }
            dfs(grid, visited, newX, newY);
        }
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * 使用BFS方法
     * 时间复杂度：
     * 空间复杂度：
     */
    public int numIslandsExample01(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfsExample(grid, visited, new Point(i, j));
                    count++;
                }
            }
        }
        return count;
    }

    private void bfsExample(char[][] grid, boolean[][] visited, Point point) {
        // 1、创建队列
        Queue<Point> queue = new LinkedList<>();
        // 2、加入初始节点，并标记
        queue.offer(point);
        visited[point.x][point.y] = true;
        // 3、BFS遍历
        while (!queue.isEmpty()) {
            Point curPoint = queue.poll();
            for (int i = 0; i < 4; i++) {
                Point newPoint = new Point(curPoint.x + dxExample[i], curPoint.y + dyExample[i]);
                if (checkRangeExample(grid, newPoint.x, newPoint.y)
                        && !visited[newPoint.x][newPoint.y]
                        && grid[newPoint.x][newPoint.y] == '1') {
                    // 加入队列并标记
                    queue.offer(newPoint);
                    visited[newPoint.x][newPoint.y] = true;
                }
            }
        }
    }

    int[] dxExample = {0, 1, 0, -1};
    int[] dyExample = {1, 0, -1, 0};

    /**
     * DFS解法
     */
    public int numIslandsWithDfsExample(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfsExample(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    private void dfsExample(char[][] grid, boolean[][] visited, int x, int y) {

        // 标价访问
        visited[x][y] = true;

        // 移动
        for (int i = 0; i < 4; i++) {
            int newX = x + dxExample[i];
            int newY = y + dyExample[i];
            if (checkRangeExample(grid, newX, newY)
                    && grid[newX][newY] == '1'
                    && !visited[newX][newY]) {
                dfsExample(grid, visited, newX, newY);
            }
        }
    }

    private boolean checkRangeExample(char[][] grid, int x, int y) {
        return x >= 0
                && x < grid.length
                && y >= 0
                && y < grid[0].length;
    }

}
