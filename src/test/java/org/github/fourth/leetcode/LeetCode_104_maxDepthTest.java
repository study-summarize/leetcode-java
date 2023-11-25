package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("二叉树的最大深度")
class LeetCode_104_maxDepthTest {
    private final LeetCode_104_maxDepth leetCode104MaxDepth = new LeetCode_104_maxDepth();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, int expectedResult) {
        int actResult = leetCode104MaxDepth.maxDepth(root);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(List.of(3, 9, 20, null, null, 15, 7)), 3),
                arguments(TreeNode.build(List.of(1, null, 2)), 2)
        );
    }
}