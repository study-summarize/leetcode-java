package org.github.fourth.leetcode;

/**
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * 你需要返回给定数组中的重要翻转对的数量。
 */
public class LeetCode_493_reversePairs {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
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
     * 求左右子数组在合并时产生重要翻转对的个数
     */
    private int merge(int[] nums, int start, int mid, int end) {
        int pairCount = 0;
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

        int i = start;
        int j = mid + 1;
        // start - mid有序；mid + 1 ～ end有序
        // 统计start～end区间重要翻转对的个数
        while (i <= mid && j <= end) {
            if (nums[i] > 2 * (long) nums[j]) {
                pairCount += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }

        int index = start;
        i = 0;
        j = 0;
        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                nums[index++] = left[i++];
            } else {
                nums[index++] = right[j++];
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
