package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jwang55
 */
public class Test_015_threeSum {

    /**
     * 暴力解法：三层for循环
     */
    public int[] threeSum01(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int m = j + 1; m < nums.length; m++) {
                    if (nums[i] + nums[j] + nums[m] == target) {
                        return new int[]{nums[i], nums[j], nums[m]};
                    }
                }
            }
        }
        return null;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 上一个元素已经将所有可能都遍历过了，因为要去重，所以这里直接跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);

                    start++;
                    end--;

                    // 去重：比如：-3,-1,0,0,1,2,3,3,3
                    // 去重现在nums[start]和原来nums[start]相等，因为后续如果还需要满足条件，结果集合的元素还是重复的
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                    // 去重现在nums[end]和原来nums[end]相等，因为后续如果还需要满足条件，结果集合的元素还是重复的
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else if (sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return result;
    }
}
