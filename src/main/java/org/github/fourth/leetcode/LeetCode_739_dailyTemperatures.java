package org.github.fourth.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，其中answer[i]是指对于第i天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用0来代替。
 */
public class LeetCode_739_dailyTemperatures {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return null;
        }

        Deque<Integer> minStack = new LinkedList<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!minStack.isEmpty() && temperatures[minStack.peek()] < temperatures[i]) {
                Integer index = minStack.pop();
                result[index] = i - index;
            }
            minStack.push(i);
        }
        return result;
    }
}
