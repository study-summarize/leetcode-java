package org.github.fourth.leetcode;

public class LeetCode_136_singleNumber {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int result = 0;
        for (int num : nums) {
            result = num ^ result;
        }
        return result;
    }
}
