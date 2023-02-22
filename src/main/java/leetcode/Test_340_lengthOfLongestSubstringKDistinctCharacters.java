package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Test_340_lengthOfLongestSubstringKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinctCharacters(String s, int k) {
        int result = 0;
        if (s == null || s.length() == 0 || k == 0) {
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
