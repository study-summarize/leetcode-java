package org.github.fourth;

import org.github.fourth.leetcode.common.ListNode;

public class ListNodeVerifyUtil {

    // 有环咋办？
    public static boolean equals(ListNode first, ListNode other) {
        if (first == null && other == null) {
            return true;
        }
        if (first == null || other == null) {
            return false;
        }
        while (first != null) {
            if (first.val != other.val) {
                return false;
            }
            first = first.next;
            other = other.next;
        }
        return other == null;
    }

}
