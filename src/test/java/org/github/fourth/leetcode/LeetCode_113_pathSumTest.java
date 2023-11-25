package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("路径总和 II")
class LeetCode_113_pathSumTest {
    private final LeetCode_113_pathSum pathSum = new LeetCode_113_pathSum();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(TreeNode root, int targetSum, List<List<Integer>> expectedResult) {
        List<List<Integer>> actResult = pathSum.pathSum(root, targetSum);
        Assertions.assertArrayEquals(expectedResult.toArray(), actResult.toArray());
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22, List.of(List.of(5, 4, 11, 2), List.of(5, 8, 4, 5))),
                arguments(TreeNode.build(1, 2, 3), 5, List.of(List.of())),
                arguments(TreeNode.build(1, 2), 0, List.of())
        );
    }
}