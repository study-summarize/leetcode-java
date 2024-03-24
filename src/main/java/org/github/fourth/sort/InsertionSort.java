package org.github.fourth.sort;

/**
 * 插入排序
 */
public class InsertionSort {

    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        for (int i = 1; i < nums.length; i++) {
            // 将当前元素从后往前比较，只要比前面小，就往前走。省去考虑其他情况
            int j = i - 1;

            int key = nums[i];
            // 从右往左比较:排好序的最左边开始比较，直至找到第一个比他小的元素，把元素放在这个位置的后边
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

}
