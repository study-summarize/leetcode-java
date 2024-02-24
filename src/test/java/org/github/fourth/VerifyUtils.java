package org.github.fourth;


import org.apache.commons.collections4.CollectionUtils;
import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.Collection;
import java.util.List;

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

    public static void assertListInListEquals(List<List<Integer>> expectedResult, List<List<Integer>> actResult) {
        if (expectedResult == null && actResult == null) {
            return;
        }
        if (expectedResult == null || actResult == null) {
            Assertions.fail();
        }
        Assertions.assertEquals(expectedResult.size(), actResult.size());
        for (int i = 0; i < expectedResult.size(); i++) {
            Assertions.assertTrue(VerifyUtils.assertListEquals(expectedResult.get(i), actResult.get(i)));
        }
    }
}
