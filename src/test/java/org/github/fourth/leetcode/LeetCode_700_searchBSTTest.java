package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("二叉搜索树中的搜索")
class LeetCode_700_searchBSTTest {
    private final LeetCode_700_searchBST leetCode700SearchBST = new LeetCode_700_searchBST();


    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, int val, TreeNode expectedResult) {
        TreeNode actResult = leetCode700SearchBST.searchBST(root, val);
        if (expectedResult == null) {
            Assertions.assertNull(actResult);
        } else {
            Assertions.assertArrayEquals(expectedResult.preIntegerList().toArray(), actResult.preIntegerList().toArray());
        }
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(List.of(4, 2, 7, 1, 3)), 2, TreeNode.build(List.of(2, 1, 3))),
                arguments(TreeNode.build(List.of(4, 2, 7, 1, 3)), 5, TreeNode.build(List.of()))
        );
    }


}