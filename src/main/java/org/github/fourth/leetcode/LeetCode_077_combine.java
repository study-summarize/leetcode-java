package org.github.fourth.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 */
public class LeetCode_077_combine {
    public List<List<Integer>> combine(int n, int k) {
        if (n < 1 || n < k) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();

        helper(result, item, n, k, 1);

        return result;
    }

    private static void helper(List<List<Integer>> result, List<Integer> item, int n, int k, int pos) {
        // 递归什么时候退出
        // 单一解集加入解集
        if (item.size() == k) {
            result.add(new ArrayList<>(item));
            return;
        }

        // 递归拆分子问题
        for (int i = pos; i <= n; i++) {
            // 扩展解集
            item.add(i);
            // 计算子问题
            helper(result, item, n, k, i + 1);
            // 回溯
            item.remove(item.size() - 1);
        }
    }
}
