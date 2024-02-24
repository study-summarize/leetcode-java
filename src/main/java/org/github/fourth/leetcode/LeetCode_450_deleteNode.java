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
        // 代码里用到里递归，就没办法存这个root的临时变量值；且不需要用到循环，递归里面就有循环了
        // TreeNode currentNode = root;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        // 找到要删除的节点
        else {
            // 1、当前节点无左右子树
            // 删除当前节点
            if (root.left == null && root.right == null) {
                root = null;
            }
            // 2、当前节点左子树为空时，右子树不为空
            // 将右子树赋值给当前节点
            else if (root.left == null) {
                root = root.right;
            }
            // 3、当前节点右子树为空时，左子树不为空
            // 将左子树赋值给当前节点
            else if (root.right == null) {
                root = root.left;
            }
            // 4、当前节点左右子树均不为空时
            // (1)找出右子树的最小值；(2)当前节点值替换成右子树的最小值；(3)右子树删除最小值
            else {
                TreeNode minNode = findMin(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right, minNode.val);
            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
