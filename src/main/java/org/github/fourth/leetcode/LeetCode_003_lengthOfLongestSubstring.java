package org.github.fourth.leetcode;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.github.fourth.Top100;

import java.util.*;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 解法：
 * - 双层for循环减去重复运算
 * - 双指针 + 滑动窗口
 *
 */
@Top100
public class LeetCode_003_lengthOfLongestSubstring {

    @SuppressFBWarnings("WMI_WRONG_MAP_ITERATOR")
    public int test(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] charArray = s.toCharArray();

        int result = 1;
        int preIndex = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            char item = charArray[i];
            if (!charMap.containsKey(item)) {
                charMap.put(item, i);
                // 如果到达最终点
                if (i == charArray.length - 1) {
                    result = Math.max(result, charArray.length - preIndex);
                }
            }
            else {
                Integer starIndex = charMap.get(item);
                result = Math.max(result, i - starIndex);
                // 删除前面的元素
                List<Character> needRemoveCharList = new ArrayList<>();
                for (Character charItem : charMap.keySet()) {
                    Integer charIndex = charMap.get(charItem);
                    if (charIndex < i) {
                        needRemoveCharList.add(charItem);
                    }
                }
                for (Character charItem : needRemoveCharList) {
                    charMap.remove(charItem);
                }
                // 再把当前元素加入进去
                charMap.put(item, i);
            }
        }
        return result;
    }
    /**
     * 双指针，滑动窗口
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int result = 0;
        Set<Character> hadCharSet = new HashSet<>();
        for (; left < s.length(); left++) {
            while (right < s.length()) {
                if (!hadCharSet.contains(s.charAt(right))) {
                    hadCharSet.add(s.charAt(right));
                    right++;
                    result = Math.max(result, hadCharSet.size());
                } else {
                    break;
                }
            }
            hadCharSet.remove(s.charAt(left));
        }
        return result;
    }

    /**
     * 利用数组来节省空间、速度
     */
    public int lengthOfLongestSubstring2Refine(String s) {
        int result = 0;
        if (s == null || s.isEmpty()) {
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

    /**
     * 暴力解法：双层for循环，利用Set来判断重复元素
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
    public int lengthOfLongestSubstring1(String s) {
        int result = 0;
        if (s == null || s.isEmpty()) {
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
            /*
             * 当重复元素不再最前方，为什么这里不删除重复元素之前的元素？
             * 因为内部for循环判断的时候，还是会判断成有重复元素，从而再执行到这里减去重复元素
             */
            // 更新i的起始点
            set.remove(s.charAt(i));
        }
        return result;
    }

    /**
     * 方法一的优化版：利用数组来节省空间、速度
     * 时间复杂度：
     * 空间复杂度：
     */
    public int lengthOfLongestSubstring1Refine(String s) {
        int result = 0;
        if (s == null || s.isEmpty()) {
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
