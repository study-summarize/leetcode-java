package org.github.fourth.leetcode;

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

@DisplayName("二叉树中的最大路径和")
class LeetCode_124_maxPathSumTest {
    private final LeetCode_124_maxPathSum leetCode124MaxPathSum = new LeetCode_124_maxPathSum();


//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, int expectedResult) {
        int actResult = leetCode124MaxPathSum.maxPathSum01(root);
        Assertions.assertEquals(expectedResult, actResult);
    }

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(TreeNode root, int expectedResult) {
        int actResult = leetCode124MaxPathSum.maxPathSum02(root);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(List.of(2, 1, 3)), 6),
                arguments(TreeNode.build(Arrays.asList(-10, 9, 20, null, null, 15, 7)), 42)
        );
    }

}