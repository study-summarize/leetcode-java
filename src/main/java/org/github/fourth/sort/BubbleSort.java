package org.github.fourth.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        // 每轮确定一个最大值
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
    public void betterSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        // 最右边有序数字是多少
        for (int i = 0; i < nums.length; i++) {
            // 表示每轮冒泡没有进行交换时，表示未排序的数组其实已经是有序了
            boolean flag = true;
            // 开始每轮冒泡：
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
    }
}
