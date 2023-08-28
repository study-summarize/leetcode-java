package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jwang55
 */
public class Test_001_twoSum {

    /**
     * 暴力解法1：双层for循环
     */
    public int[] twoSum01(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[2];
        }

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * 排序+双指针，求具体值，而不是下标
     * 时间复杂度：O(nlogn)
     */
    public int[] twoSum02(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        // 排序：O(nlogn)
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;

        // 二分法一定要这样写，记得模板
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                return new int[]{nums[start], nums[end]};
            }
            if (nums[start] + nums[end] > target) {
                end--;
            }
            if (nums[start] + nums[end] < target) {
                start++;
            }
        }
        return null;
    }

    /**
     * 哈希表
     */
    public int[] twoSum03(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[2];
        }
        Map<Integer, Integer> map = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            int targetValue = target - nums[index];
            if (map.containsKey(targetValue)) {
                return new int[]{map.get(targetValue), index};
            }
            map.put(nums[index], index);
        }
        return new int[2];
    }
}
