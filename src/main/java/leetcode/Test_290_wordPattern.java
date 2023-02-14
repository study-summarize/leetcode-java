package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Test_290_wordPattern {

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
