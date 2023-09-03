package struct.matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jwang55
 */
public class Matrix {

    public void bfdInMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; i < n; j++) {
                Point start = new Point(i, j);
                if (specialCondition && !visited[i][j]) {
                    bfs(matrix, visited, start);
                }
            }
        }
    }

    private void bfs(int[][] matrix, boolean[][] visited, Point point) {
        Queue<Point> queue = new LinkedList<>();

        // 标记并加入队列
        queue.offer(point);
        visited[point.x][point.y] = true;

        // BFS 移动
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            Point curPoint = queue.poll();
            for (int i = 0; i < 4; i++) {
                Point newPoint = new Point(curPoint.x + dx[i], curPoint.y + dy[i]);
                if (checkRange(matrix, newPoint)
                        && !visited[newPoint.x][newPoint.y]
                        && specialCondition) {
                    visited[newPoint.x][newPoint.y] = true;
                    queue.offer(newPoint);
                }
            }
        }
    }

    private boolean checkRange(int[][] matrix, Point point) {
        return point.x >= 0
                && point.x <= matrix.length
                && point.y >= 0
                && point.y <= matrix[0].length;
    }


    // note
    boolean specialCondition = true;
}

class Point {
    int x;
    int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
