package org.github.fourth;


import com.google.common.collect.Sets;
import org.apache.commons.collections4.CollectionUtils;
import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VerifyUtils {

    public static void assertTreeEquals(TreeNode expectNode, TreeNode actualNode) {
        if (expectNode == null) {
            Assertions.assertNull(actualNode);
        } else {
            Assertions.assertArrayEquals(expectNode.preIntegerList().toArray(), actualNode.preIntegerList().toArray());
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
        Set<List<Integer>> collect = new HashSet<>(Sets.union(new HashSet<>(expectedResult), new HashSet<>(actResult)));
        Assertions.assertEquals(expectedResult.size(), collect.size());
    }
}
