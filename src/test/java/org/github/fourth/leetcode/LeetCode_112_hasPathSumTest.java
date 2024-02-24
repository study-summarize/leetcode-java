package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("路径总和")
class LeetCode_112_hasPathSumTest {
    private final LeetCode_112_hasPathSum leetCode112HasPathSum = new LeetCode_112_hasPathSum();


    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, int targetSum, boolean expectedResult) {
        boolean actResult = leetCode112HasPathSum.hasPathSum01(root, targetSum);
        Assertions.assertEquals(expectedResult, actResult);
    }

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(TreeNode root, int targetSum, boolean expectedResult) {
        boolean actResult = leetCode112HasPathSum.hasPathSum02(root, targetSum);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1)), 22, true),
                arguments(TreeNode.build(List.of(1, 2, 3)), 5, false),
                arguments(TreeNode.build(List.of()), 0, false)
        );
    }


}