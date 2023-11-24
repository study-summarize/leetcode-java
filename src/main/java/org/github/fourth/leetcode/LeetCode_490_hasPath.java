package org.github.fourth.leetcode;

/**
 */
public class LeetCode_490_hasPath {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0
                || maze[0] == null || maze[0].length == 0) {
            return false;
        }
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];

        return dfs(maze, visited, start[0], start[1], destination[0], destination[1]);
    }

    private boolean dfs(int[][] maze, boolean[][] visited,
                        int x, int y, int destinationX, int destinationY) {
        // 剪枝：
        if (maze[x][y] == 1) {
            return false;
        }

        // 递归何时结束
        if (x == destinationX && y == destinationY) {
            return true;
        }

        visited[x][y] = true;
        // 移动
        boolean hasPath = false;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            while (checkRange(maze, newX, newY) && maze[newX][newY] != 1) {
                newX = newX + dx[i];
                newY = newY + dy[i];
            }
            // while结束时，已经在墙上了
            newX -= dx[i];
            newY -= dy[i];

            if (checkRange(maze, newX, newY) && !visited[newX][newY]) {
                hasPath = hasPath || dfs(maze, visited, newX, newY, destinationX, destinationY);
            }
        }
        // note: 在只需要有没有解的时候，其实是不需要置回的
        // visited[x][y] = false;
        return hasPath;
    }

    private boolean checkRange(int[][] maze, int x, int y) {
        return x >= 0
                && x < maze.length
                && y >= 0
                && y < maze[0].length;
    }


}
