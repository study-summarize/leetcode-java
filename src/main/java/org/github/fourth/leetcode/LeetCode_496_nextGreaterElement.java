package org.github.fourth.leetcode;

import java.util.*;

/**
 * `nums1`中数字`x`的下一个更大元素是指`x`在`nums2`中对应位置右侧的第一个比`x`大的元素。
 * 给你两个没有重复元素的数组`nums1`和`nums2`，下标从0开始计数，其中`nums1`是`nums2`的子集。
 * 对于每个`0 <= i < nums1.length`，找出满足`nums1[i] == nums2[j]`的下标`j`，并且在`nums2`确定`nums2[j]`的下一个更大元素。如果不存在下一个更大元素，那么本次查询的答案是`-1`。
 * 返回一个长度为`nums1.length`的数组`ans`作为答案，满足`ans[i]`是如上所述的下一个更大元素。
 */
public class LeetCode_496_nextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        // 递减栈
        Deque<Integer> minStack = new LinkedList<>();
        Map<Integer, Integer> answer = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!minStack.isEmpty() && nums2[minStack.peek()] < nums2[i]) {
                Integer index = minStack.pop();
                answer.put(nums2[index], nums2[i]);
            }
            minStack.push(i);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = Optional.ofNullable(answer.get(nums1[i])).orElse(-1);
        }
        return result;
    }
}
