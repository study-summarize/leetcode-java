package org.github.fourth;


import org.apache.commons.collections4.CollectionUtils;
import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.Collection;

public class VerifyUtils {

    public static void assertTreeEquals(TreeNode expectNode, TreeNode actualNode) {
        if (expectNode == null) {
            Assertions.assertNull(actualNode);
        } else {
            Assertions.assertArrayEquals(actualNode.preIntegerList().toArray(), expectNode.preIntegerList().toArray());
        }
    }

    public static boolean assertListEquals(Collection<?> a, Collection<?> b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }

        return CollectionUtils.isEqualCollection(a, b);
    }

}
