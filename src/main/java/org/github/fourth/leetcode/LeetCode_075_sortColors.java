package org.github.fourth.leetcode;

/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 */
public class LeetCode_075_sortColors {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int first = 0;
        int second = nums.length - 1;
        int i = 0;
        while (i <= second) {
            if (nums[i] == 0) {
                swap(nums, first, i);
                first++;
                i++;
            }
            else if (nums[i] == 2) {
                swap(nums, second, i);
                second--;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
