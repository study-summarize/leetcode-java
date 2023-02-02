package leetcode;

/**
 * @author jwang55
 */
public class Test_200_numIslands {


    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    public int numIslands(char[][] grid) {
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
                    dfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int x, int y) {

        // 标价访问
        visited[x][y] = true;

        // 移动
        for (int i = 0; i < 4 ; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (checkRange(grid, newX, newY)
                    && grid[newX][newY] == '1'
                    && !visited[newX][newY]) {
                dfs(grid, visited, newX, newY);
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
