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

@DisplayName("验证二叉搜索树")
class LeetCode_098_isValidBSTTest {
    private final LeetCode_098_isValidBST leetCode098IsValidBST = new LeetCode_098_isValidBST();


//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, boolean expectedResult) {
        boolean actResult = leetCode098IsValidBST.isValidBST01(root);
        Assertions.assertEquals(expectedResult, actResult);
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(TreeNode root, boolean expectedResult) {
        boolean actResult = leetCode098IsValidBST.isValidBST02(root);
        Assertions.assertEquals(expectedResult, actResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(List.of(2, 1, 3)), true),
                arguments(TreeNode.build(Arrays.asList(5, 4, 6, null, null, 3, 7)), false),
                arguments(TreeNode.build(Arrays.asList(5, 1, 4, null, null, 3, 6)), false)
        );
    }
}
