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

@DisplayName("二叉树的中序遍历")
class LeetCode_094_inorderTraversalTest {
    private final LeetCode_094_inorderTraversal leetCode094InorderTraversal = new LeetCode_094_inorderTraversal();

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, List<Integer> expectedResult) {
        List<Integer> actResult = leetCode094InorderTraversal.inorderTraversal01(root);
        Assertions.assertArrayEquals(expectedResult.toArray(), actResult.toArray());
    }

    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(TreeNode root, List<Integer> expectedResult) {
        List<Integer> actResult = leetCode094InorderTraversal.inorderTraversal02(root);
        Assertions.assertArrayEquals(expectedResult.toArray(), actResult.toArray());
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(Arrays.asList(1, null, 2, null, null, 3)), Arrays.asList(1, 3, 2)),
                arguments(TreeNode.build(List.of()), List.of()),
                arguments(TreeNode.build(List.of(1)), List.of(1))
        );
    }

}