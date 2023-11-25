package org.github.fourth.leetcode;

import java.util.*;

/**
 * `nums1`中数字`x`的下一个更大元素是指`x`在`nums2`中对应位置右侧的第一个比`x`大的元素。
 * 给你两个没有重复元素的数组`nums1`和`nums2`，下标从0开始计数，其中`nums1`是`nums2`的子集。
 * 对于每个`0 <= i < nums1.length`，找出满足`nums1[i] == nums2[j]`的下标`j`，并且在`nums2`确定`nums2[j]`的下一个更大元素。如果不存在下一个更大元素，那么本次查询的答案是`-1`。
 * 返回一个长度为`nums1.length`的数组`ans`作为答案，满足`ans[i]`是如上所述的下一个更大元素。
 */
public class LeetCode_496_nextGreaterElement {

    /**
     * 一次单调栈 + 哈希表
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int[] nextGreaterElement02(int[] nums1, int[] nums2) {
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
            result[i] = answer.get(nums1[i]) == null ? -1 : answer.get(nums1[i]);
        }
        return result;
    }

    /**
     * 一次单调栈
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
    public int[] nextGreaterElement01(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0
                || nums2 == null || nums2.length == 0) {
            return null;
        }

        // nums2，从左到右，一个大的元素；递减栈
        int[] right = new int[nums2.length];
        Arrays.fill(right, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                int index = stack.pop();
                right[index] = nums2[i];
            }
            stack.push(i);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    result[i] = right[j];
                }
            }
        }
        return result;
    }
}
