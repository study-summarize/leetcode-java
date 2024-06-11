package org.github.fourth.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串的长度。
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 */
public class LeetCode_409_longestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // 统计一下字符串的个数
        Map<Character, Integer> characterMap = new HashMap<>();
        for (char item : s.toCharArray()) {
            Integer count = characterMap.get(item);
            if (count == null) {
                characterMap.put(item, 1);
            } else {
                characterMap.put(item, count + 1);
            }
        }

        // 统计一下回文串的长度：偶数都可以，奇数取最大的偶数，如果有奇数再加上1
        int result = 0;
        int oddExist = 0;
        for (Character item : characterMap.keySet()) {
            Integer count = characterMap.get(item);
            if (count % 2 == 0) {
                result = result + count;
            } else {
                oddExist = 1;
                result = result + count - 1;
            }
        }
        return result + oddExist;
    }
}
