package org.github.fourth.leetcode;

/**
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 * - 每行中的整数从左到右按非严格递增顺序排列。
 * - 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 */
public class LeetCode_074_searchMatrix {

    /**
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int start = 0;
        int end = matrix.length * matrix[0].length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int x = mid / matrix[0].length;
            int y = mid % matrix[0].length;
            if (matrix[x][y] > target) {
                end = mid;
            } else if (matrix[x][y] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (matrix[start / matrix[0].length][start % matrix[0].length] == target) {
            return true;
        }
        if (matrix[end / matrix[0].length][end % matrix[0].length] == target) {
            return true;
        }
        return false;
    }
}
