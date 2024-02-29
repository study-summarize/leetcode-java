package org.github.fourth.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 */
public class LeetCode_205_isIsomorphic {

    /**
     *
     */
    public boolean isIsomorphic01(String s, String t) {
        return false;
    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public boolean isIsomorphicExample(String s, String t) {
        char[] sCharArr = s == null ? new char[0] : s.toCharArray();
        char[] tCharArr = t == null ? new char[0] : t.toCharArray();
        if (sCharArr.length != tCharArr.length) {
            return false;
        }

        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> lMap = new HashMap<>();
        for (int i = 0; i < sCharArr.length; i++) {
            char sChar = sCharArr[i];
            char tChar = tCharArr[i];
            if (sMap.containsKey(sChar)) {
                if (!sMap.get(sChar).equals(tChar)) {
                    return false;
                }
            }
            else if (lMap.containsKey(tChar)) {
                return false;
            }
            else {
                sMap.put(sChar, tChar);
                lMap.put(tChar, sChar);
            }
        }
        return true;
    }
}
