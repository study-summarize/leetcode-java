package org.github.fourth.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 注意：解集不能包含重复的组合。
 */
public class LeetCode_040_combinationSum2 {
    /**
     * 回溯法
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<List<Integer>> combinationSum201(int[] candidates, int target) {
        // 解集
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null) {
            return result;
        }

        Arrays.sort(candidates);
        // 单一解集
        List<Integer> list = new ArrayList<>();

        // 递归解决问题
        helper(result, list, candidates, target, 0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int pos) {
        // 1. 递归什么时候结束？target小于0
        if (target < 0) {
            return;
        }
        // 2. 单一解集什么时候加入解集？target为0
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        // 3. 拆分子问题
        for (int i = pos; i < candidates.length; i++) {
            // 横向的重复元素不需要参与计算
            if (i != pos && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // 3.1 扩展子集
            list.add(candidates[i]);
            // 3.2 递归求解问题
            helper(result, list, candidates, target - candidates[i], i + 1);
            // 3.3 回溯
            list.remove(list.size() - 1);
        }

    }
}
