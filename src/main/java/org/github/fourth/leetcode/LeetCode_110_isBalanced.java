package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class LeetCode_110_isBalanced {
    /**
     * 分治法
     * 时间复杂度：
     * 空间复杂度：
     */
    public boolean isBalanced01(TreeNode root) {
        if (root == null) {
            return true;
        }

        // Divide
        boolean leftIsBalance = isBalanced01(root.left);
        boolean rightIsBalance = isBalanced01(root.right);

        // combine
        if (!leftIsBalance || !rightIsBalance) {
            return false;
        }

        int leftMaxHeight = getMaxHeight(root.left);
        int rightMaxHeight = getMaxHeight(root.right);

        return Math.abs(leftMaxHeight - rightMaxHeight) <= 1;
    }

    /**
     * 分治法优化：从上到下，先计算高度
     */
    public boolean isBalanced01Refine(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftMaxHeight = getMaxHeight(root.left);
        int rightMaxHeight = getMaxHeight(root.right);
        if (Math.abs(leftMaxHeight - rightMaxHeight) > 1) {
            return false;
        }

        return isBalanced01Refine(root.left) && isBalanced01Refine(root.right);
    }

    private int getMaxHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getMaxHeight(root.left), getMaxHeight(root.right)) + 1;
    }


    /**
     * 不好理解，这个方法
     */
    public boolean isBalanced01Best(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        // 一直让其递归到叶子节点，然后从叶子节点判断其是否为高度平衡二叉树
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }


}
