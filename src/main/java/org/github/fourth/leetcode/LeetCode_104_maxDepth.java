package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;

/**
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 */
public class LeetCode_104_maxDepth {
    /**
     * 分治法
     */
    public int maxDepth01(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHigh = maxDepth01(root.left);
        int rightHigh = maxDepth01(root.right);
        return Math.max(leftHigh, rightHigh) + 1;
    }

    private int result = 0;

    /**
     * 遍历法
     * 从上到下开始走
     */
    public int maxDepth02(TreeNode root) {
        if (root == null) {
            return 0;
        }

        helper(root, 1);
        return result;
    }

    /**
     * 辅助函数
     * @param root  当前结点
     * @param high  当前结点的深度
     */
    private void helper(TreeNode root, int high) {
        if (root == null) {
            return;
        }

        // 为什么要放在前面处理？放在后面可能会 虚假 加1
        if (result < high) {
            result = high;
        }

        helper(root.left, high + 1);
        helper(root.right, high + 1);
    }
}
