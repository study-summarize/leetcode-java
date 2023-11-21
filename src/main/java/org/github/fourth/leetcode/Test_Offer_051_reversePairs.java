package org.github.fourth.leetcode;

/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给定一个二叉树的根节点 root ，返回其 最大路径和，即所有路径上节点值之和的最大值。
 */
public class Test_Offer_051_reversePairs {

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return countPairs(nums, 0, nums.length - 1);
    }

    private int countPairs(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;

            int leftCount = countPairs(nums, start, mid);
            int rightCount = countPairs(nums, mid + 1, end);
            return leftCount + rightCount + merge(nums, start, mid, end);
        }
        return 0;
    }

    /**
     * 求左右子数组在合并时产生逆序队的个数
     */
    private int merge(int[] nums, int start, int mid, int end) {
        int leftLength = mid - start + 1;
        int rightLength = end - mid;

        int[] left = new int[leftLength];
        int[] right = new int[rightLength];

        for (int i = 0; i < leftLength; i++) {
            left[i] = nums[start + i];
        }

        for (int j = 0; j < rightLength; j++) {
            right[j] = nums[mid + 1 + j];
        }

        int index = start;
        int i = 0;
        int j = 0;
        int pairCount = 0;
        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                nums[index++] = left[i++];
            } else {
                // 产生逆序对：count = leftLength - i
                nums[index++] = right[j++];
                pairCount += (leftLength - i);
            }
        }

        while (i < leftLength) {
            nums[index++] = left[i++];
        }

        while (j < rightLength) {
            nums[index++] = right[j++];
        }

        return pairCount;
    }

}
