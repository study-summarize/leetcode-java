package org.github.fourth.leetcode;

import org.github.fourth.VerifyUtils;
import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("437. 路径总和 III")
class LeetCode_437_pathSumTest {
    private final LeetCode_437_pathSum instance = new LeetCode_437_pathSum();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, int targetSum, int expectedResult) {
        int actResult = instance.pathSum(root, targetSum);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1), 8, 3),
                arguments(TreeNode.build(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22, 3)
        );
    }

}