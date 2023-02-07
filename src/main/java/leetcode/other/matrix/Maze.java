package leetcode.other.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 */
public class Maze {
    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * 求最短路径长度
     */
    public static int getShortPathStep(int[][] maze, Point start, Point end) {
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) {
            return 0;
        }

        // 判断start位置是否符合要求
        if (!checkRange(maze, start)
                || maze[start.x][start.y] == 1) {
            return -1;
        }

        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int step = Integer.MAX_VALUE;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.x][start.y] = true;

        int level = 0;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                Point curPoint = queue.poll();
                if (curPoint.x == end.x && curPoint.y == end.y) {
                    step = Math.min(step, level);
                    continue;
                }
                for (int pos = 0; pos < 4; pos++) {
                    int newX = curPoint.x + dx[pos];
                    int newY = curPoint.y + dy[pos];
                    Point newPoint = new Point(newX, newY);
                    if (checkRange(maze, newPoint)
                            && !visited[newX][newY]
                            && maze[newX][newY] != 1) {
                        queue.offer(newPoint);
                        visited[newX][newY] = true;
                    }
                }
            }
        }
        return step == Integer.MAX_VALUE ? -1 : step;
    }

    /**
     * 有一个迷宫，由黑色方块（用1代表）与白色方块（用0代表）组成，黑色方块代表障碍物，白色代表可以通过区域，
     * 请找到所有可以从起点S走到终点E的道路，返回路径信息。移动方向只能上下左右
     */
    public static List<List<Point>> solveMaze(int[][] maze, Point start, Point end) {
        List<List<Point>> result = new ArrayList<>();
        if (maze == null || maze.length == 0 || maze[0] == null || maze[0].length == 0) {
            return result;
        }
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        List<Point> path = new ArrayList<>();
        path.add(start);

        dfs(result, path, maze, visited, start, end);
        return result;
    }

    private static void dfs(List<List<Point>> result, List<Point> path, int[][] maze, boolean[][] visited, Point cur, Point end) {
        // 剪枝：当前是黑块
        if (maze[cur.x][cur.y] == 1) {
            return;
        }
        // 标记访问
        visited[cur.x][cur.y] = true;

        // 递归什么时候退出：找到单一解集
        if (cur.x == end.x && cur.y == end.y) {
            result.add(new ArrayList<>(path));
            // 取消标记
            visited[cur.x][cur.y] = false;
            return;
        }

        // 移动
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            Point newPoint = new Point(cur.x + dx[i], cur.y + dy[i]);
            if (checkRange(maze, newPoint) && !visited[newPoint.x][newPoint.y]) {
                path.add(newPoint);
                dfs(result, path, maze, visited, newPoint, end);
                // 回溯：
                path.remove(path.size() - 1);
            }
        }

        // 取消标记
        visited[cur.x][cur.y] = false;
    }

    private static boolean checkRange(int[][] maze, Point point) {
        return point.x >= 0
                && point.x < maze.length
                && point.y >= 0
                && point.y < maze[0].length;

    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 0, 0},
                {0, 1, 0, 1},
                {0, 1, 0, 0},
                {0, 0, 1, 0}};
        List<List<Point>> results = solveMaze(maze, new Point(0, 0), new Point(3, 3));

        for (List<Point> result : results) {
            System.out.println("The solution is following: ");
            result.forEach(point -> {
                System.out.println("The cur node: (" + point.x + "," + point.y + ")");
            });
        }
        // 7
        System.out.println(getShortPathStep(maze, new Point(0, 0), new Point(3, 3)));

        System.out.println("======");
        // =====
        int[][] maze2 = {
                {0, 0, 0, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0}};
        List<List<Point>> results2 = solveMaze(maze2, new Point(0, 0), new Point(4, 4));

        for (List<Point> result : results2) {
            System.out.println("The solution is following: ");
            result.forEach(point -> {
                System.out.println("The cur node: (" + point.x + "," + point.y + ")");
            });
        }
        // 8
        System.out.println(getShortPathStep(maze2, new Point(0, 0), new Point(4, 3)));
    }

}
