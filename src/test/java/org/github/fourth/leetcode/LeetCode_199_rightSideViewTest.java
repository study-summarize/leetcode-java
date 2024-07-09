package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("199. 二叉树的右视图")
class LeetCode_199_rightSideViewTest {
    private final LeetCode_199_rightSideView instance = new LeetCode_199_rightSideView();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, List<Integer> expectedResult) {
        List<Integer> actResult = instance.rightSideView(root);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(1, 2, 3, null, 5, null, 4), Arrays.asList(1, 3, 4)),
                arguments(TreeNode.build(1, null, 3), Arrays.asList(1, 3)),
                arguments(TreeNode.build(), List.of())
        );
    }
}