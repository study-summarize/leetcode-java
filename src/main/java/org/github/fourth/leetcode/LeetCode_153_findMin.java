package org.github.fourth.leetcode;

/**
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * - 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * - 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
public class LeetCode_153_findMin {
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
            // 此时没有扭转，处于有序性中
            if (nums[start] < nums[end]) {
                return nums[start];
            }

            // 此时有扭转，不断的往中间最低点靠近
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[start]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        // 可能出现临近情况：start、end都没法确定最靠近的低值
        return Math.min(nums[start], nums[end]);
    }
}
