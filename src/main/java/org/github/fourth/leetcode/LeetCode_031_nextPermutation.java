package org.github.fourth.leetcode;

public class LeetCode_031_nextPermutation {
    public void nextPermutation(int[] nums) {
        // 从右到左找到第一个nums[i] < nums[i + 1]；如果没有，就全部反转
        // 从右到左找到第一个nums[i] < nums[j]
        // swap(i,j)
        // 将i + 1后面的数字全部翻转
        if (nums == null || nums.length <= 1) {
            return;
        }

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 从右到左找到
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int l = start;
        int r = nums.length - 1;
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
