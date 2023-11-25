package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;


@DisplayName("二叉树的层序遍历")
class LeetCode_102_levelOrderTest {
    private final LeetCode_102_levelOrder levelOrder = new LeetCode_102_levelOrder();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(TreeNode root, List<List<Integer>> expectedResult) {
        List<List<Integer>> actResult = levelOrder.levelOrder(root);
        Assertions.assertArrayEquals(expectedResult.toArray(), actResult.toArray());
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(3, 9, 20, null, null, 15, 7), List.of(List.of(3), List.of(9, 20), List.of(15, 7))),
                arguments(TreeNode.build(1), List.of(List.of(1))),
                arguments(TreeNode.build(), List.of())
        );
    }
}