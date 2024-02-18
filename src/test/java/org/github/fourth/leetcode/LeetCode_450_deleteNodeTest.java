package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("删除二叉搜索树中的节点")
class LeetCode_450_deleteNodeTest {
    private final LeetCode_450_deleteNode leetCode450DeleteNode = new LeetCode_450_deleteNode();

    //    @ParameterizedTest
    @MethodSource("generateRightCase")
    public void test01(TreeNode root, int key, TreeNode expectedResult) {
        TreeNode actResult = leetCode450DeleteNode.deleteNode(root, key);

    }

    public static Stream<Arguments> generateRightCase() {
        return Stream.of(
                arguments(TreeNode.build(Arrays.asList(5, 3, 6, 2, 4, null, 7)), 3, TreeNode.build(Arrays.asList(5, 4, 6, 2, null, null, 7))),
                arguments(TreeNode.build(Arrays.asList(5, 3, 6, 2, 4, null, 7)), 0, TreeNode.build(Arrays.asList(5, 3, 6, 2, 4, null, 7))),
                arguments(TreeNode.build(List.of()), 0, TreeNode.build(List.of()))
        );
    }

}