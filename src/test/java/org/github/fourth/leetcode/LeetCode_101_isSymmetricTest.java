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

@DisplayName("对称二叉树")
class LeetCode_101_isSymmetricTest {
    private final LeetCode_101_isSymmetric leetCode101IsSymmetric = new LeetCode_101_isSymmetric();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, boolean expectedResult) {
        boolean actResult = leetCode101IsSymmetric.isSymmetric01(root);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(List.of(1, 2, 2, 3, 4, 4, 3)), true),
                arguments(TreeNode.build(Arrays.asList(1, 2, 2, null, 3, null, 3)), false)
        );
    }


}