package org.github.fourth.leetcode;

import org.github.fourth.Top100;
import org.github.fourth.leetcode.common.TreeNode;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 * - 节点的左子树只包含 小于 当前节点的数。
 * - 节点的右子树只包含 大于 当前节点的数。
 * - 所有左子树和右子树自身必须也是二叉搜索树。
 */
@Top100
public class LeetCode_098_isValidBST {
    /**
     * 分治法
     * 时间复杂度：
     * 空间复杂度：
     */
    public boolean isValidBST01(TreeNode root) {
        if (root == null) {
            return true;
        }

        // Divide
        boolean leftIsValidBST = isValidBST01(root.left);
        boolean rightIsValidBST = isValidBST01(root.right);

        // Combine
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        return leftIsValidBST && rightIsValidBST;
    }

    public boolean isValidBST02(TreeNode root) {
        if (root == null) {
            return true;
        }

        return judgeIsBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean judgeIsBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (val <= min || val >= max) {
            return false;
        }
        return judgeIsBST(root.left, min, root.val)
                && judgeIsBST(root.right, root.val, max);
    }
}
