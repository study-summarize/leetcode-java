package org.github.fourth.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class LeetCode_090_subsetsWithDup {
    /**
     * 回溯法
     * 时间复杂度：
     * 空间复杂度：
     * note：利用排序来解决重复子集的去除
     */
    public List<List<Integer>> subsetsWithDup01(int[] nums) {
        // 解集
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        // 利用排序解决重复子集问题
        Arrays.sort(nums);

        // 单一解集
        List<Integer> list = new ArrayList<>();

        // 递归拆分问题求解
        helper(result, list, nums, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int pos) {
        // 1. 递归什么时候结束？pos达到list长度时
        // 2. 单一解集什么时候加入解集？当前单一解集不在当前元素时
        result.add(new ArrayList<>(list));
        if (pos >= nums.length) {
            return;
        }

        // 3. 递归拆分子问题
        for (int i = pos; i < nums.length; i++) {
            // 去除重复元素。为什么用 i!=pos ？因为这里是横向去除重复元素，如果用i>0判断，会把纵向相等的也给计算进去
            // 比如：1 -> 2 -> 2，第3个2就加不进去
            if (i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            // 3.1 扩展当前解集
            list.add(nums[i]);
            // 3.2 递归求解问题
            helper(result, list, nums, i + 1);
            // 3.3 回溯
            list.remove(list.size() - 1);
        }
    }
}
