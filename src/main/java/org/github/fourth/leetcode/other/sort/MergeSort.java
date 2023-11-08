package org.github.fourth.leetcode.other.sort;

/**
 * @author jwang55
 */
public class MergeSort {

    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);

            merge(nums, start, mid, end);
        }
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int leftLength = mid - start + 1;
        int rightLength = end - mid;

        int[] left = new int[leftLength];   // start ... mid
        int[] right = new int[rightLength]; // mid + 1, ... , end

        for (int i = 0; i < leftLength; i++) {
            left[i] = nums[start + i];
        }

        for (int j = 0; j < rightLength; j++) {
            right[j] = nums[mid + 1 + j];
        }

        int index = start;
        int i = 0;
        int j = 0;
        // merge the sorted array
        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                nums[index] = left[i];
                index++;
                i++;
            } else {
                nums[index] = right[j];
                index++;
                j++;
            }
        }

        while (i < leftLength) {
            nums[index] = left[i];
            index++;
            i++;
        }
        while (j < rightLength) {
            nums[index] = right[j];
            index++;
            j++;
        }
    }

    public void sort2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int[] temp, int start, int end) {
        if (start < end) {

            int mid = start + (end - start) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);

            merge(nums, temp, start, mid, end);
        }
    }

    private void merge(int[] nums, int[] temp, int start, int mid, int end) {
        int left = start;
        int right = mid + 1;
        int index = start;

        // merge the sorted array
        while (left <= mid && right <= end) {
            if (nums[left] <= nums[right]) {
                temp[index] = nums[left];
                index++;
                left++;
            } else {
                temp[index] = nums[right];
                index++;
                right++;
            }
        }

        while (left <= mid) {
            temp[index] = nums[left];
            index++;
            left++;
        }
        while (right <= end) {
            temp[index] = nums[right];
            index++;
            right++;
        }

        for (index = start; index <= end; index++) {
            nums[index] = temp[index];
        }
    }
}
