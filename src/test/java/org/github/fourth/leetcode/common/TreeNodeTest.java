package org.github.fourth.leetcode.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


@DisplayName("二叉树的层序构建")
class TreeNodeTest {

    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        TreeNode build = TreeNode.build(list);

        System.out.println(build);

    }
}