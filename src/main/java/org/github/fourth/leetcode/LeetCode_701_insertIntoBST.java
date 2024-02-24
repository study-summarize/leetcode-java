package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;

/**
 * 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 */
public class LeetCode_701_insertIntoBST {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode currentNode = root;
        while (currentNode != null) {
            if (currentNode.val == val) {
                return root;
            } else if (currentNode.val > val) {
                if (currentNode.left == null) {
                    currentNode.left = new TreeNode(val);
                    return root;
                }
                currentNode = currentNode.left;
            } else {
                if (currentNode.right == null) {
                    currentNode.right = new TreeNode(val);
                    return root;
                }
                currentNode = currentNode.right;
            }
        }
        return root;
    }
}
