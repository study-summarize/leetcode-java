package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class LeetCode_662_widthOfBinaryTreeTest {
    private LeetCode_662_widthOfBinaryTree instance = new LeetCode_662_widthOfBinaryTree();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, int expectedResult) {
        int actResult = instance.widthOfBinaryTree(root);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(1, 3, 2, 5, 3, null, 9), 4)
        );
    }

}