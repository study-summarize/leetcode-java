package org.github.fourth.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 迷宫中有一个球，它有空地 (表示为 0) 和墙 (表示为 1)。球可以向上、向下、向左或向右滚过空地，但直到撞上墙之前它都不会停止滚动。当球停止时，它才可以选择下一个滚动方向。
 * 给定 m × n 的迷宫(maze)，球的起始位置 (start = [startrow, startcol]) 和目的地 (destination = [destinationrow, destinationcol])，返回球在目的地 (destination) 停止的最短距离。如果球不能在目的地 (destination) 停止，返回 -1。
 * 距离是指球从起始位置 ( 不包括 ) 到终点 ( 包括 ) 所经过的空地数。
 * 你可以假设迷宫的边界都是墙 ( 见例子 )。
 */
public class LeetCode_505_shortestDistance {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) {
            return -1;
        }

        int m = maze.length;
        int n = maze[0].length;
        // 记忆化搜索：记录start到该点（x,y）的最小步数
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            // 填充最大值：以防止出现不可到达点
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        memo[start[0]][start[1]] = 0;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = point[0] + dx[i];
                int newY = point[1] + dy[i];
                int steps = 0;
                while (checkRange(maze, newX, newY)
                        && maze[newX][newY] == 0) {
                    newX += dx[i];
                    newY += dy[i];
                    steps++;
                }
                // 球在墙上
                newX = newX - dx[i];
                newY = newY - dy[i];
                // 何时入队
                if (memo[start[0]][start[1]] + steps < memo[newX][newY]) {
                    memo[newX][newY] = memo[start[0]][start[1]] + steps;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return memo[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : memo[destination[0]][destination[1]];
    }

    private boolean checkRange(int[][] maze, int x, int y) {
        return x >= 0
                && x < maze.length
                && y >= 0
                && y < maze[0].length;
    }

}
