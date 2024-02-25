package org.github.fourth.leetcode;

import org.github.fourth.VerifyUtils;
import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("翻转二叉树")
class LeetCode_226_invertTreeTest {
    private final LeetCode_226_invertTree leetCode226InvertTree = new LeetCode_226_invertTree();


    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, TreeNode expectedResult) {
        TreeNode actResult = leetCode226InvertTree.invertTree01(root);
        VerifyUtils.assertTreeEquals(expectedResult, actResult);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(TreeNode root, TreeNode expectedResult) {
        TreeNode actResult = leetCode226InvertTree.invertTree02(root);
        VerifyUtils.assertTreeEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(List.of(4, 2, 7, 1, 3, 6, 9)), TreeNode.build(List.of(4, 7, 2, 9, 6, 3, 1))),
                arguments(TreeNode.build(List.of(2, 1, 3)), TreeNode.build(List.of(2, 3, 1))),
                arguments(TreeNode.build(List.of()), TreeNode.build(List.of()))
        );
    }

}