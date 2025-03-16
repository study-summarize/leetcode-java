package org.github.fourth.leetcode;

public class LeetCode_005_longestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        // dp[i][j]：表示从i-j是否符合回文串
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 初始化dp[i][i]一定是
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[]
        // 先长度为2的字符串开始
        for (int l = 2; l <= s.length(); l++) {
            // 从左边界开始
            for (int i = 0; i < s.length(); i++) {
                int j = i + l - 1;
                // 数组越界了
                if (j >= s.length()) {
                    break;
                }

                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要有一个子串就开始重新计算结果
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
