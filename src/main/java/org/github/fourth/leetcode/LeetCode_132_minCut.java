package org.github.fourth.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * 返回符合要求的 最少分割次数 。
 */
public class LeetCode_132_minCut {
    /**
     * 回溯法
     * 时间复杂度：
     * 空间复杂度：
     */
    public int minCut01(String s) {
        // 解集
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // 单一解集
        List<String> list = new ArrayList<>();
        // 递归遍历解空间树
        helper(result, list, s, 0);
        if (result.isEmpty()) {
            return 0;
        }

        return result.stream().min(Integer::compareTo).orElse(0);
    }

    private void helper(List<Integer> result, List<String> list, String s, int pos) {
        // 1. 递归什么时候结束？ pos到达s的长度
        // 2. 单一解集什么时候加入解集？
        if (pos == s.length()) {
            result.add(list.size() - 1);
            return;
        }

        // 3. 分解 解空间树的条件
        for (int i = pos; i < s.length(); i++) {
            // 看当前字符串是不是回文串
            String currentItem = s.substring(pos, i + 1);
            if (!judgeIsPartition(currentItem)) {
                continue;
            }
            // 3.1 扩展当前解集
            list.add(currentItem);
            // 3.2 递归求解当前解集
            helper(result, list, s, i + 1);
            // 3.3 回溯
            list.remove(list.size() - 1);
        }
    }

    private boolean judgeIsPartition(String currentItem) {
        if (currentItem == null || currentItem.isEmpty()) {
            return false;
        }
        char[] charArray = currentItem.toCharArray();
        if (charArray.length == 1) {
            return true;
        }
        for (int i = 0; i < charArray.length / 2; i++) {
            if (charArray[i] != charArray[charArray.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
