package org.github.fourth.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class LeetCode_047_permuteUnique {
    /**
     * 回溯法
     * 时间复杂度：
     * 空间复杂度：
     * note:
     * 1. 利用标记标志，来判断横向的重复元素
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 解集
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        // 想象着，一直DFS的时候，元素是为true的
        boolean[] visited = new boolean[nums.length];

        // 单一解集
        List<Integer> list = new ArrayList<>();
        // 递归求解
        helper(result, list, nums, visited);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] visited) {
        // 1. 递归什么时候结束？list的size 等于 nums的长度
        // 2. 单一解集什么时候加入解集中
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        // 3. 拆分子问题
        for (int i = 0; i < nums.length; i++) {
            // 递归进入时，被访问过的节点不参与计算
            if (visited[i]) {
                continue;
            }
            // note: 很难想到
            // 横向比较时，如果当前元素和左边一个元素相等时，算出来的子集都是重复的
            if (i != 0 && nums[i] == nums[i-1] && visited[i - 1]) {
                continue;
            }
            // 3.1 扩展单一解集
            visited[i] = true;
            list.add(nums[i]);
            // 3.2 递归拆分子问题
            helper(result, list, nums, visited);
            // 3.3 回溯法
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
