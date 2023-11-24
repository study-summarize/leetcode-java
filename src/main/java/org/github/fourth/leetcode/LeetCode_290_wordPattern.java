package org.github.fourth.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 */
public class LeetCode_290_wordPattern {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public boolean wordPattern(String pattern, String s) {
        if (pattern == null || s == null) {
            return false;
        }
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> patternToWordMap = new HashMap<>();
        Map<String, Character> wordToPatternMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            if (patternToWordMap.containsKey(key)) {
                if (!words[i].equals(patternToWordMap.get(key))) {
                    return false;
                }
            }
            else if (wordToPatternMap.containsKey(words[i])) {
                return false;
            }
            else {
                patternToWordMap.put(key, words[i]);
                wordToPatternMap.put(words[i], key);
            }
        }
        return true;
    }
}
