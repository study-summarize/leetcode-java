package org.github.fourth.sort;

/**
 * 快速排序
 */
public class QuickSort {

    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        // 新的中间值下标
        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);

    }

    /**
     * 算法导论的实现
     */
    private int partition(int[] nums, int start, int end) {
        int pivotValue = nums[end];

        // j 是左右排好序的最后一个值的下标
        int j = start - 1;
        // 先排好左边
        for (int i = start; i < end; i++) {
            // 只有在符合左边条件时，才交互位置
            if (nums[i] < pivotValue) {
                j = j + 1;
                // 说明i之前一定有元素大于pivotValue，需要交换
                if (i != j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        // start ... j : x < value
        // j + 1 = value
        // j +2 ... end：x > value
        int temp = nums[end];
        nums[end] = nums[j + 1];
        nums[j + 1] = temp;
        return j + 1;
    }

    /**
     * 第二种方式
     */
    public void sort2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        quickSort2(nums, 0, nums.length - 1);
    }

    private void quickSort2(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = partition2(nums, start, end); // x = value
        quickSort(nums, start, pivot - 1); // x < value
        quickSort(nums, pivot + 1, end);  // x > value
    }

    private int partition2(int[] nums, int start, int end) {
        int pivot = start;
        int value = nums[pivot];

        while (start < end) {
            while (start < end && nums[end] >= value) {
                end--;
            }

            // 找到要交换的元素
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            while (start < end && nums[start] <= value) {
                start++;
            }

            // find the element that bigger than value
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }

        return start;
    }
}
