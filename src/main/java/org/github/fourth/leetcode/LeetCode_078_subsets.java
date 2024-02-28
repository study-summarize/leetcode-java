package org.github.fourth.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class LeetCode_078_subsets {
    /**
     * 回溯法
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<List<Integer>> subsets01(int[] nums) {
        // 解集
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        // 单一解
        List<Integer> list = new ArrayList<>();

        helper(result, list, nums, 0);

        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int pos) {
        // 1. 递归什么时候退出？pos超过num时
        // 2. 单一解集什么时候加入解集中？
        result.add(new ArrayList<>(list));
        if (pos >= nums.length) {
            return;
        }

        // 3.递归拆分子问题
        for (int i = pos; i < nums.length; i++) {
            // 3.1 计算当前的单一解集
            list.add(nums[i]);
            // 3.2 递归计算以nums[i] 开始的子集问题
            helper(result, list, nums, i + 1);
            // 3.3 回溯时去掉最后一位
            list.remove(list.size() - 1);
        }
    }
}
