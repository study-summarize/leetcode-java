package org.github.fourth.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_205_isIsomorphic {

    public boolean isIsomorphic(String s, String t) {
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
