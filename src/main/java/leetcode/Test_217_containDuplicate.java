package leetcode;

import java.util.*;

/**
 * @author jwang55
 */
public class Test_217_containDuplicate {

    public boolean containDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
