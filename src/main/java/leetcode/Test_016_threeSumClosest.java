package leetcode;

import java.util.Arrays;

/**
 * @author jwang55
 */
public class Test_016_threeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            // 去重1
            if (i > 0 && nums[i] == nums[i + 1]) {
                continue;
            }

            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) {
                    return target;
                }

                result = Math.min(Math.abs(sum - target), Math.abs(sum - result));

                if (sum > target) {
                    end--;
                    // 去重2：
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else {
                    start++;
                    // 去重2：
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                }
            }
        }
        return result;
    }
}
