import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

public class SortArrayByParity {

    @SuppressFBWarnings("IM_BAD_CHECK_FOR_ODD")
    public int[] sortArrayByParity(int[] nums) {
        if (nums == null || nums.length < 1) {
            return nums;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            while (start < end && nums[start] % 2 == 0) {
                start++;
            }
            while (start < end && nums[end] % 2 == 1) {
                end--;
            }

            if (start < end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }

        return nums;
    }

    private static void swap(int[] nums, int a, int b) {
        if (nums == null || a >= nums.length || b >= nums.length) {
            return;
        }
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
