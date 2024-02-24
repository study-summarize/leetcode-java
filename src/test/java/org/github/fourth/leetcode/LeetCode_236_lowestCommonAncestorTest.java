package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("二叉树的最近公共祖先")
class LeetCode_236_lowestCommonAncestorTest {
    private final LeetCode_236_lowestCommonAncestor leetCode236LowestCommonAncestor = new LeetCode_236_lowestCommonAncestor();


    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, TreeNode p, TreeNode q, int expectedResult) {
        TreeNode actResult = leetCode236LowestCommonAncestor.lowestCommonAncestor01(root, p, q);
    }

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test02(TreeNode root, TreeNode p, TreeNode q, int expectedResult) {
        TreeNode actResult = leetCode236LowestCommonAncestor.lowestCommonAncestor02(root, p, q);
    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(
                        TreeNode.build(List.of(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)),
                        TreeNode.build(List.of(5, 6, 2, null, null, 7, 4)),
                        TreeNode.build(List.of(1, 0, 8)),
                        3
                ),
                arguments(
                        TreeNode.build(List.of(3,5,1,6,2,0,8,null,null,7,4)),
                        TreeNode.build(List.of(5, 6, 2, null, null, 7, 4)),
                        TreeNode.build(List.of(4)),
                        5
                ),
                arguments(
                        TreeNode.build(List.of(1,2)),
                        TreeNode.build(List.of(1)),
                        TreeNode.build(List.of(2)),
                        1
                )
        );
    }


}