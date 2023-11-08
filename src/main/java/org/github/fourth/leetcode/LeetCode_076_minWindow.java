package org.github.fourth.leetcode;

public class LeetCode_076_minWindow {
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
