package org.github.fourth.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 */
public class LeetCode_093_restoreIpAddresses {
    /**
     * 回溯法
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<String> restoreIpAddresses01(String s) {
        // 解集
        List<String> result = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return result;
        }

        // 单一解集
        List<String> list = new ArrayList<>();
        // 递归求解问题
        helper(result, list, s, 0);
        return result;
    }

    private void helper(List<String> result, List<String> list, String s, int pos) {
        // 1. 递归什么时候结束？list的size大于4
        if (list.size() == 4 && pos != s.length()) {
            return;
        }
        // 2. 单一解集什么时候加入解集？list的size等于4，且 pos 为 nums的长度
        if (list.size() == 4 && pos == s.length()) {
            result.add(String.join(".", list));
            return;
        }

        // 3. 拆分子问题
        for (int i = pos; i < s.length(); i++) {
            // 先找出当前元素
            String itemStr = s.substring(pos, i + 1);
            int item = Integer.parseInt(itemStr);
            // 3.0 减枝
            if (item < 0 || item > 255 || (itemStr.charAt(0) == '0' && !"0".equals(itemStr))) {
                break;
            }

            // 3.1 扩大单一子集
            list.add(itemStr);
            // 3.2 递归查找
            helper(result, list, s, i + 1);
            // 3.3 回溯
            list.remove(list.size() - 1);
        }
    }
}
