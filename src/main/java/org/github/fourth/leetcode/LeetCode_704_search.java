package org.github.fourth.leetcode;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class LeetCode_704_search {
    /**
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        // 防止出现 start == end的死循环
        while (start + 1 < end) {
            // 防止溢出
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                // 为了找出第一个符合和第二个符合的元素
                end = mid;
            }
        }

        // 第一个符合的元素
        if (nums[start] == target) {
            return start;
        }
        // 第二个符合的元素
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
