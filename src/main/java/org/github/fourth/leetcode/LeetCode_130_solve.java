package org.github.fourth.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
public class LeetCode_130_solve {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0
                || board[0] == null || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        // 从矩阵边界遍历，将O变成B
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 只对边界的O进行遍历
                if (isEdge(i, j, m, n) && board[i][j] == 'O' && !visited[i][j]) {
                    bfs(board, visited, new Point(i, j));
                }
            }
        }

        // 遍历矩阵，将剩余的O变成X，将B变成O
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(char[][] board, boolean[][] visited, Point startNode) {
        // 1、创建队列
        Queue<Point> queue = new LinkedList<>();
        // 2、加入初始节点，并标记
        queue.offer(startNode);
        visited[startNode.x][startNode.y] = true;
        board[startNode.x][startNode.y] = 'B';
        // 3、BFS遍历
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                Point newPoint = new Point(point.x + dx[i], point.y + dy[i]);
                if (checkRange(board, newPoint.x, newPoint.y)
                        && !visited[newPoint.x][newPoint.y]
                        && board[newPoint.x][newPoint.y] == 'O') {
                    // 将入到队列中，并标记
                    queue.offer(newPoint);
                    visited[newPoint.x][newPoint.y] = true;
                    board[newPoint.x][newPoint.y] = 'B';
                }
            }
        }
    }

    private boolean isEdge(int x, int y, int m, int n) {
        return x == 0 || x == m - 1 || y == 0 || y == n - 1;
    }


    /**
     * 使用DFS方法解决
     */
    public void solveWithDfs(char[][] board) {
        if (board == null || board.length == 0
                || board[0] == null || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        // 将边界的O开发，将其连接节点都变成B
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 只对边界的O进行
                if (i == 0 || i == (m - 1)
                        || j == 0 || j == (n - 1)) {
                    if (board[i][j] == 'O' && !visited[i][j]) {
                        dfs(board, visited, i, j);
                    }
                }
            }
        }

        // 把剩下的O变为X，把B变成O
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else {
                    continue;
                }
            }
        }
    }


    private void dfs(char[][] board, boolean[][] visited, int x, int y) {

        // 标价访问
        visited[x][y] = true;
        board[x][y] = 'B';

        // 移动
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (checkRange(board, newX, newY)
                    && board[newX][newY] == 'O'
                    && !visited[newX][newY]) {
                dfs(board, visited, newX, newY);
            }
        }
    }


    private boolean checkRange(char[][] grid, int x, int y) {
        return x >= 0
                && x < grid.length
                && y >= 0
                && y < grid[0].length;
    }

}
