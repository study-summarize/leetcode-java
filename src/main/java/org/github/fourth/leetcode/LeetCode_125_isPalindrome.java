package org.github.fourth.leetcode;

/**
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * 字母和数字都属于字母数字字符。
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 */
public class LeetCode_125_isPalindrome {
    /**
     * 相遇型双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        char[] charArray = s.toCharArray();
        int start = 0;
        int end = charArray.length - 1;
        while (start < end) {
            if (!isSatisfyChar(charArray[start])) {
                start++;
                continue;
            }
            if (!isSatisfyChar(charArray[end])) {
                end--;
                continue;
            }
            char startChar = Character.toLowerCase(charArray[start]);
            char endChar = Character.toLowerCase(charArray[end]);
            if (startChar != endChar) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }

    private static boolean isSatisfyChar(char c) {
        return (c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }
}
