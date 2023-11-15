package org.github.fourth.leetcode;

/**
 * 给你一个正整数数组`arr`，请你计算所有可能的奇数长度子数组的和。
 * **子数组**定义为原数组中的一个连续子序列。
 * 请你返回`arr`中**所有奇数长度子数组的和**。
 */
public class LeetCode_1588_sumOddLengthSubarrays {


    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     * note：一维数组前缀和
     */
    public int sumOddLengthSubarrays(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // 一维数组动态和模板
        int[] prefixSum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        // 开始求和
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if ((j - i) % 2 != 0) {
                    continue;
                }
                sum = sum + prefixSum[j + 1] - prefixSum[i];
            }
        }
        return sum;
    }

    /**
     * 暴力方法：三层for循环。俩层确定奇子数组，一层来计算这个子数组的和
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(1)
     */
    public int sumOddLengthSubarrays02(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int len = 1; i + len <= arr.length; len += 2) {
                for (int j = i; j < i + len; j++) {
                    sum = sum + arr[j];
                }
            }
        }
        return sum;
    }

    public int sumOddLengthSubarraysExample(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int[] prefixSum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int len = 1; i + len <= arr.length; len += 2) {
                result = result + (prefixSum[i + len] - prefixSum[i]);
            }
        }
        return result;
    }
}
