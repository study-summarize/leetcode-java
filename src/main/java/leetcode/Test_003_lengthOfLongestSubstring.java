package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jwang55
 */
public class Test_003_lengthOfLongestSubstring {

    /**
     * 利用Set来判断重复元素
     */
    public int lengthOfLongestSubstring1(String s) {
        int result = 0;
        if (s == null || s.length() == 0) {
            return result;
        }
        Set<Character> set = new HashSet<>();

        int i = 0;
        int j = 0;

        for (; i < s.length(); i++) {
            while (j < s.length()) {
                char ch = s.charAt(j);
                if (!set.contains(ch)) {
                    set.add(ch);
                    result = Math.max(result, j - i + 1);
                    j++;
                } else {
                    break;
                }
            }
            // 更新i的起始点
            set.remove(s.charAt(i));
        }
        return result;
    }

    /**
     * 方法一的优化版：利用数组来节省空间、速度
     */
    public int lengthOfLongestSubstring1Refine(String s) {
        int result = 0;
        if (s == null || s.length() == 0) {
            return result;
        }
        // ASCII 256个
        int[] set = new int[256];

        int i = 0;
        int j = 0;

        for (; i < s.length(); i++) {
            while (j < s.length()) {
                char ch = s.charAt(j);
                if (set[ch] == 0) {
                    set[ch] = 1;
                    result = Math.max(result, j - i + 1);
                    j++;
                } else {
                    break;
                }
            }
            // 更新i的起始点
            set[s.charAt(i)] = 0;
        }
        return result;
    }
}
