package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("114. 二叉树展开为链表")
class LeetCode_114_flattenTest {
    private final LeetCode_114_flatten instance = new LeetCode_114_flatten();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, TreeNode expectedResult) {
        instance.flatten(root);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(
                        TreeNode.build(1, 2, 5, 3, 4, null, 6),
                        TreeNode.build(1, null, 2, null, 3, null, 4, null, 5, null, 6)
                ),
                arguments(TreeNode.build(), TreeNode.build()),
                arguments(TreeNode.build(0), TreeNode.build(0))
        );
    }

}