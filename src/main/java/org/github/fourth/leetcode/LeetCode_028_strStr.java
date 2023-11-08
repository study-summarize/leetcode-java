package org.github.fourth.leetcode;

public class LeetCode_028_strStr {

    /**
     * 方法一：暴力解法
     */
    public int strStr01(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0 || needle == null || needle.length() == 0) {
            return -1;
        }

        int sLen = haystack.length();
        int tLen = needle.length();

        for (int i = 0; i <= sLen - tLen; i++) {
            int j = 0;
            while (j < tLen) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                j++;
            }
            if (j == tLen) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 方法二：Robin-Karp算法
     */
    public int strStr02(String haystack, String needle) {
        return -1;
    }
}
