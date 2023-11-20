package org.github.fourth.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个只包括`'('`，`')'`，`'{'`，`'}'`，`'['`，`']'`的字符串`s`，判断字符串是否有效。
 * 有效字符串需满足：
 * 1. 左括号必须用相同类型的右括号闭合。
 * 2. 左括号必须以正确的顺序闭合。
 * 3. 每个右括号都有一个对应的相同类型的左括号。
 */
public class LeetCode_020_isValid {
    public boolean isValid(String s) {
        if (s == null || "".equalsIgnoreCase(s)) {
            return true;
        }
        Deque<Character> stack = new LinkedList<>();

        char[] elementArr = s.toCharArray();
        for (char element : elementArr) {
            if ('(' == element
                    || '{' == element
                    || '[' == element) {
                stack.push(element);
                continue;
            }

            // 防止空元素
            if (stack.isEmpty()) {
                return false;
            }

            char currentChar = stack.pop();
            if (')' == element) {
                if (currentChar != '(') {
                    return false;
                }
            } else if ('}' == element) {
                if (currentChar != '{') {
                    return false;
                }
            } else if (']' == element) {
                if (currentChar != '[') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
