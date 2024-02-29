package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("求根节点到叶节点数字之和")
class LeetCode_129_sumNumbersTest {
    private final LeetCode_129_sumNumbers sumNumbers = new LeetCode_129_sumNumbers();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, int expectedResult) {
        int actResult = sumNumbers.sumNumbers01(root);
        Assertions.assertEquals(expectedResult, actResult);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(TreeNode root, int expectedResult) {
        int actResult = sumNumbers.sumNumbersExample(root);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(1, 2, 3), 25),
                arguments(TreeNode.build(4, 9, 0, 5, 1), 1026)
        );
    }
}