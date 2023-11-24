package org.github.fourth.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class LeetCode_001_twoSum {

    /**
     * 暴力解法1：双层for循环
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public int[] twoSum01(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[2];
        }

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * 排序+双指针，求具体值，而不是下标
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     */
    public int[] twoSum02(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        // 排序：O(nlogn)
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;

        // 类似二分法的写法；O(n)
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                return new int[]{nums[start], nums[end]};
            }
            if (nums[start] + nums[end] > target) {
                end--;
            }
            if (nums[start] + nums[end] < target) {
                start++;
            }
        }
        return null;
    }

    /**
     * 哈希表
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int[] twoSum03(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[2];
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            int targetValue = target - nums[index];
            if (map.containsKey(targetValue)) {
                return new int[]{map.get(targetValue), index};
            }
            map.put(nums[index], index);
        }
        return new int[2];
    }
}
