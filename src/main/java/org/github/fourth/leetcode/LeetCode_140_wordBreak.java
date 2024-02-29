package org.github.fourth.leetcode;

import java.util.*;

/**
 * 给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
 * 注意：词典中的同一个单词可能在分段中被重复使用多次。
 */
public class LeetCode_140_wordBreak {

    /**
     * 回溯法
     */
    public List<String> wordBreak01(String s, List<String> wordDict) {
        // 解集
        List<String> result = new ArrayList<>();
        if (s == null || s.isEmpty() || wordDict == null || wordDict.isEmpty()) {
            return List.of();
        }
        // 单一解集
        List<String> list = new ArrayList<>();
        // 递归遍历解空间树
        helper(result, list, s, wordDict, 0);
        return result;
    }

    private void helper(List<String> result, List<String> list, String s, List<String> wordDict, int pos) {
        // 1. 递归什么时候结束？ pos 到达 s的长度
        // 2. 单一解集什么时候加入解集？
        if (pos == s.length()) {
            result.add(String.join(" ", list));
            return;
        }

        // 3. 拆分解空间树的问题
        for (int i = pos; i < s.length(); i++) {
            String currentItem = s.substring(pos, i + 1);
            if (!wordDict.contains(currentItem)) {
                continue;
            }
            // 3.1 扩展当前解集
            list.add(currentItem);
            // 3.2 递归求解当前解集
            helper(result, list, s, wordDict, i + 1);
            // 3.3 回溯
            list.remove(list.size() - 1);
        }
    }


    /**
     * 记忆化搜索
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<String> wordBreakExample01(String s, List<String> wordDict) {
        // 解集
        List<String> result = new ArrayList<>();
        if (s == null || s.isEmpty() || wordDict == null) {
            return result;
        }
        // key 为要拆分的字符串开始的位置，value：可能的全部单词组合
        Map<Integer, List<String>> memo = new HashMap<>();

        return helperExample01(memo, s, 0, wordDict);
    }


    private List<String> helperExample01(Map<Integer, List<String>> memo, String s, int pos, List<String> wordDict) {
        // 先判断之前是否已经搜索过
        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }
        // 当前字符串的结果集
        List<String> result = new ArrayList<>();

        // 递归什么时候退出？
        if (pos == s.length()) {
            return result;
        }

        // 单一解集什么时候加入解集中？
        if (wordDict.contains(s.substring(pos))) {
            result.add(s.substring(pos));
        }

        // 拆分子问题
        for (int i = pos; i < s.length(); i++) {
            String subString = s.substring(pos, i + 1);
            if (!wordDict.contains(subString)) {
                continue;
            }
            List<String> curResult = helperExample01(memo, s, i + 1, wordDict);
            for (String item : curResult) {
                result.add(subString + " " + item);
            }
        }
        memo.put(pos, result);

        return result;
    }


    /**
     * 回溯法
     */
    public List<String> wordBreakExample02(String s, List<String> wordDict) {
        // 解集
        List<String> result = new ArrayList<>();
        if (s == null || s.isEmpty() || wordDict == null) {
            return result;
        }
        // 单一解集
        List<String> list = new ArrayList<>();

        helperExample02(result, list, s, 0, wordDict);

        return result;
    }

    private void helperExample02(List<String> result, List<String> list, String s, int pos, List<String> wordDict) {
        // 递归什么时候退出？
        // 单一解集什么时候加入解集中？
        if (pos == s.length()) {
            result.add(String.join(" ", list));
            return;
        }

        // 拆分子问题
        for (int i = pos; i < s.length(); i++) {
            String subString = s.substring(pos, i + 1);
            if (!wordDict.contains(subString)) {
                continue;
            }
            list.add(subString);
            helperExample02(result, list, s, i + 1, wordDict);
            // 回溯
            list.remove(list.size() - 1);
        }
    }
}
