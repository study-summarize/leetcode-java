package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("二叉树的后序遍历")
class LeetCode_145_postorderTraversalTest {
    private final LeetCode_145_postorderTraversal leetCode145PostorderTraversal = new LeetCode_145_postorderTraversal();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, List<Integer> expectedResult) {
        List<Integer> actResult = leetCode145PostorderTraversal.postorderTraversal(root);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(Arrays.asList(1, null, 2, 3)), Arrays.asList(3, 2, 1)),
                arguments(TreeNode.build(List.of()), List.of()),
                arguments(TreeNode.build(List.of(1)), List.of(1))
        );
    }

}