package org.github.fourth.leetcode;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class LeetCode_079_exist {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean result = dfs(board, word, 0, visited, i, j);
                if (result) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int index, boolean[][] visited, int curX, int curY) {
        // 减枝
        if (!checkRange(board, curX, curY)
                || board[curX][curY] != word.charAt(index)
                || visited[curX][curY]) {
            return false;
        }

        // 递归何时退出
        if (index == word.length() - 1) {
            return true;
        }

        // 标记
        visited[curX][curY] = true;

        // 移动
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean result = false;
        for (int i = 0; i < 4; i++) {
            result = result || dfs(board, word, index + 1, visited, curX + dx[i], curY + dy[i]);
        }
        // note: 要理解这里为啥要置回去。因为起点位置是不一样的
        visited[curX][curY] = false;
        return result;
    }

    private boolean checkRange(char[][] board, int curX, int curY) {
        return curX >= 0
                && curX < board.length
                && curY >= 0
                && curY < board[0].length;
    }

}
