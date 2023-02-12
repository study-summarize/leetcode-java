package leetcode;

/**
 * @author jwang55
 */
public class Test_215_findKthLargest {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return 0;
        }
        // 第K大 等价于 第pivot小
        int i = nums.length - k + 1;
        return quickSelect(0, nums.length - 1, i, nums);
    }

    private int quickSelect(int start, int end, int k, int[] nums) {
        // base case
        if (start == end) {
            return nums[start];
        }

        int index = partition(nums, start, end);
        // 包括nums[index]
        int num = index - start + 1;
        if (k == num) {
            return nums[index];
        }
        else if (k < num) {
            return quickSelect(start, index - 1, k, nums);
        }
        else {
            return quickSelect(index + 1, end, k - num, nums);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int pivotValue = nums[end];

        // 左边部分
        int j = start - 1;
        for (int i = start; i <= end; i++) {
            // note：不能含有等号
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
}
