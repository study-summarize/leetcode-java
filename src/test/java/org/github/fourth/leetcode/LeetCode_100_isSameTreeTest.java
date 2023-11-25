package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;


@DisplayName("相同的树")
class LeetCode_100_isSameTreeTest {
    private final LeetCode_100_isSameTree leetCode100IsSameTree = new LeetCode_100_isSameTree();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode p, TreeNode q, boolean expectedResult) {
        boolean actResult = leetCode100IsSameTree.isSameTree(p, q);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(List.of(1, 2, 3)), TreeNode.build(List.of(1, 2, 3)), true),
                arguments(TreeNode.build(List.of(1, 2)), TreeNode.build(List.of(1, null, 2)), false),
                arguments(TreeNode.build(List.of(1, 2, 1)), TreeNode.build(List.of(1, 1, 2)), false)
        );
    }
}
