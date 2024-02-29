package org.github.fourth.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 */
public class LeetCode_219_containsNearbyDuplicate {

    /**
     *
     */
    public boolean containsNearbyDuplicate01(int[] nums, int k) {
        return false;
    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public boolean containsNearbyDuplicateExample(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int num = nums[index];
            if (map.containsKey(num)) {
                Integer originIndex = map.get(num);
                if (index - originIndex <= k) {
                    return true;
                } else {
                    map.put(num, index);
                }
            } else {
                map.put(num, index);

            }
        }
        return false;
    }
}
