package org.github.fourth.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jwang55
 */
public class LeetCode_219_containsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int num = nums[index];
            if (map.containsKey(num)) {
                Integer originIndex = map.get(num);
                if (index - originIndex <= k) {
                    return true;
                } else {
                    map.put(num, index);
                }
            } else {
                map.put(num, index);

            }
        }
        return false;
    }
}
