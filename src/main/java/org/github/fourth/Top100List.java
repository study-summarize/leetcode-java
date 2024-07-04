package org.github.fourth;

import org.github.fourth.leetcode.LeetCode_001_twoSum;
import org.github.fourth.leetcode.LeetCode_003_lengthOfLongestSubstring;
import org.github.fourth.leetcode.LeetCode_021_mergeTwoLists;
import org.github.fourth.leetcode.LeetCode_025_reverseKGroup;

/**
 *
 */
public class Top100List {

    public static void main(String[] args) {
        //
        new LeetCode_001_twoSum().test(null, 0);
        new LeetCode_003_lengthOfLongestSubstring().test(null);

        new LeetCode_021_mergeTwoLists().test(null, null);

        new LeetCode_025_reverseKGroup().test(null, 0);
    }
}
