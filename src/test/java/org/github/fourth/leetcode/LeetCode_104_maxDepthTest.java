package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("二叉树的最大深度")
class LeetCode_104_maxDepthTest {
    private final LeetCode_104_maxDepth leetCode104MaxDepth = new LeetCode_104_maxDepth();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, int expectedResult) {
        int actResult = leetCode104MaxDepth.maxDepth01(root);
        Assertions.assertEquals(expectedResult, actResult);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(TreeNode root, int expectedResult) {
        int actResult = leetCode104MaxDepth.maxDepth02(root);
        Assertions.assertEquals(expectedResult, actResult);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test03(TreeNode root, int expectedResult) {
        int actResult = leetCode104MaxDepth.maxDepth03(root);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(Arrays.asList(3, 9, 20, null, null, 15, 7)), 3),
                arguments(TreeNode.build(Arrays.asList(1, null, 2)), 2)
        );
    }
}