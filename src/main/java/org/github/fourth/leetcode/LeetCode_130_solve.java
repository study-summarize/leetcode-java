package org.github.fourth.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
public class LeetCode_130_solve {

    /**
     * 二维DFS
     */
    public void solve01(char[][] board) {
        if (board == null || board[0] == null || board[0].length == 0) {
            return;
        }
        // 以边界的O为起点，将其连接的O全部变成B
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!visited[i][j] && board[i][j] == 'O'
                        && (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1)) {
                    dfs(board, visited, i, j);
                }
            }
        }
        // 遍历矩阵，将剩余的O变成X，将B变成O
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'B') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] visited, int currX, int currY) {
        // 递归什么时候结束？
        // 减枝结束？
        if (!checkRangeExample(board, currX, currY) || visited[currX][currY] || board[currX][currY] == 'X') {
            return;
        }
        visited[currX][currY] = true;
        board[currX][currY] = 'B';

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int newX = currX + dx[i];
            int newY = currY + dy[i];
            if (!checkRangeExample(board, newX, newY) || visited[newX][newY] || board[newX][newY] != 'O') {
                continue;
            }
            dfs(board, visited, newX, newY);
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
     * 时间复杂度：
     * 空间复杂度：
     */
    public void solveExample01(char[][] board) {
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
                    bfsExample(board, visited, new Point(i, j));
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

    private void bfsExample(char[][] board, boolean[][] visited, Point startNode) {
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
                Point newPoint = new Point(point.x + dxExample[i], point.y + dyExample[i]);
                if (checkRangeExample(board, newPoint.x, newPoint.y)
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

    int[] dxExample = {1, 0, -1, 0};
    int[] dyExample = {0, 1, 0, -1};

    /**
     * 使用DFS方法解决
     */
    public void solveWithDfsExample02(char[][] board) {
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
                        dfsExample(board, visited, i, j);
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


    private void dfsExample(char[][] board, boolean[][] visited, int x, int y) {

        // 标价访问
        visited[x][y] = true;
        board[x][y] = 'B';

        // 移动
        for (int i = 0; i < 4; i++) {
            int newX = x + dxExample[i];
            int newY = y + dyExample[i];
            if (checkRangeExample(board, newX, newY)
                    && board[newX][newY] == 'O'
                    && !visited[newX][newY]) {
                dfsExample(board, visited, newX, newY);
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
