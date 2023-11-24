package org.github.fourth.leetcode;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * - 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * - 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 */
public class LeetCode_076_minWindow {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0
                || t == null || t.length() == 0) {
            return "";
        }

        int[] hash = new int[128];
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)] += 1;
        }

        int minLength = Integer.MAX_VALUE;
        String minStr = "";

        int i = 0;
        int j = 0;

        for (i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                if (!allFound(hash)) {
                    hash[s.charAt(j)]--;
                    j++;
                } else {
                    break;
                }
            }
            // 窗口收缩
            hash[s.charAt(i)]++;
            // 求解答案
            if (allFound(hash) && j - i < minLength) {
                minLength = j - i;
                minStr = s.substring(i, j);
            }
        }
        return minStr;
    }

    private boolean allFound(int[] hash) {
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
