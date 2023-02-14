package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jwang55
 */
public class Test_001_twoSum {

    public int[] twoSum(int[] nums, int target) {
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
