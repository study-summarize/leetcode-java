package org.github.fourth.leetcode;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 */
public class LeetCode_033_search {
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
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // 整段有序，转换成二分搜索模板题目
            if (nums[start] < nums[end]) {
                if (nums[mid] > target) {
                    end = mid;
                } else if (nums[mid] < target) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                if (nums[mid] < nums[start]) {
                    // mid 位于第2段
                    if (nums[mid] > target) {
                        // target 只可能存在与第二段的前一段
                        end = mid;
                    } else {
                        // target可能在第一段或者第二段的后一段
                        if (nums[end] < target) {
                            // target在前一段
                            end = mid;
                        } else {
                            start = mid;
                        }
                    }
                } else {
                    // mid 位于第1段
                    if (nums[mid] < target) {
                        // target 只可能在第一段的第二段部分
                        start = mid;
                    } else {
                        // target 可能在第一段的第一段部分；也有可能在第二段
                        if (nums[start] > target) {
                            // 在第二段
                            start = mid;
                        } else {
                            // 在第一段第一部分
                            end = mid;
                        }
                    }
                }
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
