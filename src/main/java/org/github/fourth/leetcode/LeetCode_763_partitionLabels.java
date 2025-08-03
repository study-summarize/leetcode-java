package org.github.fourth.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。例如，字符串 "ababcc" 能够被分为 ["abab", "cc"]，但类似 ["aba", "bcc"] 或 ["ab", "ab", "cc"] 的划分是非法的。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 */
public class LeetCode_763_partitionLabels {
    public List<Integer> partitionLabels(String s) {
        if (s == null) {
            return null;
        }

        List<Integer> result = new ArrayList<>();
        char[] charArray = s.toCharArray();
        Map<Character, Integer> lastIndex = new HashMap<>();
        // 先计算出每个字符最晚出现的位置
        for (int i = 0; i < charArray.length; i++) {
            lastIndex.put(charArray[i], i);
        }

        int end = 0;
        int start = 0;
        for (int i = 0; i < charArray.length; i++) {
            int pos = lastIndex.get(charArray[i]);
            end = Math.max(end, pos);
            if (end == i) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}
