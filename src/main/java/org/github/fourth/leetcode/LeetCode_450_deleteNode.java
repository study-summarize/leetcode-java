package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * - 首先找到需要删除的节点；
 * - 如果找到了，删除它。
 */
public class LeetCode_450_deleteNode {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        TreeNode current = root;

        return root;
    }
}
