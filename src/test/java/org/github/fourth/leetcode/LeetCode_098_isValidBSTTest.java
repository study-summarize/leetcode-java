package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("验证二叉搜索树")
class LeetCode_098_isValidBSTTest {
    private final LeetCode_098_isValidBST leetCode098IsValidBST = new LeetCode_098_isValidBST();


    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, boolean expectedResult) {
        boolean actResult = leetCode098IsValidBST.isValidBST(root);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(List.of(2, 1, 3)), true),
                arguments(TreeNode.build(List.of(5, 1, 4, null, null, 3, 6)), false)
        );
    }
}
