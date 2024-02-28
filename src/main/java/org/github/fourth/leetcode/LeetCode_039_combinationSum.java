package org.github.fourth.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class LeetCode_039_combinationSum {
    /**
     * 回溯法
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<List<Integer>> combinationSum01(int[] candidates, int target) {
        // 解集
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null) {
            return result;
        }

        Arrays.sort(candidates);
        // 单一解集
        List<Integer> list = new ArrayList<>();
        // 递归函数解集问题
        // note: 为什么需要pos?
        // 需要过滤一些重复的元素，例如前面算过了，后面没必要再把这个元素再算一遍
        helper(result, list, candidates, target, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int pos) {
        // 1. 递归什么时候退出？target 小于 0时
        if (target < 0) {
            return;
        }
        // 2. 单一解集什么时候加入解集
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        // 3. 递归拆分问题
        for (int i = pos; i < candidates.length; i++) {
            // 3.1 扩展单一子集
            list.add(candidates[i]);
            // 3.2 递归求解问题
            helper(result, list, candidates, target - candidates[i], i);
            // 3.3 回溯
            list.remove(list.size() - 1);
        }
    }
}
