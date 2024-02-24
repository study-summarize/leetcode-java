package org.github.fourth.leetcode;

import org.github.fourth.VerifyUtils;
import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("从中序与后序遍历序列构造二叉树")
class LeetCode_106_buildTreeTest {
    private final LeetCode_106_buildTree leetCode106BuildTree = new LeetCode_106_buildTree();


    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(int[] inorder, int[] postorder, TreeNode expectedResult) {
        TreeNode actResult = leetCode106BuildTree.buildTreeExample(inorder, postorder);
        VerifyUtils.assertTreeEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3}, TreeNode.build(Arrays.asList(3, 9, 20, null, null, 15, 7))),
                arguments(new int[]{-1}, new int[]{-1}, TreeNode.build(List.of(-1)))
        );
    }

}