package org.github.fourth.leetcode;

/**
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * - 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * - 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * 你必须尽可能减少整个过程的操作步骤。
 */
public class LeetCode_154_findMin {
    /**
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            // 此时数组是一段有序性
            if (nums[start] < nums[end]) {
                return nums[start];
            }

            // 此时数组一定是俩段有序性
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[start]) {
                // mid落在第二段中
                end = mid;
            } else if (nums[mid] > nums[start]) {
                // mid落在第一段中
                start = mid;
            } else {
                // mid可能在第一段中，也有可能在第二段中
                start++;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}
