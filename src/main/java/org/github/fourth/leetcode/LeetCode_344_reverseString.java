package org.github.fourth.leetcode;

/**
 * origin:
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组s的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 */
public class LeetCode_344_reverseString {

    /**
     * 数学推导：理解是用i和s.length - 1 -i进行交换
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * note: swap技巧
     */
    public void reverseString01(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        int swapCount = s.length / 2;
        for (int i = 0; i < swapCount; i++) {
            swap(s, i, s.length - 1 - i);
        }
    }

    /**
     * 双指针：一个指前，一个指后，一直到俩个指针不满足前后顺序
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * note：swap技巧
     */
    public void reverseString02(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }

        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            swap(s, start, end);
            start++;
            end--;
        }

    }

    private static void swap(char[] s, int a, int b) {
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }


    public void reverseStringExample(char[] s) {
        reverseString01(s);
    }

}
