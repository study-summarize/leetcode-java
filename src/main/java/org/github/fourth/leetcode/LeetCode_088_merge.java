package org.github.fourth.leetcode;

/**
 * origin:
 * 给你两个按非递减顺序排列的整数数组nums1和nums2，另有两个整数m和n，分别表示nums1和nums2中的元素数目。
 * 请你合并nums2到nums1中，使合并后的数组同样按非递减顺序排列。
 */
public class LeetCode_088_merge {

    /**
     * 双指针
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums1.length == 0) {
            return;
        }
        // 如果nums2是空，直接返回
        if (nums2 == null || nums2.length == 0) {
            return;
        }
        int[] num = new int[m];
        for (int i = 0; i < m; i++) {
            num[i] = nums1[i];
        }

        int startNum1 = 0;
        int startNum2 = 0;
        int startNum = 0;
        while (startNum < m && startNum2 < n) {
            if (num[startNum] <= nums2[startNum2]) {
                nums1[startNum1] = num[startNum];
                ++startNum;
                ++startNum1;
            } else {
                // nums2数字比较小
                nums1[startNum1] = nums2[startNum2];
                ++startNum1;
                ++startNum2;
            }
        }
        // 俩个数组还有多余长度时
        while (startNum < m) {
            nums1[startNum1++] = num[startNum++];
        }
        while (startNum2 < n) {
            nums1[startNum1++] = nums2[startNum2++];
        }

    }

    public void mergeExample(int[] nums1, int m, int[] nums2, int n) {
        merge(nums1, m, nums2, n);
    }
}
