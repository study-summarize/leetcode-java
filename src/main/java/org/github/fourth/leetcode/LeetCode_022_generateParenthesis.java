package org.github.fourth.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class LeetCode_022_generateParenthesis {
    /**
     * 回溯法
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<String> generateParenthesis01(int n) {
        // 解集
        List<String> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

        StringBuffer sb = new StringBuffer();
        helper(result, sb, n, n);
        return result;
    }

    public void helper(List<String> result, StringBuffer sb, int leftRemain, int rightRemain) {
        // 1. 递归什么时候退出
        // 2. 单一解集什么时候加入解集中
        if (leftRemain == 0 && rightRemain == 0) {
            result.add(sb.toString());
            return;
        }

        // 3. 递归解决问题
        // 3a. 左括号有空余时，可以加左括号
        if (leftRemain > 0) {
            sb.append("(");
            helper(result, sb, leftRemain - 1, rightRemain);
            sb.deleteCharAt(sb.length() - 1);
        }
        // 3b. 右括号个数大于剩余的左括号个数
        if (rightRemain > leftRemain) {
            sb.append(")");
            helper(result, sb, leftRemain, rightRemain - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
