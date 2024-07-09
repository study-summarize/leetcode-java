package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("108. 将有序数组转换为二叉搜索树")
class LeetCode_108_sortedArrayToBSTTest {
    private final LeetCode_108_sortedArrayToBST instance = new LeetCode_108_sortedArrayToBST();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(int[] nums, TreeNode expectedResult) {
        TreeNode actResult = instance.sortedArrayToBST(nums);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(
                        new int[]{-10, -3, 0, 5, 9},
                        TreeNode.build(0, -3, 9, -10, null, 5)
                ),
                arguments(
                        new int[]{1, 3},
                        TreeNode.build(3, 1)
                )
        );
    }

}