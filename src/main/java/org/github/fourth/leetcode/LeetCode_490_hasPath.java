package org.github.fourth.leetcode;

/**
 * 由空地（用 0 表示）和墙（用 1 表示）组成的迷宫 maze 中有一个球。球可以途经空地向 上、下、左、右 四个方向滚动，且在遇到墙壁前不会停止滚动。当球停下时，可以选择向下一个方向滚动。
 * 给你一个大小为 m x n 的迷宫 maze ，以及球的初始位置 start 和目的地 destination ，其中 start = [startrow, startcol] 且 destination = [destinationrow, destinationcol] 。请你判断球能否在目的地停下：如果可以，返回 true ；否则，返回 false 。
 * 你可以 假定迷宫的边缘都是墙壁（参考示例）。
 */
public class LeetCode_490_hasPath {

    /**
     * 二维DFS
     */
    public boolean hasPath01(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0
                || start == null || start.length == 0
                || destination == null || destination.length == 0) {
            return false;
        }
        int m = maze.length;
        int n = maze[0].length;
        // 记录一次有效的尝试时，节点的访问情况
        boolean[][] visited = new boolean[m][n];
        // 1. 有固定的起点，所以不需要遍历整个二维数组
        return dfs(maze, start, destination, visited);
    }

    private boolean dfs(int[][] maze, int[] position, int[] destination, boolean[][] visited) {
        // 递归什么时候结束？
        if (position[0] == destination[0] && position[1] == destination[1]) {
            return true;
        }

        // 减枝 ==> 异常情况: 撞墙了
        if (maze[position[0]][position[1]] == 1) {
            return false;
        }


        visited[position[0]][position[1]] = true;
        // 移动
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean hasPath = false;
        for (int i = 0; i < 4; i++) {
            int newX = position[0] + dx[i];
            int newY = position[1] + dy[i];
            // 不撞到墙，停不下来
            while (checkRangeExample(maze, newX, newY) && maze[newX][newY] != 1) {
                newX = newX + dx[i];
                newY = newY + dy[i];
            }
            // while结束时，已经在墙上了
            newX -= dx[i];
            newY -= dy[i];

            if (checkRangeExample(maze, newX, newY) && !visited[newX][newY]) {
                hasPath = hasPath || dfs(maze, new int[]{newX, newY}, destination, visited);
            }
        }
        // note: 在只需要有没有解的时候，其实是不需要置回的
        visited[position[0]][position[1]] = false;
        return hasPath;
    }

    int[] dxExample = {1, 0, -1, 0};
    int[] dyExample = {0, 1, 0, -1};

    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public boolean hasPathExample(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0
                || maze[0] == null || maze[0].length == 0) {
            return false;
        }
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];

        return dfsExample(maze, visited, start[0], start[1], destination[0], destination[1]);
    }

    private boolean dfsExample(int[][] maze, boolean[][] visited,
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
            int newX = x + dxExample[i];
            int newY = y + dyExample[i];
            while (checkRangeExample(maze, newX, newY) && maze[newX][newY] != 1) {
                newX = newX + dxExample[i];
                newY = newY + dyExample[i];
            }
            // while结束时，已经在墙上了
            newX -= dxExample[i];
            newY -= dyExample[i];

            if (checkRangeExample(maze, newX, newY) && !visited[newX][newY]) {
                hasPath = hasPath || dfsExample(maze, visited, newX, newY, destinationX, destinationY);
            }
        }
        // note: 在只需要有没有解的时候，其实是不需要置回的
        visited[x][y] = false;
        return hasPath;
    }

    private boolean checkRangeExample(int[][] maze, int x, int y) {
        return x >= 0
                && x < maze.length
                && y >= 0
                && y < maze[0].length;
    }


}
