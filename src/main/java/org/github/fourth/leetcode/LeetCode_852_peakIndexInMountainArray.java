package org.github.fourth.leetcode;

/**
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * - arr.length >= 3
 * - 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 * 你必须设计并实现时间复杂度为 O(log(n)) 的解决方案。
 */
public class LeetCode_852_peakIndexInMountainArray {
    /**
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     */
    public int peakIndexInMountainArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return arr[start] > arr[end] ? start : end;
    }
}
