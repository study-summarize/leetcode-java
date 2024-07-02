package org.github.fourth.leetcode;

import org.github.fourth.Top100;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
@Top100
public class LeetCode_128_longestConsecutive {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> sets = new HashSet<>();
        for (int num : nums) {
            sets.add(num);
        }

        int result = 1;
        for (int num : sets) {
            if (!sets.contains(num -1)) {
                int subLen = 1;
                while(sets.contains(++num)) {
                    subLen++;
                }
                result = Math.max(result, subLen);
            }
        }
        return result;
    }
}
