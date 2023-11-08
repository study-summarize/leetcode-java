package org.github.fourth;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Origin:
 * 给你一个整数数组nums，将nums中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。返回满足此条件的任一数组作为答案。
 */
public class SortArrayByParity {

    /**
     * 相向型双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    @SuppressFBWarnings("IM_BAD_CHECK_FOR_ODD")
    public int[] sortArrayByParity(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] % 2 == 0) {
                start++;
            } else if (nums[start] % 2 != 0) {
                swap(nums, start, end);
                end--;
            }
        }
        return nums;
    }

    /**
     * 模板代码
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    @SuppressFBWarnings("IM_BAD_CHECK_FOR_ODD")
    public int[] sortArrayByParityExample(int[] nums) {
        if (nums == null || nums.length < 1) {
            return nums;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            while (start < end && nums[start] % 2 == 0) {
                start++;
            }
            while (start < end && nums[end] % 2 == 1) {
                end--;
            }

            if (start < end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }

        return nums;
    }

    private static void swap(int[] nums, int a, int b) {
        if (nums == null || a >= nums.length || b >= nums.length) {
            return;
        }
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
