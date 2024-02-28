package org.github.fourth.leetcode;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class LeetCode_017_letterCombinations {
    /**
     * 回溯法
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<String> letterCombinations01(String digits) {
        // 解集
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        // 数字对应的字母
        Map<Integer, List<String>> map = new HashMap<>();
        map.put(2, Arrays.asList("a", "b", "c"));
        map.put(3, Arrays.asList("d", "e", "f"));
        map.put(4, Arrays.asList("g", "h", "i"));
        map.put(5, Arrays.asList("j", "k", "l"));
        map.put(6, Arrays.asList("m", "n", "o"));
        map.put(7, Arrays.asList("p", "q", "r", "s"));
        map.put(8, Arrays.asList("t", "u", "v"));
        map.put(9, Arrays.asList("w", "y", "x", "y", "z"));


        // 单一解集
        List<String> list = new ArrayList<>();
        // 递归解决问题
        helper(result, list, digits, 0, map);
        return result;
    }

    private void helper(List<String> result, List<String> list, String digits, int pos, Map<Integer, List<String>> map) {
        // 1. 递归什么时候退出？pos超过digit的长度
        // 2. 单一解集什么时候加入解集？list大小 等于 digit的长度
        if (list.size() == digits.length()) {
            result.add(String.join("", list));
            return;
        }

        // 3. 拆分子问题
        for (int i = pos; i < digits.length(); i++) {
            Integer integer = Integer.valueOf(digits.substring(pos, pos + 1));
            List<String> items = map.get(integer);
            for (int j = 0; j < items.size(); j++) {
                // 3.1 单一解集扩展
                list.add(items.get(j));
                // 3.2 递归求解
                helper(result, list, digits, i + 1, map);
                // 3.3 回溯
                list.remove(list.size() - 1);
            }
        }
    }

    public static final Map<Character, char[]> digitsToCharsMap = new HashMap<Character, char[]>(){{
        put('2', new char[]{'a', 'b', 'c'});
        put('3', new char[]{'d', 'e', 'f'});
        put('4', new char[]{'g', 'h', 'i'});
        put('5', new char[]{'j', 'k', 'l'});
        put('6', new char[]{'m', 'n', 'o'});
        put('7', new char[]{'p', 'q', 'r', 's'});
        put('8', new char[]{'t', 'u', 'v'});
        put('9', new char[]{'w', 'x', 'y', 'z'});
    }};

    public List<String> letterCombinationsExample(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.isEmpty()) {
            return result;
        }

        StringBuffer sb = new StringBuffer();
        helperExample(result, sb, digits);
        return result;
    }

    private void helperExample(List<String> result, StringBuffer sb, String digits) {
        // 1. 递归什么时候结束
        // 2. 单一解集什么时候加入解集中
        if(sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        // 3. 拆分问题，递归求解
        for(char item : digitsToCharsMap.get(digits.charAt(sb.length()))) {
            // 4. 有无剪枝
            // 5. 完善单一解集，递归解决
            sb.append(item);
            helperExample(result, sb, digits);
            // 6. 回溯法
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
