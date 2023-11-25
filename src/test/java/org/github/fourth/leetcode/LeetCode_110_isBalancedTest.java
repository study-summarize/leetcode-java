package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("平衡二叉树")
class LeetCode_110_isBalancedTest {
    private final LeetCode_110_isBalanced leetCode110IsBalanced = new LeetCode_110_isBalanced();


    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, boolean expectedResult) {
        boolean actResult = leetCode110IsBalanced.isBalanced(root);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(List.of(3, 9, 20, null, null, 15, 7)), true),
                arguments(TreeNode.build(List.of(1, 2, 2, 3, 3, null, null, 4, 4)), false),
                arguments(TreeNode.build(List.of()), true)
        );
    }


}