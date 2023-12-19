package org.github.fourth.leetcode;

import java.util.Arrays;

/**
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 */
public class LeetCode_611_triangleNumber {
    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int result = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            int start = 0;
            int end = i - 1;
            while (start < end) {
                if (nums[start] + nums[end] > nums[i]) {
                    result = result + (end - start);
                    // 此时只是end、i固定后，start~end之间的数值是符合的
                    end--;
                } else {
                    start++;
                }
            }
        }
        return result;
    }

    public int triangleNumberExample(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);
        int count = 0;
        // 第三边：从后往前取。因为如果顺序去取的话，会缺少可能性。比如：2,2,3,4
        // 先2,2,4不符 => 2,2,3 第一次遍历结束。但其实还可以是2,3,4
        for (int i = nums.length - 1; i >= 2; i--) {
            int start = 0;
            int end = i - 1;
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum > nums[i]) {
                    count += (end - start);
                    end--;
                } else {
                    start++;
                }
            }
        }
        return count;
    }
}
