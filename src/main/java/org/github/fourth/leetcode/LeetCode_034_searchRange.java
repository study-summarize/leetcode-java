package org.github.fourth.leetcode;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 */
public class LeetCode_034_searchRange {
    /**
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     * note: 理解找到target元素时，用start、end接收的含义
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] result = new int[]{-1, -1};

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

        if (nums[start] == target && nums[end] == target) {
            // 有俩个存在
            result[0] = start;
        } else if (nums[start] == target || nums[end] == target) {
            // 只有一个存在
            result[0] = nums[start] == target ? start : end;
        } else {
            return result;
        }

        // 找出倒数第一个
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] == target && nums[end] == target) {
            // 有俩个存在
            result[1] = end;
        } else if (nums[start] == target || nums[end] == target) {
            // 只有一个存在
            result[1] = nums[start] == target ? start : end;
        }
        return result;
    }
}
