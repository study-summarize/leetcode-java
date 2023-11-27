package org.github.fourth.struct.binarySearch;

/**
 * 二分搜索模板
 */
public class BinarySearchDemo {

    /**
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     */
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        // 为啥不用start<=end？这里是为了防止出现start == end的情况
        while (start + 1 < end) {
            // 防止溢出
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                end = mid;
            }
            else if (target > nums[mid]) {
                start = mid;
            }
            else {
                // 为了后续算出第一个、第二个符合target的值
                end = mid;
            }
        }

        // 第一个符合
        if (nums[start] == target) {
            return start;
        }
        // 第二个符合
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
