package leetcode;

/**
 * @author jwang55
 */
public class Test_130_solve {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public void solve(char[][] board) {
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
        for (int i = 0; i < 4 ; i++) {
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
