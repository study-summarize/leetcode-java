package org.github.fourth.leetcode;

import org.github.fourth.VerifyUtils;
import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("543. 二叉树的直径")
class LeetCode_543_diameterOfBinaryTreeTest {
    private final LeetCode_543_diameterOfBinaryTree instance = new LeetCode_543_diameterOfBinaryTree();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, int expectedResult) {
        int actResult = instance.diameterOfBinaryTree(root);
        Assertions.assertEquals(actResult, expectedResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(1, 2, 3, 4, 5), 3),
                arguments(TreeNode.build(1, 2), 1)
        );
    }
}