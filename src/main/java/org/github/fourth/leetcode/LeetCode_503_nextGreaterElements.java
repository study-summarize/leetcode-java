package org.github.fourth.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个循环数组`nums`（`nums[nums.length - 1]`的下一个元素是`nums[0]`），返回`nums`中每个元素的下一个更大元素。
 * 数字`x`的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出`-1`。
 */
public class LeetCode_503_nextGreaterElements {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        // 递减栈
        Deque<Integer> minStack = new LinkedList<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < 2 * nums.length; i++) {
            while (!minStack.isEmpty() && nums[minStack.peek()] < nums[i % nums.length]) {
                Integer index = minStack.pop();
                result[index] = nums[i % nums.length];
            }
            minStack.push(i % nums.length);
        }
        return result;
    }
}
