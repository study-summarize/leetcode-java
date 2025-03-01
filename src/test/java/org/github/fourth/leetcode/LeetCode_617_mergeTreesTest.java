package org.github.fourth.leetcode;

import org.github.fourth.VerifyUtils;
import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class LeetCode_617_mergeTreesTest {
    private final LeetCode_617_mergeTrees instance = new LeetCode_617_mergeTrees();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root1, TreeNode root2, TreeNode expectedResult) {
        TreeNode actResult = instance.mergeTrees(root1, root2);
        VerifyUtils.assertTreeEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(1, 3, 2, 5), TreeNode.build(2, 1, 3, null, 4, null, 7), TreeNode.build(3, 4, 5, 5, 4, null, 7)),
                arguments(TreeNode.build(1, 2), TreeNode.build(1), TreeNode.build(2, 2))
        );
    }

}