package org.github.fourth.leetcode;

/**
 * @author jwang55
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
