package org.github.fourth.leetcode;

import java.util.*;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class LeetCode_139_wordBreak {

    /**
     * 回溯法
     */
    public boolean wordBreak01(String s, List<String> wordDict) {
        if (s == null || s.isEmpty() || wordDict == null || wordDict.isEmpty()) {
            return false;
        }
        // 单一解集
        List<String> list = new ArrayList<>();
        // 递归遍历解空间树
        return helper(list, s, wordDict);
    }

    private boolean helper(List<String> list, String s, List<String> wordDict) {
        // 1. 递归什么时候退出？s 不包含 sb时
        if (!s.contains(String.join("", list))) {
            return false;
        }
        // 2. 单一解集什么时候加入解集？
        if (s.equals(String.join("", list))) {
            return true;
        }

        // 3. 拆分解空间树
        for (String item : wordDict) {
            // 3.1 扩展当前解集
            list.add(item);
            // 3.2 递归求解当前解集
            boolean result = helper(list, s, wordDict);
            if (result) {
                return true;
            }
            // 3.3 回溯
            list.remove(list.size() - 1);
        }

        return false;
    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     * note:
     * 1. 记忆化搜索
     */
    public boolean wordBreakExample(String s, List<String> wordDict) {
        if (s == null || s.isEmpty() || wordDict == null) {
            return false;
        }
        // 去除重复字典
        Set<String> set = new HashSet<>(wordDict);
        // 以i为index开头的字符串是否能成功分割在dict中找到相关单词
        // -1 : 初始化， 0 ： false， 1：true
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);

        return helperExample(memo, set, s, 0);
    }

    private boolean helperExample(int[] memo, Set<String> set, String s, int pos) {
        // 递归何时退出？
        // 单一解集如何能加入到解集？
        if (pos == s.length()) {
            return true;
        }
        if (memo[pos] != -1) {
            return memo[pos] == 1;
        }

        for (int i = s.length() - 1; i >= pos; i--) {
            String subString = s.substring(pos, i + 1);
            if (!set.contains(subString)) {
                continue;
            }
            boolean curSatisfy = helperExample(memo, set, s, i + 1);
            if (curSatisfy) {
                memo[pos] = 1;
                return true;
            }
        }
        memo[pos] = 0;
        return false;
    }
}
