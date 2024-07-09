package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("230. 二叉搜索树中第K小的元素")
class LeetCode_230_kthSmallestTest {
    private final LeetCode_230_kthSmallest instance = new LeetCode_230_kthSmallest();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, int k, int expectedResult) {
        int actResult = instance.kthSmallest(root, k);
        Assertions.assertEquals(actResult, expectedResult);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(3, 1, 4, null, 2), 1, 1),
                arguments(TreeNode.build(5, 3, 6, 2, 4, null, null, 1), 3, 3)
        );
    }

}