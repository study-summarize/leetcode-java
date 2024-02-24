package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("二叉树的最小深度")
class LeetCode_111_minDepthTest {
    private final LeetCode_111_minDepth minDepth = new LeetCode_111_minDepth();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, int expectedResult) {
        int actResult = minDepth.minDepth01(root);
        Assertions.assertEquals(expectedResult, actResult);
    }
    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(TreeNode root, int expectedResult) {
        int actResult = minDepth.minDepth02(root);
        Assertions.assertEquals(expectedResult, actResult);
    }
    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(TreeNode root, int expectedResult) {
        int actResult = minDepth.minDepthExample(root);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(List.of(3, 9, 20, null, null, 15, 7)), 2),
                arguments(TreeNode.build(List.of(2, null, 3, null, 4, null, 5, null, 6)), 5)
        );
    }
}