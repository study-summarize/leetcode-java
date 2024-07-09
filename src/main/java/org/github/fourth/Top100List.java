package org.github.fourth;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.github.fourth.leetcode.*;

/**
 *
 */
@SuppressFBWarnings("RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT")
public class Top100List {

    public static void main(String[] args) {
        //
        new LeetCode_001_twoSum().test(null, 0);
        new LeetCode_003_lengthOfLongestSubstring().test(null);

        new LeetCode_015_threeSum().test(null);

        new LeetCode_002_addTwoNumbers().test(null, null);
        new LeetCode_021_mergeTwoLists().test(null, null);
        new LeetCode_025_reverseKGroup().test(null, 0);
        new LeetCode_024_swapPairs().test(null);
        new LeetCode_019_removeNthFromEnd().test(null, 0);
    }
}
