package org.github.fourth.leetcode;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class LeetCode_079_exist {

    /**
     * 二维DFS
     */
    public boolean exist01(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.isEmpty()) {
            return false;
        }
        // 单次路径时的访问标记数组
        boolean[][] visited = new boolean[board.length][board[0].length];
        // 依次遍历二维矩阵的所有点
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean result = dfs(board, visited, i, j, word, 0);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int currX, int currY, String word, int pos) {
        // 递归什么时候结束？ pos == word的长度
        if (pos == word.length()) {
            return true;
        }
        // 减枝？当前节点不满足word的当前位置
        if (board[currX][currY] != word.charAt(pos)) {
            return false;
        }
        // 节点置为已访问
        visited[currX][currY] = true;
        // 构建访问顺序
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        // 按照可能的顺序依次遍历
        boolean hasPath = false;
        for (int i = 0; i < 4; i++) {
            int newX = currX + dx[i];
            int newY = currY + dy[i];
            // 判断有没有越界
            if (!checkRange(newX, newY, board) || visited[newX][newY]) {
                continue;
            }
            hasPath = hasPath || dfs(board, visited, newX, newY, word, pos + 1);
        }
        // 当前节点的访问标记去除
        visited[currX][currY] = false;
        return hasPath;
    }

    private boolean checkRange(int newX, int newY, char[][] board) {
        return newX >= 0 && newX < board.length
                && newY >= 0 && newY < board[0].length;
    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public boolean existExample(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean result = dfsExample(board, word, 0, visited, i, j);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsExample(char[][] board, String word, int index, boolean[][] visited, int curX, int curY) {
        // 减枝
        if (!checkRangeExample(board, curX, curY)
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
            result = result || dfsExample(board, word, index + 1, visited, curX + dx[i], curY + dy[i]);
        }
        // note: 要理解这里为啥要置回去。因为起点位置是不一样的
        visited[curX][curY] = false;
        return result;
    }

    private boolean checkRangeExample(char[][] board, int curX, int curY) {
        return curX >= 0
                && curX < board.length
                && curY >= 0
                && curY < board[0].length;
    }

}
