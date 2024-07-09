package org.github.fourth.leetcode;

import org.github.fourth.Top100;
import org.github.fourth.leetcode.common.TreeNode;

/**
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
@Top100
public class LeetCode_124_maxPathSum {
    /**
     * 时间复杂度：
     * 空间复杂度：
     */
    public int maxPathSum01(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Divide
        int leftMaxPath = maxPathSum01(root.left);
        int rightMaxPath = maxPathSum01(root.right);

        // Combine
        return leftMaxPath + rightMaxPath + root.val;
    }

    public int maxPathSum02(TreeNode root) {
        return 0;
    }
}
