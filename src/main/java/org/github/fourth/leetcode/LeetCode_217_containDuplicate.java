package org.github.fourth.leetcode;

import java.util.*;

/**
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 */
public class LeetCode_217_containDuplicate {

    /**
     *
     */
    public boolean containsDuplicate01(int[] nums) {
        return false;
    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public boolean containsDuplicateExample(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
