package org.github.fourth.leetcode.common;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.List;

@SuppressFBWarnings({"URF_UNREAD_FIELD", "URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"})
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 左边序列
     */
    // todo: 如何构建？？？
    public static TreeNode build(List<Integer> list) {
        TreeNode result = new TreeNode(list.get(0));
        return result;
    }
}
