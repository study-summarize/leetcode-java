package org.github.fourth.leetcode;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 */
public class LeetCode_035_searchInsert {
    /**
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        // 找不到元素时，target可能在的三个位置
        if (target < nums[start]) {
            return start == 0 ? 0 : --start;
        }
        if (target > nums[start] && target < nums[end]) {
            return ++start;
        }
        return ++end;
    }
}
