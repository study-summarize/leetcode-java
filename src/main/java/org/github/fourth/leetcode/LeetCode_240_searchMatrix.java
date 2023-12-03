package org.github.fourth.leetcode;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * - 每行的元素从左到右升序排列。
 * - 每列的元素从上到下升序排列。
 */
public class LeetCode_240_searchMatrix {

    /**
     * 时间复杂度：O(log(m*n))
     * 空间复杂度：O(1)
     */
    public boolean searchMatrix02(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        // 从右上角开始。向下递增，向左递减
        int m = matrix.length;
        int n = matrix[0].length;
        int x = 0;
        int y = n - 1;

        // note: 注意=0的边界条件
        while (x < m && y >= 0) {
            int current = matrix[x][y];
            if (current == target) {
                return true;
            }
            else if (current > target) {
                y--;
            }
            else {
                x++;
            }
        }

        return false;
    }

    /**
     * N个二分查找 + 转化
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     */
    public boolean searchMatrix01(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            int start = 0;
            int end = matrix[i].length - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (matrix[i][mid] > target) {
                    end = mid;
                } else if (matrix[i][mid] < target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if (matrix[i][start] == target) {
                return true;
            }
            if (matrix[i][end] == target) {
                return true;
            }
        }
        return false;
    }
    /**
     * 暴力解法：双层for循环
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(1)
     */
    public boolean searchMatrix00(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (target == matrix[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
