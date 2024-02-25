package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 */
public class LeetCode_101_isSymmetric {

    /**
     * 遍历法
     * 时间复杂度：
     * 空间复杂度：
     */
    public boolean isSymmetric01(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root.left, root.right);
    }

    /**
     * 判断当前二叉树是否满足对称
     */
    private boolean helper(TreeNode left, TreeNode right) {
        // 把终结状态的情况拿来跑一遍
        if (left == null && right == null) {
            return true;
        }
        else if (left == null || right == null) {
            return false;
        }
        else if (left.val != right.val) {
            return false;
        }

        // 接着比较俩个左右子树是否对称
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
