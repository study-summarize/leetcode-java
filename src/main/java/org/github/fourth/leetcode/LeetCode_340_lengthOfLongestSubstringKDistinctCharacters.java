package org.github.fourth.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 和一个整数 k ，请你找出 至多 包含 k 个 不同 字符的最长子串，并返回该子串的长度。
 */
public class LeetCode_340_lengthOfLongestSubstringKDistinctCharacters {

    /**
     * 同向型双指针-滑动窗口
     * 时间复杂度：
     * 空间复杂度：
     */
    public int lengthOfLongestSubstringKDistinctCharacters(String s, int k) {
        if (s == null || s.isEmpty() || k < 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        Map<Character, Integer> containCharMap = new HashMap<>();
        for (; start < s.length(); start++) {
            while (end < s.length()) {
                // 不符合条件，向右滑动
                if (containCharMap.containsKey(s.charAt(end))
                        || containCharMap.keySet().size() < k) {
                    containCharMap.put(s.charAt(end), containCharMap.getOrDefault(s.charAt(end), 0) + 1);
                    end++;
                } else {
                    break;
                }
            }
            // 开始收缩窗口
            result = Math.max(result, end - start);
            Integer size = containCharMap.getOrDefault(s.charAt(start), 0);
            if (size == 1) {
                containCharMap.remove(s.charAt(start));
            } else {
                containCharMap.put(s.charAt(start), size - 1);
            }
        }
        return result;
    }

    public int lengthOfLongestSubstringKDistinctCharactersExample(String s, int k) {
        int result = 0;
        if (s == null || s.isEmpty() || k == 0) {
            return result;
        }

        int i = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                char ch = s.charAt(j);
                if (map.size() < k || map.containsKey(ch)) {
                    map.put(ch, j);
                    result = Math.max(result, j - i + 1);
                    j++;
                } else {
                    break;
                }
            }
            // 收缩
            int minIndex = s.length() - 1;
            for (int index : map.values()) {
                minIndex = Math.min(minIndex, index);
            }
            char charToDelete = s.charAt(minIndex);
            map.remove(charToDelete);
            i = minIndex;
        }
        return result;
    }
}
