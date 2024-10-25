package org.github.fourth.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 思路：
 * 先横向计算每个点连续之和，然后再纵向计算每个点向上、向下第一个变小的下标。就可以得出每块矩形的面积
 */
public class LeetCode_085_maximalRectangle {
    /**
     *
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0
                || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        // 先行向累加一下，转换成数字数组方便处理
        int[][] nums = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    nums[i][j] = (j == 0 ? 1 : nums[i][j - 1] + 1);
                }
            }
        }

        int result = Integer.MIN_VALUE;
        // 然后纵向求当前元素向上、向下的第一个比当前元素小的下标
        for (int i = 0; i < nums[0].length; i++) {
            // 求nums[][i]元素向下第一个变小的下标
            Deque<Integer> downMaxStack = new ArrayDeque<>();
            int[] down = new int[nums.length];
            // 填充初始值防止万一
            Arrays.fill(down, nums.length);
            for (int j = 0; j < nums.length; j++) {
                while (!downMaxStack.isEmpty() && nums[j][i] < nums[downMaxStack.peek()][i]) {
                    int index = downMaxStack.pop();
                    down[index] = j;
                }
                downMaxStack.push(j);
            }

            // 求nums[][i]元素向上第一个变下的下标
            Deque<Integer> upMaxStack = new ArrayDeque<>();
            int[] up = new int[nums.length];
            // 填充初始值防止万一
            Arrays.fill(up, -1);
            for (int j = nums.length - 1; j >= 0; j--) {
                while (!upMaxStack.isEmpty() && nums[j][i] < nums[upMaxStack.peek()][i]) {
                    int index = upMaxStack.pop();
                    up[index] = j;
                }
                upMaxStack.push(j);
            }

            // 求结果
            for (int j = 0; j < nums.length; j++) {
                int range = down[j] - up[j] - 1 > 0 ? down[j] - up[j] - 1 : nums.length;
                result = Math.max(result, range * nums[j][i]);
            }
        }
        return result;
    }
}
