package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("二叉搜索树中的插入操作")
class LeetCode_701_insertIntoBSTTest {
    private final LeetCode_701_insertIntoBST leetCode701InsertIntoBST = new LeetCode_701_insertIntoBST();


    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, int val, TreeNode expectedResult) {
        TreeNode actResult = leetCode701InsertIntoBST.insertIntoBST(root, val);

    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(List.of(4, 2, 7, 1, 3)), 5, TreeNode.build(List.of(4, 2, 7, 1, 3, 5))),
                arguments(TreeNode.build(List.of(40, 20, 60, 10, 30, 50, 70)), 25, TreeNode.build(List.of(40, 20, 60, 10, 30, 50, 70, null, null, 25))),
                arguments(TreeNode.build(List.of(4, 2, 7, 1, 3, null, null, null, null, null, null)), 5, TreeNode.build(List.of(4, 2, 7, 1, 3, 5)))
        );
    }


}