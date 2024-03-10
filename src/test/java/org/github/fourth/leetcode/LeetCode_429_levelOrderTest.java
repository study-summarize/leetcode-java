package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;


@DisplayName("N 叉树的层序遍历")
class LeetCode_429_levelOrderTest {
    private final LeetCode_429_levelOrder levelOrder = new LeetCode_429_levelOrder();

//    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test(TreeNode2 root, List<List<Integer>> expectedResult) {
        List<List<Integer>> actResult = levelOrder.levelOrder01(root);
        Assertions.assertArrayEquals(expectedResult.toArray(), actResult.toArray());
    }
    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void testExample(TreeNode2 root, List<List<Integer>> expectedResult) {
        List<List<Integer>> actResult = levelOrder.levelOrderExample(root);
        Assertions.assertArrayEquals(expectedResult.toArray(), actResult.toArray());
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                Arguments.arguments(TreeNode2.buildNTree(new HashMap<>() {{
                    put(1, List.of(3, 2, 4));
                    put(3, List.of(5, 6));
                }}, 1), List.of(List.of(1), List.of(3, 2, 4), List.of(5, 6)))
        );

    }
}