package org.github.fourth.leetcode;

import org.github.fourth.Top100;

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 * 思考：
 * 题目其实等价于将字符串所用字符相同组成一个数组。最好的想法也就是将字符串按照同一个排序生成一个Key即可
 *
 * 解法：
 * - 将字符串排序作为key
 * - 将字符串解析成字符+count
 */
@Top100
public class LeetCode_049_groupAnagrams {

    /**
     * 对字符串使用同一的排序为key
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 按字母序排序
            char[] toCharArray = str.toCharArray();
            Arrays.sort(toCharArray);
            String sortedStr = new String(toCharArray);

            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedStr, list);
            }
        }
        result.addAll(map.values());
        return result;
    }

    /**
     * 使用字符+count为key
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 按字母+个数作为key
            int[] counts = new int[26];
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                counts[ch - 'a']++;
            }
            // build hash key
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] != 0) {
                    char ch = (char) (i + 'a');
                    sb.append(ch).append(counts[i]);
                }
            }

            if (map.containsKey(sb.toString())) {
                map.get(sb.toString()).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sb.toString(), list);
            }
        }
        result.addAll(map.values());
        return result;
    }
}
