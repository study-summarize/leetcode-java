package org.github.fourth.leetcode;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 */
public class LeetCode_028_strStr {

    /**
     * 方法一：暴力解法
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */
    public int strStr01(String haystack, String needle) {
        if (haystack == null || haystack.isEmpty() || needle == null || needle.isEmpty()) {
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
     * 时间复杂度：
     * 空间复杂度：
     */
    public int strStr02(String haystack, String needle) {
        return -1;
    }

    /**
     * 方法三：同向型双指针-滑动窗口
     * 时间复杂度：
     * 空间复杂度：
     */
    public int strStr03(String haystack, String needle) {
        if (haystack == null || haystack.isEmpty()
                || needle == null || needle.isEmpty()
                || haystack.length() < needle.length()) {
            return -1;
        }

        int start = 0;
        int end;
        int result = -1;
        for (; start < haystack.length(); ) {
            end = 0;
            while (end < needle.length()) {
                // 符合条件时，向右滑动
                if (haystack.charAt(start + end) == needle.charAt(end)) {
                    end++;
                } else {
                    break;
                }
            }
            // 不符合条件，开始收缩
            if (end == needle.length()) {
                result = start;
                break;
            }
            start++;
        }
        return result;
    }
}
