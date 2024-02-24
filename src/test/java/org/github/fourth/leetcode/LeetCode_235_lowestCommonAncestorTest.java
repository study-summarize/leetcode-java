package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("二叉搜索树的最近公共祖先")
class LeetCode_235_lowestCommonAncestorTest {
    private final LeetCode_235_lowestCommonAncestor leetCode235LowestCommonAncestor = new LeetCode_235_lowestCommonAncestor();


    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, TreeNode p, TreeNode q, int expectedResult) {
        TreeNode actResult = leetCode235LowestCommonAncestor.lowestCommonAncestor01(root, p, q);
    }

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(TreeNode root, TreeNode p, TreeNode q, int expectedResult) {
        TreeNode actResult = leetCode235LowestCommonAncestor.lowestCommonAncestor02(root, p, q);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(
                        TreeNode.build(Arrays.asList(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5)),
                        TreeNode.build(Arrays.asList(2, 0, 4, null, null, 3, 5)),
                        TreeNode.build(List.of(8, 7, 9)),
                        6
                ),
                arguments(
                        TreeNode.build(Arrays.asList(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5)),
                        TreeNode.build(Arrays.asList(2, 0, 4, null, null, 3, 5)),
                        TreeNode.build(List.of(4, 3, 5)),
                        2
                )
        );
    }

}