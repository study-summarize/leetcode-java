package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class LeetCode_226_invertTree {
    /**
     * 分治法
     * 时间复杂度：
     * 空间复杂度：
     */
    public TreeNode invertTree01(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Divide
        TreeNode nowRight = invertTree01(root.left);
        TreeNode nowLeft = invertTree01(root.right);
        // Combine
        root.right = nowRight;
        root.left = nowLeft;
        return root;
    }
    /**
     * 遍历法
     *
     */
    public TreeNode invertTree02(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 通常都需要一个helper函数；这题不需要计数，所以不需要额外的变量来记录
        helper(root);
        return root;
    }

    /**
     * 将当前root的二叉树进行翻转
     */
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode newRight = root.left;
        TreeNode newLeft = root.right;
        helper(root.left);
        helper(root.right);

        root.left = newLeft;
        root.right = newRight;
    }
}
