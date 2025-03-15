package org.github.fourth.leetcode;

public class LeetCode_647_countSubstring {

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            for (int j = i + 1; j <= charArray.length; j++) {
                String subString = s.substring(i, j);
                if (judge(subString)) {
                    ++result;
                }
            }
        }
        return result;
    }

    private boolean judge(String subString) {
        if (subString == null || subString.length() == 0) {
            return false;
        }
        char[] charArray = subString.toCharArray();
        for (int i = 0; i < charArray.length / 2; i++) {
            if (charArray[i] != charArray[charArray.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
