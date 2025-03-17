package org.github.fourth.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_442_findDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();

        // 将nums[i] 放到对应 nums[i - 1]的位置上，如果有重复就放到其他位置
        for (int i = 0; i < nums.length; i++) {
            // nums[i] 应该放到nums[nums[i] - 1]里
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // 看哪个下标不对
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(nums[i]);
            }
        }

        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
