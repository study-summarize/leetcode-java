package org.github.fourth.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个字符串数组`tokens`，表示一个根据[逆波兰表示法](https://baike.baidu.com/item/%E9%80%86%E6%B3%A2%E5%85%B0%E5%BC%8F/128437)表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * 注意：
 * - 有效的算符为`'+'`、`'-'`、`'*'`和`'/'`。
 * - 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * - 两个整数之间的除法总是向零截断。
 * - 表达式中不含除零运算。
 * - 输入是一个根据逆波兰表示法表示的算术表达式。
 * - 答案及所有中间计算结果可以用**32 位**整数表示。
 */
public class LeetCode_150_evalRPN {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new LinkedList<>();

        for (String token : tokens) {
            if ("+".equalsIgnoreCase(token)) {
                Integer op1 = stack.pop();
                Integer op2 = stack.pop();
                stack.push(op2 + op1);
            } else if ("-".equalsIgnoreCase(token)) {
                Integer op1 = stack.pop();
                Integer op2 = stack.pop();
                stack.push(op2 - op1);
            } else if ("*".equalsIgnoreCase(token)) {
                Integer op1 = stack.pop();
                Integer op2 = stack.pop();
                stack.push(op2 * op1);
            } else if ("/".equalsIgnoreCase(token)) {
                Integer op1 = stack.pop();
                Integer op2 = stack.pop();
                stack.push(op2 / op1);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }
}
