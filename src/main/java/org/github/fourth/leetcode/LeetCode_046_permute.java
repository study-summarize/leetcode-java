package org.github.fourth.leetcode;

import java.util.*;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class LeetCode_046_permute {
    /**
     * 回溯法
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<List<Integer>> permute01(int[] nums) {
        // 解集
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        // 单一解集
        List<Integer> list = new ArrayList<>();

        // 递归拆分问题
        helper(result, list, nums);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums) {
        // 1. 递归什么时候结束？pos 达到nums长度时;或者list的长度为3时
        // 2. 单一解集什么时候加入解集中？list长度为3时
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        // 3. 拆分问题
        for (int i = 0; i < nums.length; i++) {
            // 3.1 扩展单一解集
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            // 3.2 递归解集
            helper(result, list, nums);
            // 3.3 回溯法
            list.remove(list.size() - 1);
        }
    }
}
