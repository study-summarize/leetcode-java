package org.github.fourth.leetcode;

import org.github.fourth.leetcode.common.TreeNode;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 */
public class LeetCode_112_hasPathSum {
    /**
     * 分治法
     * 时间复杂度：
     * 空间复杂度：
     */
    public boolean hasPathSum01(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        // 叶子节点直接在这里结束。因为传入null，一定就是false，那整颗树就一定是false
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        int newTargetSum = targetSum - root.val;
        boolean leftHasPathSum = hasPathSum01(root.left, newTargetSum);
        boolean rightHasPathSum = hasPathSum01(root.right, newTargetSum);

        return leftHasPathSum || rightHasPathSum;
    }

    public boolean hasPathSum02(TreeNode root, int targetSum) {
        return false;
    }
}
