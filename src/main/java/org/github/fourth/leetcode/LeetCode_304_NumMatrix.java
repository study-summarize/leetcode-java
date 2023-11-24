package org.github.fourth.leetcode;

/**
 * 给定一个二维矩阵`matrix`，以下类型的多个请求：
 * (1)计算其子矩形范围内元素的总和，该子矩阵的左上角为(row1,col1)，右下角为(row2,col2)。
 * 实现NumMatrix类：
 * (2)NumMatrix(int[][] matrix)给定整数矩阵matrix进行初始化
 * (3)int sumRegion(int row1, int col1, int row2, int col2)返回左上角(row1,col1)、右下角(row2,col2)所描述的子矩阵的元素总和。
 */
public class LeetCode_304_NumMatrix {

    private final int[][] prefixSum;

    public LeetCode_304_NumMatrix(int[][] matrix) {
        prefixSum = new int[matrix.length + 1][matrix[0].length + 1];
        // 构建二维数组动态和
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                prefixSum[i + 1][j + 1] = prefixSum[i + 1][j] + prefixSum[i][j + 1] - prefixSum[i][j] + matrix[i][j];
            }
        }
    }
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefixSum[row2 + 1][col2 + 1] - prefixSum[row1][col2 + 1] - prefixSum[row2 + 1][col1] + prefixSum[row1][col1];
    }
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int sumRegionExample(int row1, int col1, int row2, int col2) {
        return sumRegion(row1, col1, row2, col2);
    }
}
